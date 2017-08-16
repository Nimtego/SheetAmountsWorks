package view.buttons;

import view.windows.WindowView;
import view.windows.windows_colection.WindowSheetAmountExpanded;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 16.08.2017.
 */
public class ComboBoxListenerDistrict extends ButtonsListener {
    public ComboBoxListenerDistrict(WindowView owner) {
        super(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!((WindowSheetAmountExpanded)owner).getChoiseDistrict().isEmpty())
            owner.report(this);
    }
}
