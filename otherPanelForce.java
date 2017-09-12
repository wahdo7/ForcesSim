/**
 * Created by Ryan on 4/8/2017.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class otherPanelForce extends JPanel{
    snappingSlider topSlider = new snappingSlider(new Integer[] {100,200,400});
    snappingSlider leftSlider = new snappingSlider(new Integer[] {100,200,400});
    snappingSlider rightSlider = new snappingSlider(new Integer[] {100,200,400});
    snappingSlider bottomSlider = new snappingSlider(new Integer[] {100,200,400});


    public otherPanelForce() {
        this.setBorder(BorderFactory.createTitledBorder("Engine Force (N)"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel topLabel = new JLabel("Top Engine");
        add(topLabel);

        topSlider.setPreferredSize(new Dimension(350,200));
        topSlider.setValue(1);
        topSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainScreen.c.topForce = topSlider.getDomainValue();
                buttonPanel.isTopOn = false;
                buttonPanel.isLeftOn = false;
                buttonPanel.isRightOn = false;
                buttonPanel.isBottomOn = false;
                MainScreen.c.shipX = 300;
                MainScreen.c.shipY = 300;
                tickStuff.velocityX = 0;
                tickStuff.velocityY = 0;
                tickStuff.accelCount = 0;
                MainScreen.f.updatefreebody();
                buttonPanel.enablebuttons();
                buttonPanel.topButtonUnpressed();
                buttonPanel.leftButtonUnpressed();
                buttonPanel.rightButtonUnpressed();
                buttonPanel.bottomButtonUnpressed();
            }
        });
        add(topSlider);

        JLabel leftLabel = new JLabel("Left Engine");
        add(leftLabel);

        leftSlider.setPreferredSize(new Dimension(350,200));
        leftSlider.setValue(1);
        leftSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainScreen.c.leftForce = leftSlider.getDomainValue();
                buttonPanel.isTopOn = false;
                buttonPanel.isLeftOn = false;
                buttonPanel.isRightOn = false;
                buttonPanel.isBottomOn = false;
                MainScreen.c.shipX = 300;
                MainScreen.c.shipY = 300;
                tickStuff.velocityX = 0;
                tickStuff.velocityY = 0;
                tickStuff.accelCount = 0;
                MainScreen.f.updatefreebody();
                buttonPanel.enablebuttons();
                buttonPanel.topButtonUnpressed();
                buttonPanel.leftButtonUnpressed();
                buttonPanel.rightButtonUnpressed();
                buttonPanel.bottomButtonUnpressed();
            }
        });
        add(leftSlider);

        JLabel rightLabel = new JLabel("Right Engine");
        add(rightLabel);

        rightSlider.setPreferredSize(new Dimension(350,200));
        rightSlider.setValue(1);
        rightSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainScreen.c.rightForce = rightSlider.getDomainValue();
                buttonPanel.isTopOn = false;
                buttonPanel.isLeftOn = false;
                buttonPanel.isRightOn = false;
                buttonPanel.isBottomOn = false;
                MainScreen.c.shipX = 300;
                MainScreen.c.shipY = 300;
                tickStuff.velocityX = 0;
                tickStuff.velocityY = 0;
                tickStuff.accelCount = 0;
                MainScreen.f.updatefreebody();
                buttonPanel.enablebuttons();
                buttonPanel.topButtonUnpressed();
                buttonPanel.leftButtonUnpressed();
                buttonPanel.rightButtonUnpressed();
                buttonPanel.bottomButtonUnpressed();
            }
        });
        add(rightSlider);

        JLabel bottomLabel = new JLabel("Bottom Engine");
        add(bottomLabel);

        bottomSlider.setPreferredSize(new Dimension(350,200));
        bottomSlider.setValue(1);
        bottomSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainScreen.c.bottomForce = bottomSlider.getDomainValue();
                buttonPanel.isTopOn = false;
                buttonPanel.isLeftOn = false;
                buttonPanel.isRightOn = false;
                buttonPanel.isBottomOn = false;
                MainScreen.c.shipX = 300;
                MainScreen.c.shipY = 300;
                tickStuff.velocityX = 0;
                tickStuff.velocityY = 0;
                tickStuff.accelCount = 0;
                MainScreen.f.updatefreebody();
                buttonPanel.enablebuttons();
                buttonPanel.topButtonUnpressed();
                buttonPanel.leftButtonUnpressed();
                buttonPanel.rightButtonUnpressed();
                buttonPanel.bottomButtonUnpressed();
            }
        });
        add(bottomSlider);
    }
}
