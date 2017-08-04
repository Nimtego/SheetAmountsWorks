package view.buttons.user_reg;

import view.windows.WindowView;
import view.buttons.ButtonsListener;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class ButtonsListenerLogIn extends ButtonsListener {
    public ButtonsListenerLogIn(WindowView owner) {
        super(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
