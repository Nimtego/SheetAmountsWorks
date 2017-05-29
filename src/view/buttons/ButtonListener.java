package view.buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public abstract class ButtonListener implements ActionListener {
    protected JFrame jFrame;
    public ButtonListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }
}
