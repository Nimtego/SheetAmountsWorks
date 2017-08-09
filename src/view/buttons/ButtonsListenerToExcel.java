package view.buttons;

import view.windows.WindowView;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 08.08.2017.
 */
public class ButtonsListenerToExcel extends ButtonsListener {
    public ButtonsListenerToExcel(WindowView windowView) {
        super(windowView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
