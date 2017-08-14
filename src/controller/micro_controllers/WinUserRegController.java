package controller.micro_controllers;

import controller.TegWin;
import controller.WindowController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by myasnikov
 * on 11.08.2017.
 */
public class WinUserRegController extends MicroController{
    @FXML
    private Button buttonSingIn;
    @FXML
    private Button buttonSingUp;

    public WinUserRegController(){
    }
    @FXML
    public void onClickMethod(){
        String string;
        if (buttonSingUp.isArmed()) {
            string = buttonSingIn.getText();
            buttonSingIn.setText(buttonSingUp.getText());
            buttonSingUp.setText(string);
            owner.runWin(TegWin.USER_REG);
        }
        if (buttonSingIn.isArmed()) {
            string = buttonSingUp.getText();
            buttonSingUp.setText(buttonSingIn.getText());
            buttonSingIn.setText(string);
        }
    }
    @Override
    public void owner(WindowController owner) {
        this.owner = owner;
    }
}
