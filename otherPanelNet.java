/**
 * Created by Ryan on 4/8/2017.
 */

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class otherPanelNet extends JPanel {

    static JLabel netMag = new JLabel("Magnitude: ");
    static JLabel netDir = new JLabel("Direction: ");

    public otherPanelNet() {
        this.setBorder(BorderFactory.createTitledBorder("Net Force"));
        this.setLayout(new GridLayout(2,1));

        netMag.setHorizontalAlignment(JLabel.CENTER);
        add(netMag);

        netDir.setHorizontalAlignment(JLabel.CENTER);
        add(netDir);

    }
}
