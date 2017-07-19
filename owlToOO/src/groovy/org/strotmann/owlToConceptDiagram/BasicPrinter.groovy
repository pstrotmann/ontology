package org.strotmann.owlToConceptDiagram

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
 
public class BasicPrinter implements Printable, ActionListener {
 
 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        g2d.drawRect(25, 15, 450, 600)
		//Partner
		g2d.drawString("Partner", 230, 200)
		g2d.drawArc(150, 200, 200, 200, 0, 360)
		//Person
		g2d.drawString("Person", 180, 250)
		g2d.drawArc(150, 250, 100, 100, 0, 360)
		//Organisation
		g2d.drawString("Organisation", 260, 250)
		g2d.drawArc(250, 250, 100, 100, 0, 360)
		//Bankverbindung
		g2d.drawString("Bankverbindung", 60, 100)
		g2d.drawArc(50, 100, 100, 100, 0, 360)
		//Kommunikation
		g2d.drawString("Kommunikation", 370, 100)
		g2d.drawArc(350, 100, 100, 100, 0, 360)
		//Adresse
		g2d.drawString("Adresse", 230, 50)
		g2d.drawArc(200, 50, 100, 100, 0, 360)
		//Rolle
		g2d.drawString("Rolle", 230, 450)
		g2d.drawArc(200, 450, 100, 100, 0, 360)
		
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
 
    public static void main(String[] args) {
  
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Diagramm Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Diagramm");
        printButton.addActionListener(new BasicPrinter());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
}

