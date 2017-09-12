/**
 * Created by Ryan on 4/8/2017.
 */

//http://stackoverflow.com/questions/17936180/snapping-to-certain-values-in-jslider-possible

import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class snappingSlider extends JSlider {
    private static Integer[] VALUES;
    private static Hashtable<Integer, JLabel> LABELS = new Hashtable<>();

    public snappingSlider(Integer[] iVALUES)
    {
        super(0, iVALUES.length - 1, 0);
        VALUES = iVALUES;

        for(int i = 0; i < VALUES.length; ++i)
        {
            LABELS.put(i, new JLabel(VALUES[i].toString()));
        }

        setLabelTable(LABELS);
        setPaintTicks(true);
        setPaintLabels(true);
        setSnapToTicks(true);
        setMajorTickSpacing(1);
    }

    public int getDomainValue()
    {
        return VALUES[getValue()];
    }
}
