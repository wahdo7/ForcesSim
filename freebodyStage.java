/**
 * Created by Ryan on 3/8/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class freebodyStage extends JPanel {
    private BufferedImage simage;

    private int[] toptriX = {141,165,189};
    private int[] toptriY = {85,105,85};

    private int[] lefttriX = {85,105,85};
    private int[] lefttriY = {141,165,189};

    private int[] righttriX = {245,225,245};
    private int[] righttriY = {141,165,189};

    private int[] bottriX = {141,165,189};
    private int[] bottriY = {245,225,245};

    public freebodyStage() {
        super();
        setPreferredSize(new Dimension(330,330));
    }

    @Override public void paintComponent(Graphics h){
        super.paintComponent(h);

        //Background
        h.clearRect(0,0,330,330);
        h.setColor(Color.WHITE);
        h.fillRect(0,0,330,330);

        //Square
        h.setColor(Color.BLACK);
        h.fillRect(115,115,100,100);
        h.setColor(Color.GRAY);
        h.fillRect(117,117,96,96);

        if (buttonPanel.isTopOn) {
            switch(MainScreen.c.topForce) {
                case 100:   h.setColor(Color.BLACK);
                            h.fillRect(153,67,24,23);
                            h.fillPolygon(toptriX,toptriY,3);
                            break;
                case 200:   h.setColor(Color.BLACK);
                            h.fillRect(153,45,24,40);
                            h.fillPolygon(toptriX,toptriY,3);
                            break;
                case 400:   h.setColor(Color.BLACK);
                            h.fillRect(153,10,24,75);
                            h.fillPolygon(toptriX,toptriY,3);
                            break;
            }
        }
        if (buttonPanel.isLeftOn) {
            switch(MainScreen.c.leftForce) {
                case 100:   h.setColor(Color.BLACK);
                            h.fillRect(67,153,23,24);
                            h.fillPolygon(lefttriX,lefttriY,3);
                            break;
                case 200:   h.setColor(Color.BLACK);
                            h.fillRect(45,153,40,24);
                            h.fillPolygon(lefttriX,lefttriY,3);
                            break;
                case 400:   h.setColor(Color.BLACK);
                            h.fillRect(10,153,75,24);
                            h.fillPolygon(lefttriX,lefttriY,3);
                            break;
            }
        }
        if (buttonPanel.isRightOn) {
            switch(MainScreen.c.rightForce) {
                case 100:   h.setColor(Color.BLACK);
                            h.fillRect(245,153,23,24);
                            h.fillPolygon(righttriX,righttriY,3);
                            break;
                case 200:   h.setColor(Color.BLACK);
                            h.fillRect(245,153,40,24);
                            h.fillPolygon(righttriX,righttriY,3);
                            break;
                case 400:   h.setColor(Color.BLACK);
                            h.fillRect(245,153,75,24);
                            h.fillPolygon(righttriX,righttriY,3);
                            break;
            }
        }
        if (buttonPanel.isBottomOn) {
            switch(MainScreen.c.bottomForce) {
                case 100:   h.setColor(Color.BLACK);
                            h.fillRect(153,245,24,23);
                            h.fillPolygon(bottriX,bottriY,3);
                            break;
                case 200:   h.setColor(Color.BLACK);
                            h.fillRect(153,245,24,40);
                            h.fillPolygon(bottriX,bottriY,3);
                            break;
                case 400:   h.setColor(Color.BLACK);
                            h.fillRect(153,245,24,75);
                            h.fillPolygon(bottriX,bottriY,3);
                            break;
            }
        }

        h.drawImage(simage,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public void updatefreebody() { repaint();}
}
