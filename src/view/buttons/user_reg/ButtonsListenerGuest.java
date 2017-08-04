package view.buttons.user_reg;

import view.buttons.ButtonsListener;
import view.windows.WindowView;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 04.08.2017.
 */
public class ButtonsListenerGuest extends ButtonsListener {
    public ButtonsListenerGuest(WindowView owner) {
        super(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
