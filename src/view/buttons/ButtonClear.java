package view.buttons;

import view.InputDateWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 29.05.2017.
 */
public class ButtonClear extends ButtonListener {
    public ButtonClear(JFrame jFrame) {
        super(jFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((InputDateWindows)jFrame).clearTextField();
    }
}
