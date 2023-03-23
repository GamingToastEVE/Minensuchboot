/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author michael
 */
public class zeichenPanel extends JPanel{
    
    private Image image;
    private Graphics2D g2d;
    
    public int[][] feld = new int[20][20];
    
    /**
     *
     */
    public zeichenPanel() {                                                    //Konstruktor setzt bevorzugte Gre, legt das Layout fest
        super();
        this.setPreferredSize(new Dimension(440, 440));
        this.setLayout(null);
        
        for(int i = 0; i<20; i++) {
            for(int j=0; j<20; j++) {
                feld[i][j] = 0;
            }
        }
    }
    
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        if (image != null) {
            size.width = image.getWidth(this);
            size.height = image.getHeight(this);
        }
        return size;
    }
  
    
    public void setPaintColor(final Color color) {
        g2d.setColor(color);
    }{

    }
  
    
    public void clearPaint() {
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        repaint();
        g2d.setColor(Color.BLACK);
    }
  
    
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
    
        if (image == null || image.getWidth(this) < getSize().width                 //Image initialisieren (ging vorher nicht) oder an Gre des Simulatorpanels anpassen
            || image.getHeight(this) < getSize().height) {
            resetImage();
        } // end of if
        Graphics2D g2 = (Graphics2D) g;                                             //Erst jetzt kann man auch den Grafikkontext erhalten
        Rectangle r = g.getClipBounds();
        this.updateImage();
        g2.drawImage(image, r.x, r.y, r.width + r.x, r.height + r.y,
            r.x, r.y, r.width + r.x, r.height + r.y, this);
    }
    
    
    public void resetImage() {                                                    
        Image saveImage = image;                                                    //Verhindert das Flackern (so gut es geht)
        Graphics2D saveG2d = g2d;
        image = createImage(getWidth(), getHeight());
        g2d = (Graphics2D) image.getGraphics();
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        //RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        if (saveG2d != null) {
            g2d.setColor(saveG2d.getColor());
            g2d.drawImage(saveImage, 0, 0, this);
            saveG2d.dispose();
        } // end of if
    }
  
    
    public Graphics2D getG2d() {
        return g2d;
    }
  
    
    public void updateImage() {                                                   
        clearPaint();
        //g2d.drawString("x="+x+", y="+y, 20, 20);
        
        /*for(int i=0; i<20; i++) {
            for(int j=0; j<20; j++) {
                g2d.setColor(feld[i][j]);
                g2d.fillRect(1+22*j,1+22*i,20,20);
            }
        }*/
        
        g2d.setColor(new Color(50,50,50));
        for ( int i = 0; i<21; i++) {
            g2d.drawLine(22*i,0,22*i,22*20);
        }
        g2d.setColor(new Color(50,50,50));
        for ( int i = 0; i<21; i++) {
            g2d.drawLine(0,22*i,22*20,22*i);
        }
        
        for(int i=0; i<20; i++) {
            for(int j=0; j<20; j++) {
                switch (feld[i][j]) {
                    case -1:
                        g2d.setColor(Color.RED);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                //g2d.fillRect(1+22*j,1+22*i,20,20);
                    case 9:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 10:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 11:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 12:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 13:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 14:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 15:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 16:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 17:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break; 
                    case 18:
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                       
                    case 1:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("1", j*22+5, i*22+15);
                        break;
                    case 2:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("2", j*22+5, i*22+15);
                        break;
                    case 3:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("3", j*22+5, i*22+15);
                        break;
                    case 4:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("4", j*22+5, i*22+15);
                        break;
                    case 5:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("5", i*22+5, j*22+15);
                        break;
                    case 6:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("6", i*22+5, j*22+15);
                        break;
                    case 7:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("7", i*22+5, j*22+15);
                        break;
                    case 8:
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("8", i*22+5, j*22+15);
                        break;
                    case 19://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 20://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 21://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 22://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 23://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 24://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 25://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 26://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 27://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;
                    case 28://Flagge
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(1+22*j,1+22*i,20,20);
                        break;    
                    default:
                        break;
                }
            }
        }
    }
  
}