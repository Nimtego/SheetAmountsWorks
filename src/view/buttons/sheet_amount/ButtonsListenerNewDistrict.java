package view.buttons.sheet_amount;

import view.buttons.ButtonsListener;
import view.windows.WindowView;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 02.08.2017.
 */
public class ButtonsListenerNewDistrict extends ButtonsListener {
    public ButtonsListenerNewDistrict(WindowView windowSheetAmount) {
        super(windowSheetAmount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
