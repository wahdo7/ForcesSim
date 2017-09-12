/**
 * Created by Ryan on 4/8/2017.
 */

import javax.swing.*;
import java.awt.*;

public class otherPanelMove extends JPanel {
    static JLabel acc = new JLabel("Acceleration: ");
    public otherPanelMove() {
        this.setBorder(BorderFactory.createTitledBorder("Movement"));
        this.setLayout(new GridLayout(2,1));

        acc.setHorizontalAlignment(JLabel.CENTER);
        add(acc);
    }
}
