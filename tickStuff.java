/**
 * Created by Ryan on 4/6/2017.
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.TimerTask;

public class tickStuff extends TimerTask {

    public static int velocityX = 0;
    public static int velocityY = 0;
    public static int accelCount = 1;
    public static int accelState;
    public static double accelMult;
    public static int count = 0;
    int tForce, lForce, rForce, bForce, xForce, yForce;

    public synchronized void run() {

        MainScreen.c.updateShip();

        int accelX = 0;
        int accelY = 0;

        tForce = 0;
        lForce = 0;
        rForce = 0;
        bForce = 0;

        if (buttonPanel.isTopOn) {
            tForce = MainScreen.c.topForce;
        }
        if (buttonPanel.isLeftOn) {
            lForce = MainScreen.c.leftForce;
        }
        if (buttonPanel.isRightOn) {
            rForce = MainScreen.c.rightForce;
        }
        if (buttonPanel.isBottomOn) {
            bForce = MainScreen.c.bottomForce;
        }

        xForce = lForce - rForce;
        yForce = tForce - bForce;

        if (accelCount >= accelState) {
            accelY += yForce / 100;
            accelX += xForce / 100;
        }

        if (accelCount < accelState) {
            accelCount++;
        } else {
            accelCount = 1;
        }

        accelMult = Math.round(Math.sqrt(Math.pow(xForce,2) + Math.pow(yForce,2)) / MainScreen.c.shipMass); //Between 0.25 and 5.67
        if (accelMult >= 1.0 && accelMult < 2.0) {
            accelState = 8;
        } else if (accelMult <= 3.0 && accelMult <= 4.5) {
            accelState = 4;
        } else if (accelMult > 4.5 && accelMult < 6.0) {
            accelState = 2;
        } else if (accelMult >= 1.5 && accelMult < 3.0) {
            accelState = 16;
        } else if (accelMult >= 0.25 && accelMult < 1.5) {
            accelState = 32;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.CEILING);


        if (xForce > 0) {
            if (yForce > 0) {
                otherPanelNet.netDir.setText("Direction: Southeast");
            } else if (yForce < 0) {
                otherPanelNet.netDir.setText("Direction: Northeast");
            } else {
                otherPanelNet.netDir.setText("Direction: East");
            }
        } else if (xForce < 0) {
            if (yForce > 0) {
                otherPanelNet.netDir.setText("Direction: Southwest");
            } else if (yForce < 0) {
                otherPanelNet.netDir.setText("Direction: Northwest");
            } else {
                otherPanelNet.netDir.setText("Direction: West");
            }
        } else {
            if (yForce > 0) {
                otherPanelNet.netDir.setText("Direction: South");
            } else if (yForce < 0) {
                otherPanelNet.netDir.setText("Direction: North");
            } else {
                otherPanelNet.netDir.setText("Direction: None");
            }
        }

        if (Math.sqrt(Math.pow(xForce,2) + Math.pow(yForce,2)) / MainScreen.c.shipMass == 0) {
            otherPanelMove.acc.setText("Acceleration: 0 m/s2");
        } else {
            otherPanelMove.acc.setText("Acceleration: " + df.format(Math.sqrt(Math.pow(xForce,2) + Math.pow(yForce,2)) / MainScreen.c.shipMass) + " m/s2");
        }
        otherPanelNet.netMag.setText("Magnitude: " + Math.round(Math.sqrt(Math.pow(xForce,2) + Math.pow(yForce,2))) + "N");

        if (Math.sqrt(Math.pow(velocityX,2)+Math.pow(velocityY,2)) >= 100) {
            buttonPanel.disablebuttons();
        } else {
            velocityX += accelX;
            velocityY += accelY;
        }

        MainScreen.c.shipX += velocityX;
        MainScreen.c.shipY += velocityY;

        if (MainScreen.c.shipX >= 600) {
            MainScreen.c.shipX = 0;
        } else if (MainScreen.c.shipX <= 0) {
            MainScreen.c.shipX = 600;
        }
        if (MainScreen.c.shipY >= 600) {
            MainScreen.c.shipY = 0;
        } else if (MainScreen.c.shipY <= 0) {
            MainScreen.c.shipY = 600;
        }
    }
}
