/**
 * Created by Ryan on 4/8/2017.
 */

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class otherPanelMass extends JPanel {
    snappingSlider massSlider = new snappingSlider(new Integer[] {100,200,400});
    public otherPanelMass() {
        this.setBorder(BorderFactory.createTitledBorder("Ship Mass (kg)"));

        massSlider.setPreferredSize(new Dimension(350,110));
        massSlider.setValue(1);
        massSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainScreen.c.shipMass = massSlider.getDomainValue();
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
        add(massSlider);
    }
}
