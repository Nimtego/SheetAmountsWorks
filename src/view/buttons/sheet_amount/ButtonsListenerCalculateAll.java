package view.buttons.sheet_amount;

import view.buttons.ButtonsListener;
import view.windows.WindowView;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 02.08.2017.
 */
public class ButtonsListenerCalculateAll extends ButtonsListener {
    public ButtonsListenerCalculateAll(WindowView windowView) {
        super(windowView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
