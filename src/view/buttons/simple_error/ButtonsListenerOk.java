package view.buttons.simple_error;

import view.windows.WindowView;
import view.buttons.ButtonsListener;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class ButtonsListenerOk extends ButtonsListener {


    public ButtonsListenerOk(WindowView owner) {
        super(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
