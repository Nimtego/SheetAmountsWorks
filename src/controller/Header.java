package controller;

import model.CalculationData;
import model.User;
import view.InputDateWindows;
import view.messages.WrongDataMessage;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class Header {
    private User user;
    private InputDateWindows inputDateWindows;
    public Header() {
    }
    public Header(User user) {
        this.user = user;
        this.inputDateWindows = InputDateController.getInstance(this);
    }
    public void start() {
        inputDateWindows.setVisible(true);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void saveEnteringData() {
        try {
            CalculationData calculationData = InputDateController.generateInputDate(inputDateWindows);
            user.putDate(calculationData);
            inputDateWindows.getTextAreaDescription().insert(user.getCalculationData().toString(), 1);

        } catch (Exception e) {
            WrongDataMessage.wrongEntering(e.getMessage(), inputDateWindows.getLocation());
        }
    }
}
