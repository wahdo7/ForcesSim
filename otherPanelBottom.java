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

public class otherPanelBottom extends JPanel{
    JPanel otherPanelNet = new otherPanelNet();
    JPanel otherPanelMove = new otherPanelMove();
    public otherPanelBottom() {
        this.setLayout(new GridLayout(1,2));

        add(otherPanelNet);
        add(otherPanelMove);
    }
}
