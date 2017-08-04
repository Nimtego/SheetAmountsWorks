package view.buttons;

import view.windows.WindowView;

import java.awt.event.ActionListener;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public abstract class ButtonsListener implements ActionListener{
    protected WindowView owner;

    public ButtonsListener(WindowView owner) {
        this.owner = owner;
    }

    public WindowView getOwner() {
        return owner;
    }
}
