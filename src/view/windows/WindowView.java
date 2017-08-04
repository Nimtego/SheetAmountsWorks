package view.windows;

import controller.WindowController;
import view.buttons.ButtonsListener;

import javax.swing.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public abstract class WindowView extends JFrame {
    protected WindowController owner;

    public WindowView(WindowController owner) {
        this.owner = owner;
    }

    public void report(ButtonsListener buttonsListener) {
        owner.buttonReport(buttonsListener);
    }
}
