package view.buttons.sheet_amount;

import view.buttons.ButtonsListener;
import view.windows.windows_colection.WindowSheetAmount;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 02.08.2017.
 */
public class ButtonsListenerCalculateThis extends ButtonsListener {
    public ButtonsListenerCalculateThis(WindowSheetAmount windowSheetAmount) {
        super(windowSheetAmount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
