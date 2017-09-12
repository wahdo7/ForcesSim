/**
 * Created by Ryan on 2/28/2017.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.Timer;

public class MainScreen extends JPanel {
    public static final int HEIGHT = 800;
    public static final int WIDTH = 1200;

    public MainScreen(){
        requestFocus();
    }

    public static JFrame frame;
    public static shipStage c;
    public static freebodyStage f;
    public static  JPanel shipPanel, sidePanel, topsidePanel, sidespacePanel, bottomsidePanel, buttons;
    public static Container container;
    public static Timer tick;

    public static void main(String[] args){

        Color coBackground = new Color(179,179,204);

        buttons = new buttonPanel();

        frame = new JFrame("Forces Simulation");

        shipPanel = new JPanel();
        c = new shipStage();
        shipPanel.add(c);
        shipPanel.setPreferredSize(new Dimension (800,800));
        shipPanel.setVisible(true);
        shipPanel.setBorder(new EmptyBorder(27,27,27,27));
        shipPanel.setBackground(coBackground);

        topsidePanel = new JPanel();
        f = new freebodyStage();
        topsidePanel.add(f);
        topsidePanel.setPreferredSize(new Dimension (340,340));
        topsidePanel.setVisible(true);
        topsidePanel.setBackground(Color.DARK_GRAY);

        sidespacePanel = new JPanel();
        sidespacePanel.setPreferredSize(new Dimension(340,9));
        sidespacePanel.setBackground(coBackground);

        bottomsidePanel = new JPanel();
        bottomsidePanel.setPreferredSize(new Dimension (340,340));
        bottomsidePanel.setVisible(true);
        bottomsidePanel.setBackground(Color.DARK_GRAY);
        bottomsidePanel.add(buttons);

        sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension (400,800));
        sidePanel.setVisible(true);
        sidePanel.setBorder(new EmptyBorder(28,5,0,0));
        sidePanel.setBackground(coBackground);
        sidePanel.add(topsidePanel);
        sidePanel.add(sidespacePanel);
        sidePanel.add(bottomsidePanel);

        container = frame.getContentPane();
        container.setVisible(true);
        container.add(shipPanel, BorderLayout.LINE_START);
        container.add(sidePanel, BorderLayout.LINE_END);

        frame.pack();
        frame.setSize(new Dimension (WIDTH,HEIGHT));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame otherFrame = new JFrame("Settings and Stats");
        JPanel otherPanel = new otherPanel();

        otherPanel.setVisible(true);

        otherFrame.add(otherPanel);

        otherFrame.pack();
        otherFrame.setResizable(false);
        otherFrame.setLocation(1200,200);
        otherFrame.setVisible(true);

        otherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tick = new Timer();
        tick.schedule(new tickStuff(), 0, 16);
}

}