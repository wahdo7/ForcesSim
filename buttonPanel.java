/**
 * Created by Ryan on 3/8/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

public class buttonPanel extends JPanel {

    static String topLeft = "Top\nand\nleft";
    static String topRight = "Top\nand\nright";
    static String bottomLeft = "Bottom\nand\nleft";
    static String bottomRight = "Bottom\nand\nright";

    static JButton topleftbutton = new JButton("<html>" + topLeft.replaceAll("\\n", "<br>") + "</html>");
    static JButton topbutton = new JButton("Top");
    static JButton toprightbutton = new JButton("<html>" + topRight.replaceAll("\\n", "<br>") + "</html>");
    static JButton leftbutton = new JButton("Left");
    static JButton middlebutton = new JButton("Reset");
    static JButton rightbutton = new JButton("Right");
    static JButton bottomleftbutton = new JButton("<html>" + bottomLeft.replaceAll("\\n", "<br>") + "</html>");
    static JButton bottombutton = new JButton("Bottom");
    static JButton bottomrightbutton = new JButton("<html>" + bottomRight.replaceAll("\\n", "<br>") + "</html>");

    public static boolean isTopOn = false;
    public static boolean isLeftOn = false;
    public static boolean isBottomOn = false;
    public static boolean isRightOn = false;

    public static Border borderRaised = BorderFactory.createRaisedBevelBorder();
    public static Border borderPressed = BorderFactory.createLoweredBevelBorder();
    public static Border borderEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    public static Border borderCompound = BorderFactory.createCompoundBorder(borderRaised, borderPressed);

    public static Color coGray1 = new Color(191,191,191);
    public static Color coGray2 = new Color(166,166,166);
    public static Color coGray3 = new Color(140,140,140);
    public static Color coRed1 = new Color(255,153,153);

    public buttonPanel() {
        this.setLayout(new GridLayout(3,3));
        this.setPreferredSize(new Dimension(330,330));

        topleftbutton.setFocusPainted(false);
        topleftbutton.setBackground(coGray1);
        topleftbutton.setBorder(borderEtched);
        add(topleftbutton);

        topbutton.setFocusPainted(false);
        topbutton.setBackground(coGray2);
        topbutton.setBorder(borderRaised);
        add(topbutton);

        toprightbutton.setFocusPainted(false);
        toprightbutton.setBackground(coGray1);
        toprightbutton.setBorder(borderEtched);
        add(toprightbutton);

        leftbutton.setFocusPainted(false);
        leftbutton.setBackground(coGray2);
        leftbutton.setBorder(borderRaised);
        add(leftbutton);

        middlebutton.setFocusPainted(false);
        middlebutton.setBackground(coGray3);
        middlebutton.setBorder(borderCompound);
        add(middlebutton);

        rightbutton.setFocusPainted(false);
        rightbutton.setBackground(coGray2);
        rightbutton.setBorder(borderRaised);
        add(rightbutton);

        bottomleftbutton.setFocusPainted(false);
        bottomleftbutton.setBackground(coGray1);
        bottomleftbutton.setBorder(borderEtched);
        add(bottomleftbutton);

        bottombutton.setFocusPainted(false);
        bottombutton.setBackground(coGray2);
        bottombutton.setBorder(borderRaised);
        add(bottombutton);

        bottomrightbutton.setFocusPainted(false);
        bottomrightbutton.setBackground(coGray1);
        bottomrightbutton.setBorder(borderEtched);
        add(bottomrightbutton);

        topleftbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isTopOn) {
                    isTopOn = false;
                    topButtonUnpressed();
                } else {
                    isTopOn = true;
                    topButtonPressed();
                }
                if (isLeftOn) {
                    isLeftOn = false;
                    leftButtonUnpressed();
                } else {
                    isLeftOn = true;
                    leftButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        topbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isTopOn) {
                    isTopOn = false;
                    topButtonUnpressed();
                } else {
                    isTopOn = true;
                    topButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        toprightbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isTopOn) {
                    isTopOn = false;
                    topButtonUnpressed();
                } else {
                    isTopOn = true;
                    topButtonPressed();
                }
                if (isRightOn) {
                    isRightOn = false;
                    rightButtonUnpressed();
                } else {
                    isRightOn = true;
                    rightButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        leftbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isLeftOn) {
                    isLeftOn = false;
                    leftButtonUnpressed();
                } else {
                    isLeftOn = true;
                    leftButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        middlebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isTopOn = false;
                isLeftOn = false;
                isRightOn = false;
                isBottomOn = false;
                MainScreen.c.shipX = 300;
                MainScreen.c.shipY = 300;
                tickStuff.velocityX = 0;
                tickStuff.velocityY = 0;
                tickStuff.accelCount = 0;
                MainScreen.f.updatefreebody();
                enablebuttons();
                topButtonUnpressed();
                leftButtonUnpressed();
                rightButtonUnpressed();
                bottomButtonUnpressed();
            }
        });

        rightbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isRightOn) {
                    isRightOn = false;
                    rightButtonUnpressed();
                } else {
                    isRightOn = true;
                    rightButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        bottomleftbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isBottomOn) {
                    isBottomOn = false;
                    bottomButtonUnpressed();
                } else {
                    isBottomOn = true;
                    bottomButtonPressed();
                }
                if (isLeftOn) {
                    isLeftOn = false;
                    leftButtonUnpressed();
                } else {
                    isLeftOn = true;
                    leftButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        bottombutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isBottomOn) {
                    isBottomOn = false;
                    bottomButtonUnpressed();
                } else {
                    isBottomOn = true;
                    bottomButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });

        bottomrightbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isBottomOn) {
                    isBottomOn = false;
                    bottomButtonUnpressed();
                } else {
                    isBottomOn = true;
                    bottomButtonPressed();
                }
                if (isRightOn) {
                    isRightOn = false;
                    rightButtonUnpressed();
                } else {
                    isRightOn = true;
                    rightButtonPressed();
                }
                MainScreen.f.updatefreebody();
            }
        });
    }

    public static void disablebuttons() {
        topleftbutton.setEnabled(false);
        topbutton.setEnabled(false);
        toprightbutton.setEnabled(false);
        leftbutton.setEnabled(false);
        rightbutton.setEnabled(false);
        bottomleftbutton.setEnabled(false);
        bottombutton.setEnabled(false);
        bottomrightbutton.setEnabled(false);
    }

    public static void enablebuttons() {
        topleftbutton.setEnabled(true);
        topbutton.setEnabled(true);
        toprightbutton.setEnabled(true);
        leftbutton.setEnabled(true);
        rightbutton.setEnabled(true);
        bottomleftbutton.setEnabled(true);
        bottombutton.setEnabled(true);
        bottomrightbutton.setEnabled(true);

        topButtonUnpressed();
        leftButtonUnpressed();
        rightButtonUnpressed();
        bottomButtonUnpressed();
    }

    public static void topButtonPressed() {
        topbutton.setBackground(coRed1);
        topbutton.setBorder(borderPressed);
    }

    public static void topButtonUnpressed() {
        topbutton.setBackground(coGray2);
        topbutton.setBorder(borderRaised);
    }

    public static void leftButtonPressed() {
        leftbutton.setBackground(coRed1);
        leftbutton.setBorder(borderPressed);
    }

    public static void leftButtonUnpressed() {
        leftbutton.setBackground(coGray2);
        leftbutton.setBorder(borderRaised);
    }

    public static void rightButtonPressed() {
        rightbutton.setBackground(coRed1);
        rightbutton.setBorder(borderPressed);
    }

    public static void rightButtonUnpressed() {
        rightbutton.setBackground(coGray2);
        rightbutton.setBorder(borderRaised);
    }

    public static void bottomButtonPressed() {
        bottombutton.setBackground(coRed1);
        bottombutton.setBorder(borderPressed);
    }

    public static void bottomButtonUnpressed() {
        bottombutton.setBackground(coGray2);
        bottombutton.setBorder(borderRaised);
    }
}
