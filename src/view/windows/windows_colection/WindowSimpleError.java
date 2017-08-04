package view.windows.windows_colection;

import controller.WindowController;
import view.buttons.simple_error.ButtonsListenerOk;
import view.windows.WindowView;

import javax.swing.*;

import static model.constant.WindowConstant.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class WindowSimpleError extends WindowView {
    private JButton buttonOk;
    private JLabel message;
    private JPanel jPanel;

    public WindowSimpleError(WindowController windowController) {
        super(windowController);
        this.message.setText("ERROR");
        buttonOk.addActionListener(new ButtonsListenerOk(this));
        this.getContentPane().add(jPanel);
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
        this.setResizable(false);
    }
    public void setMessage(String message) {
        this.message.setText(message);
    }
}
