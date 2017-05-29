package view.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 29.05.2017.
 */
public class ButtonExit extends ButtonListener{
    public ButtonExit(JFrame jFrame) {
        super(jFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.dispose();
        System.exit(0);
    }
}
