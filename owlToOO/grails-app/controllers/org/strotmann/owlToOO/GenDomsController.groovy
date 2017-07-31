package org.strotmann.owlToOO

import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.*

class GenDomsController {
	
    def index() { 
		def org.springframework.web.multipart.commons.CommonsMultipartFile f = request.getFile('file')
		String fileName = f.getOriginalFilename()
		if (!f.getOriginalFilename().contains('.owl')) {
			flash.messageF = "ungültiger Dateiname ${f.getOriginalFilename()}, nur xxxxxx.owl erlaubt"
			redirect(uri: "/")
			return
		}
		
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		f.transferTo(new File(f.getOriginalFilename()))
		File file = new File(f.getOriginalFilename())
		// Now load the local copy
		OWLOntology localOwl = manager.loadOntologyFromOntologyDocument(file)
		flash.message1 = localOwl
		
		//Einlesen der Axiome der Ontologie in eine Liste,
		List klassen = klassenListe(localOwl)
					
		//grails Input erstellen
		session.klassenNamen = genGroovy(klassen)
		
		//graphViz Input erstellen
		session.gvInName = fileName.replace(".owl", ".gv")
		BufferedWriter gvIn = bufFile(session.gvInName)
		genGraphviz(gvIn, klassen)
		
		redirect(uri: "/")
	}
	
	def downloadGroovy() {
		String klassenName = params.klassenName
		downloadFile(klassenName)
	}
	
	def downloadGraphViz() {
		String gvInName = session.gvInName
		downloadFile(gvInName)
	}
	

	private genGraphviz(BufferedWriter gvIn, List klassen) {
		gvIn.writeLine("digraph hierarchy {")
		gvIn.writeLine("size=10")
		gvIn.writeLine("ratio = 0.5")
		gvIn.writeLine("node[shape=record,style=filled,fillcolor=gray95]")
		gvIn.writeLine("edge[arrowhead=empty]")
		gvIn.writeLine("graph [size=10, ranksep=1.0, nodesep=1.0, overlap=false]")
		//je Klasse eine Zeile label
		//nodes
		Integer iLabel = 0
		Map labels = [:]
		klassen.each {
			iLabel++
			Map m = it
			labels [m.Klasse] = iLabel.toString()
			String attrS = ""
			String checkS = ""
			m.Pflichtfelder.each{List feldList ->
				attrS += "${feldList[0]}:${feldList[1]}\\n "
			}
			m.Kannfelder.each{List feldList ->
				attrS += "${feldList[0]}:${feldList[1]}\\n "
			}
			if (m.PflichtWerteklassen){
				List l = m.PflichtWerteklassen
				Integer n = l.size()
				Integer i = 0
				while (i < n) {
					attrS += "${l[i]}:string\\n "
					checkS += "Check${l[i]}:boolean\\n "
					i=i+2
				}
			}
			if (m.KannWerteklassen){
				List l = m.KannWerteklassen
				Integer n = l.size()
				Integer i = 0
				while (i < n) {
					attrS += "${l[i]}:string\\n "
					checkS += "check${l[i]}:boolean\\n "
					i=i+2
				}
			}
			gvIn.writeLine(iLabel.toString()+'[label = "{'+"${m.Klasse}"+'|'+"${attrS}"+'|'+"${checkS}"+'}"]')
		}
		//edges
		iLabel = 0
		klassen.each {
			iLabel++
			Map m = it
			if (m.UnterklasseVon)
				gvIn.writeLine(iLabel.toString()+"->"+labels[m.UnterklasseVon])
			if (m.belongsTo)
				gvIn.writeLine(iLabel.toString()+"->"+labels[m.belongsTo]+'[arrowhead=none,arrowtail=none, headlabel="1", taillabel="0..n"]')
			m.KannAssoziationen.each {String a ->
				gvIn.writeLine(labels[a]+"->"+iLabel.toString()+'[arrowhead=none,arrowtail=none, headlabel="0..n", taillabel="0..1"]')
			}
		}
		gvIn.writeLine("}")
		gvIn.close()
		
	}

	private <String> List genGroovy(List klassen) {
		List <String> klassenNamen = []
		klassen.each {
			Map m = it
			klassenNamen += m.Klasse+".groovy"
			BufferedWriter d = bufFile(m.Klasse+".groovy")

			d.writeLine("package ${m.Paketname}")

			String extKlausel = "${m.UnterklasseVon?'extends '+m.UnterklasseVon:''}"
			d.writeLine("class ${m.Klasse} ${extKlausel} {")

			if (istOberklasse (m.Klasse.toString(), klassen)) {
				d.writeLine("    static mapping = {tablePerHierarchy false}")
			}
			if (m.hasMany) {
				Map hasManyMap = [:]
				m.hasMany.each {
					String mapKey = it
					String mapWert = it
					hasManyMap[mapKey.toLowerCase()] = mapWert
				}
				d.writeLine("    static hasMany="+hasManyMap)
			}

			if (m.belongsTo) {
				String b = m.belongsTo
				d.writeLine("    static belongsTo = [${b.toLowerCase()}:${b}]")
			}

			List <String> constr = []
			List <String> overWr = []

			if (m.Pflichtfelder){
				m.Pflichtfelder.each{List feldList ->
					String fTyp = feldList[1]
					if (fTyp.equals("dateTime"))
						fTyp = "Date"
					fTyp = fTyp.substring(0, 1).toUpperCase()+fTyp.substring(1)
					d.writeLine("    "+fTyp+" "+feldList[0])
					constr += [feldList[0]+"()"]
					overWr += [feldList[0]]
				}
			}

			if (m.Kannfelder){
				m.Kannfelder.each{List feldList ->
					String fTyp = feldList[1]
					if (fTyp.equals("dateTime"))
						fTyp = "Date"
					fTyp = fTyp.substring(0, 1).toUpperCase()+fTyp.substring(1)
					d.writeLine("    "+fTyp+" "+feldList[0])
					constr += [feldList[0]+"(nullable:true)"]
				}
			}

			if (m.PflichtWerteklassen){
				List l = m.PflichtWerteklassen
				Integer n = l.size()
				Integer i = 0
				while (i < n) {
					String fName = l[i]
					fName = fName.substring(0, 1).toLowerCase()+fName.substring(1)
					d.writeLine("    String "+fName)
					List lStrings = []
					l[i+1].each {
						lStrings += ["'${it}'"]
					}
					constr += [fName+"(inList:${lStrings},nullable:true)"]
					overWr += [fName]
					i=i+2
				}
			}

			if (m.KannWerteklassen){
				List l = m.KannWerteklassen
				Integer n = l.size()
				Integer i = 0
				while (i < n) {
					String fName = l[i]
					fName = fName.substring(0, 1).toLowerCase()+fName.substring(1)
					d.writeLine("    String "+fName)
					List lStrings = []
					l[i+1].each {
						lStrings += ["'${it}'"]
					}
					constr += [fName+"(inList:${lStrings})"]
					i=i+2
				}
			}

			if (m.KannAssoziationen){
				m.KannAssoziationen.each {String a ->
					d.writeLine("    "+a+" "+a.toLowerCase())
					constr += [a.toLowerCase()+"(nullable:true)"]
				}
			}

			if (constr.size() > 0) {
				d.writeLine("    static constraints = {")
				constr.each {
					d.writeLine("      "+it)
				}
				d.writeLine("    }")
			}

			if (overWr.size() > 0 && !m.UnterklasseVon) {
				String outline = ''
				outline += '    String toString() {"'
				overWr.each {
					String s = "this.${it}"
					outline += '${'
					outline += s
					outline += ' '
					outline += '} '
				}
				outline += '    "}'
				d.writeLine(outline)
			}

			d.writeLine("}")
			d.close()
		}
		klassenNamen
	}

	private List klassenListe(OWLOntology localOwl) {
		//Die KlassenList enhält nach Anwendung der Umsetzungsregeln (i)...(iv)
		//alle Informationen zur Generierung der Klassen
		List klassen = []
		
		List <OWLAxiom> axiome = leseAxiome(localOwl)
		List <OWLAxiom> subAxiome = []
		axiome.each {OWLAxiom oA ->
			if (oA.getAxiomType().equals(AxiomType.SUBCLASS_OF))
				subAxiome << oA
			}
		println "----------------"
		println "subAxiome"
		subAxiome.sort().each{
			println it
		}
		List caAxiome = getClassAssertionAxioms(axiome)
		println "----------------"
		println "ClassAssertionAxioms"
		caAxiome.sort().each{
			println it
		}

		//Regel (i) zum Auffinden der Klassendeklarationen
		List <OWLClassExpression> klassenDecls = bildeKlassenDecls (axiome)
		println "----------------"
		println "ClassDeclarationen"
		klassenDecls.sort().each{
			println it
		}

		klassenDecls.each {OWLClassExpression oE ->
			String klName = oE.toString().split("#")[1].split(">")[0]
			String paketName = oE.toString().split("//")[1].split("#")[0]
			klassen += ["Klasse":"${klName}","Paketname":"${paketName}"]
		}

		//Regel (ii) zum Auffinden der Vererbungshierarchien, d.h. Oberklassen je Klasse
		subAxiome.each {OWLAxiom oA ->

			OWLClassExpression nr0 = oA.getNestedClassExpressions()[0]
			OWLClassExpression nr1 = oA.getNestedClassExpressions()[1]
			if (klassenDecls.contains(nr0) && klassenDecls.contains(nr1)) {
				Map sMap = getSubMap(klassen,norm(nr0))
				klassen.remove(sMap)
				sMap = sMap += ["UnterklasseVon":norm(nr1)]
				klassen += sMap
			}
		}

		//Regel (iii) zum Auffinden der Assoziationen
		subAxiome.each {OWLAxiom oA ->

			List <OWLClassExpression> l = [null, null]

			//(iiia) gehört eindeutig zu, später umgesetzt in belongsTo Klausel
			l = klassenPaar(oA, klassenDecls, ClassExpressionType.OBJECT_EXACT_CARDINALITY)
			if (l[0] && l[1]) {
				Map sMap = getSubMap(klassen,norm(l[0]))
				klassen.remove(sMap)
				sMap = sMap += ["belongsTo":norm(l[1])]
				klassen += sMap
			}
			//(iiib) hat ObjectSomeValuesFrom später umgesetzt in hasMany
			l = klassenPaar(oA, klassenDecls, ClassExpressionType.OBJECT_SOME_VALUES_FROM)
			Map sMap = null
			if (l[0] && l[1]) {
				sMap = getSubMap(klassen,norm(l[0]))
				List hasManyList = sMap["hasMany"]?:[]
				hasManyList += [norm(l[1])]
				klassen.remove(sMap)
				sMap = sMap += ["hasMany":hasManyList]
				klassen += sMap
			}

			//(iiic) hat ObjectMaxCardinality später umgesetzt in (kann) Verweis auf Objekt
			l = klassenPaar(oA, klassenDecls, ClassExpressionType.OBJECT_MAX_CARDINALITY)
			if (l[0] && l[1]) {
				sMap = getSubMap(klassen,norm(l[0]))
				List hasOneOrNoneList = sMap["KannAssoziationen"]?:[]
				hasOneOrNoneList += [norm(l[1])]
				klassen.remove(sMap)
				sMap = sMap += ["KannAssoziationen":hasOneOrNoneList]
				klassen += sMap
			}
		}

		//Regel (iv) zum Auffinden der Attribute je Klasse
		List <OWLClassExpression> valueKlassen = getValueKlassen(axiome)
		subAxiome.each {OWLAxiom oA ->
			//iv a ValueKlassen als Attribute
			List <OWLClassExpression> l = [null, null, null]
			oA.getNestedClassExpressions().each {OWLClassExpression cE ->
				if (klassenDecls.contains(cE))
					l[0] = cE
				if (valueKlassen.contains(cE))
					l[1] = cE
				if(cE.getClassExpressionType().equals(ClassExpressionType.OBJECT_EXACT_CARDINALITY)
				|| cE.getClassExpressionType().equals(ClassExpressionType.OBJECT_MAX_CARDINALITY))
					l[2] = cE.getClassExpressionType()
			}
			if (l[0] && l[1]) {
				Map sMap = getSubMap(klassen,norm(l[0]))
				if (l[2].equals(ClassExpressionType.OBJECT_EXACT_CARDINALITY)) {
					List hasExactOneList = sMap["PflichtWerteklassen"]?:[]
					hasExactOneList += [norm(l[1]),getWerte (caAxiome, norm(l[1]))]
					klassen.remove(sMap)
					sMap = sMap += ["PflichtWerteklassen":hasExactOneList]
					klassen += sMap
				}
				if (l[2].equals(ClassExpressionType.OBJECT_MAX_CARDINALITY)) {
					List hasMaxOneList = sMap["KannWerteklassen"]?:[]
					hasMaxOneList += [norm(l[1]),getWerte (caAxiome, norm(l[1]))]
					klassen.remove(sMap)
					sMap = sMap += ["KannWerteklassen":hasMaxOneList]
					klassen += sMap
				}

			}
			//iv b elementare Attribute
			l = [null, null, null, null]
			oA.getNestedClassExpressions().each {OWLClassExpression cE ->
				if (klassenDecls.contains(cE))
					l[0] = cE
			}
			oA.getNestedClassExpressions().each {OWLClassExpression cE ->
				if (!cE.getDataPropertiesInSignature().empty && !cE.getDatatypesInSignature().empty && cE.getClassesInSignature().empty){
					l[1] = cE.getDataPropertiesInSignature()[0]
					l[2] = cE.getDatatypesInSignature()[0]
					l[3] = cE.getClassExpressionType()
				}
			}
			if (l[0] && l[1] && l[2]) {
				Map sMap = getSubMap(klassen,norm(l[0]))

				if(l[3].equals(ClassExpressionType.DATA_EXACT_CARDINALITY)) {
					List hasExactOneAttr = sMap["Pflichtfelder"]?:[]
					hasExactOneAttr += [[norm(l[1]),l[2].toString().split(":")[1]]]
					klassen.remove(sMap)
					sMap = sMap += ["Pflichtfelder":hasExactOneAttr]
					klassen += sMap
				}
				if(l[3].equals(ClassExpressionType.DATA_MAX_CARDINALITY)) {
					List hasMaxOneAttr = sMap["Kannfelder"]?:[]
					hasMaxOneAttr += [[norm(l[1]),l[2].toString().split(":")[1]]]
					klassen.remove(sMap)
					sMap = sMap += ["Kannfelder":hasMaxOneAttr]
					klassen += sMap
				}
			}
		}
		return klassen
	}

	private List <OWLClassExpression> klassenPaar(OWLAxiom oA, List <OWLClassExpression> klassenDecls, ClassExpressionType t) {
		List l = [null, null]
		oA.getNestedClassExpressions().each {OWLClassExpression cE ->
			if (cE.getClassExpressionType().equals(t) &&
			klassenDecls.contains(cE.getClassesInSignature()[0]))
				l[1] = cE.getClassesInSignature()[0]
		}
		oA.getNestedClassExpressions().each {OWLClassExpression cE ->
			if (!cE.getClassExpressionType().equals(t) &&
			klassenDecls.contains(cE.getClassesInSignature()[0]) &&
			!cE.getClassesInSignature()[0].equals(l[1]))
				l[0] = cE.getClassesInSignature()[0]
		}
		l
	}
	
	private boolean istOberklasse (String oberklasse, List klassen) {
		boolean ist = false
		klassen.each {
			Map m = it
			if (m.UnterklasseVon == oberklasse)
				ist = true
		}
		return ist
	}

	private List leseAxiome(OWLOntology o) {
		
		List l = []
		o.getAxioms().each {OWLAxiom oA ->
			l << oA
		}
		l.sort().each {
			println it
		}
		l
	}
	
	private List <OWLClassExpression> bildeKlassenDecls(List <OWLAxiom> axiome) {
		
		List klassen = []
		
		List valueKlassen = bildeValueKlassen(axiome)
		println '-------------'
		println 'value Klassen'
		valueKlassen.sort().each {
			println it
		}
		
		axiome.each {OWLAxiom a ->
			if	(a.toString().startsWith("Declaration(Class")) { 
				boolean echteKlasse = true
				valueKlassen.each {OWLAxiom oA -> 
					if (oA.toString().contains(a.getNestedClassExpressions().first().toString()))
						echteKlasse = false
				}
				if (echteKlasse) {
					klassen << a.getNestedClassExpressions().first()
				}					
			}
		}
		klassen
	}
	
	private List <OWLClassExpression> bildeValueKlassen(List <OWLAxiom> axiome) {
		
		List valueKlassen = []
		axiome.each {OWLAxiom a ->
			if (a.getAxiomType().toString() == "SubClassOf" && a.toString().contains("#ValueClasses"))
				valueKlassen << a
		}		
		valueKlassen
	}
	
	private List <OWLClassExpression> getValueKlassen(List <OWLAxiom> axiome) {
		
		List valueKlassen = []
		axiome.each {OWLAxiom a ->
			if (a.getAxiomType().toString() == "SubClassOf" && a.toString().contains("#ValueClasses"))
				valueKlassen << a.getNestedClassExpressions()[1]
		}
		valueKlassen
	}
	
	private List <OWLClassExpression> getClassAssertionAxioms(List <OWLAxiom> axiome) {
		List assertAxioms = []
		axiome.each {OWLAxiom aA ->
			if (aA.getAxiomType().equals(AxiomType.CLASS_ASSERTION))
				assertAxioms << aA
		}
		assertAxioms
	}
	
	private Map getSubMap (List l, String subKey) {
		Map retMap = [:]
		l.each {Map sMap ->
			if (sMap.Klasse == subKey)
				retMap = sMap
		}
		retMap
	}
		
	private String norm (Object o) {
		o.toString().split("#")[1].split(">")[0]
	}
	
	private List <String> getWerte (List <OWLAxiom> caAxiome, String wKlasse) {
		List retWerte = []
		caAxiome.each {OWLAxiom oA ->
			if(norm(oA.getClassesInSignature()[0]).equals(wKlasse))
				retWerte << norm(oA.getIndividualsInSignature()[0])
		}
		retWerte.sort()
	}
	
	private BufferedWriter bufFile (String objName) {
		
		BufferedWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream (objName);
			OutputStreamWriter outpuStreamWriter = null;
			try {
				outpuStreamWriter = new OutputStreamWriter (fileOutputStream, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				System.out.println("Encoding nicht gefunden");
			}
			retBuf = new BufferedWriter(outpuStreamWriter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return retBuf;
	}
	
	private void downloadFile(String fileName) {
		def File file = new File(fileName)
		
		def os = response.outputStream
		response.setHeader("Content-Type", "application/octet-stream;")
		response.setHeader("Content-Disposition", "attachment;filename=${fileName}")
		response.setHeader("Content-Length", "${file.size()}")

		def bytes = file.readBytes()
		for(b in bytes) {
			os.write(b)
		}
	}
}
