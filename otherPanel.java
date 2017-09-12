/**
 * Created by Ryan on 4/8/2017.
 */

import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class otherPanel extends JPanel {
    JPanel otherPanelMass = new otherPanelMass();
    JPanel otherPanelForce = new otherPanelForce();
    JPanel otherPanelBottom = new otherPanelBottom();

    public otherPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(400,700));

        otherPanelMass.setPreferredSize(new Dimension(400,125));
        otherPanelForce.setPreferredSize(new Dimension(400,450));
        otherPanelBottom.setPreferredSize(new Dimension(400,125));

        add(otherPanelMass);
        add(otherPanelForce);
        add(otherPanelBottom);

    }
}
