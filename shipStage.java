/**
 * Created by Ryan on 3/8/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class shipStage extends JPanel {
    private BufferedImage image;

    //As measured from top left-most point
    public static int shipX = 300;
    public static int shipY = 300;

    public static int shipMass = 200;
    public static int topForce = 200;
    public static int leftForce = 200;
    public static int rightForce = 200;
    public static int bottomForce = 200;

    public Color coSpace = new Color(12,12,39);
    public Color coStar = new Color(255,255,204);

    int starGen = 0;
    int numOfStars = ThreadLocalRandom.current().nextInt(10,21);
    int[][] starData = new int[numOfStars][3];

    public shipStage() {
        super();
        setPreferredSize(new Dimension(700,700));
        this.setDoubleBuffered(true);
    }

    public void paintComponent(Graphics g){
        //super.paintComponent(g);

        //Border
        g.clearRect(0,0,700,700);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,700,700);

        //Background
        g.setColor(coSpace);
        g.fillRect(5,5,695,695);

        //Stars
        g.setColor(coStar);
        generateStars(g);
        for(int n=0;n<numOfStars;n++) {
            int starSize = starData[n][2];
            int xPos = starData[n][0];
            int yPos = starData[n][1];
            g.fillRect(xPos, yPos, starSize, starSize);
        }

        //Ship body
        g.setColor(Color.DARK_GRAY);
        g.fillRect(shipX+18,shipY+18,64,64);
        g.setColor(Color.WHITE);
        g.fillRect(shipX+20,shipY+20,60,60);
        //Window
        g.setColor(Color.DARK_GRAY);
        g.fillOval(shipX+33,shipY+33,34,34);
        g.setColor(Color.CYAN);
        g.fillOval(shipX+35,shipY+35,30,30);
        g.setColor(Color.WHITE);
        g.drawLine(shipX+50,shipY+57,shipX+55,shipY+47);
        g.drawLine(shipX+47,shipY+54,shipX+52,shipY+44);

        //Top booster
        g.setColor(Color.DARK_GRAY);
        g.fillRect(shipX+30,shipY+5,40,13);
        g.setColor(Color.GRAY);
        g.fillRect(shipX+32,shipY+7,36,9);

        //Left booster
        g.setColor(Color.DARK_GRAY);
        g.fillRect(shipX+5,shipY+30,13,40);
        g.setColor(Color.GRAY);
        g.fillRect(shipX+7,shipY+32,9,36);

        //Bottom booster
        g.setColor(Color.DARK_GRAY);
        g.fillRect(shipX+30,shipY+82,40,13);
        g.setColor(Color.GRAY);
        g.fillRect(shipX+32,shipY+84,36,9);

        //Right booster
        g.setColor(Color.DARK_GRAY);
        g.fillRect(shipX+82,shipY+30,13,40);
        g.setColor(Color.GRAY);
        g.fillRect(shipX+84,shipY+32,9,36);

        if (buttonPanel.isTopOn) {
            //Top fire
            g.setColor(Color.RED);
            g.fillRect(shipX+34,shipY,32,5);
        }

        if (buttonPanel.isLeftOn) {
            //Left fire
            g.setColor(Color.RED);
            g.fillRect(shipX,shipY+34,5,32);
        }

        if (buttonPanel.isBottomOn) {
            //Bottom fire
            g.setColor(Color.RED);
            g.fillRect(shipX+34,shipY+95,32,5);
        }

        if (buttonPanel.isRightOn) {
            //Right fire
            g.setColor(Color.RED);
            g.fillRect(shipX+95,shipY+34,5,32);
        }

        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public void updateShip() {
        repaint();
    }

    public void generateStars(Graphics g) {
        if (starGen == 0) {
            for(int n=0;n<numOfStars;n++) {
                int starSize = ThreadLocalRandom.current().nextInt(1,5);
                int xPos = ThreadLocalRandom.current().nextInt(50,651);
                int yPos = ThreadLocalRandom.current().nextInt(50,651);
                g.fillRect(xPos,yPos,starSize,starSize);

                starData[n][0] = xPos;
                starData[n][1] = yPos;
                starData[n][2] = starSize;
            }
            starGen = 1;
        }
    }
}
