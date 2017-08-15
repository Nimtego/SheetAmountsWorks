package view.windows.windows_colection;

import controller.WindowController;
import view.buttons.user_reg.ButtonsListenerExit;
import view.buttons.user_reg.ButtonsListenerGuest;
import view.buttons.user_reg.ButtonsListenerLogIn;
import view.buttons.user_reg.ButtonsListenerSingIn;
import view.windows.WindowView;

import javax.swing.*;

import static model.constant.WindowConstant.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class WindowViewUserReg extends WindowView {
    private JButton buttonLogIn;
    private JFormattedTextField formattedUserName;
    private JLabel labelSSAmount;
    private JLabel labelUserName;
    private JLabel labelPassword;
    private JButton exit;
    private JButton buttonSignIn;
    private JPasswordField password;
    private JPanel jPanel;
    private JButton buttonGuest;

    public WindowViewUserReg(WindowController windowController) {
        super(windowController);
        buttonLogIn.addActionListener(new ButtonsListenerLogIn(this));
        exit.addActionListener(new ButtonsListenerExit(this));
        buttonSignIn.addActionListener(new ButtonsListenerSingIn(this));
        buttonGuest.addActionListener(new ButtonsListenerGuest(this));
        this.getContentPane().add(jPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
        this.setResizable(false);
    }



    public String getLogIn() {
        if (formattedUserName.getText().isEmpty())
            return null;
        return formattedUserName.getText();
    }

    public String getPassword() {
        if (String.valueOf(password.getPassword()).isEmpty())
            return null;
        return String.valueOf(password.getPassword());
    }
}
