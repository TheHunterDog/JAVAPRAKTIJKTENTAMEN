package com.company;

import javax.swing.*;
import java.awt.*;

public class KlasGraphics extends JPanel {
    private final Klas klas;
        public KlasGraphics(Klas klas){
//        All the stuff that needs to be done before the
            this.klas = klas;
            setPreferredSize(new Dimension(600,400));

        }

        public void paintComponent(java.awt.Graphics g) {
//        Get panel size
            Dimension d = this.getSize();
//        Loop the paint
            super.paintComponent(g);
            g.setColor(Color.green);
            klas.printGUIIcons(g,10,10,d);
        }

    public static void drawStringRotated( Graphics g, String txt, double x, double y, int angle ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate( (float) x, (float) y );
        g2d.rotate( Math.toRadians( angle ) );
        g2d.drawString( txt, 0, 0 );
        g2d.rotate( -Math.toRadians( angle ) );
        g2d.translate( -(float) x, -(float) y );
    }


}
