package view.buttons;

import view.windows.WindowView;

import java.awt.event.ActionEvent;

/**
 * Created by myasnikov
 * on 03.08.2017.
 */
public class ComboBoxListenerSimple extends ButtonsListener{

    public ComboBoxListenerSimple(WindowView owner) {
        super(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        owner.report(this);
    }
}
