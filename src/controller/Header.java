package controller;

import model.constant.TypeTrench;
import model.district.District;
import model.exceptions.SimpleMessageException;
import model.input.InputDate;
import model.session.Session;
import model.user.User;
import model.user.UserContainer;

import static controller.TegWin.*;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Header {
    private Session session;
    private WindowController windowController;
    private DataController dataController;
    private UserController userController;
    private User currentUser;

    public Header() {
    }

    public void running() {
        session = new Session();
        dataController = new DataController(session.getUserContainer());
        windowController = new WindowController(this);
        userController = new UserController(session.getUserContainer());
        windowController.runWin(USER_REG);
    }

    public void userLogIn(String nameUser, String password) {
        try {
            userController.logIn(nameUser, password);
            windowController.simpleMessage(SIMPLE_ERROR, "Welcome < " + nameUser +" >");
            currentUser = UserContainer.getInstance().getUserByName(nameUser);
            windowController.runWin(SHEET_AMOUNT);
        } catch (SimpleMessageException e) {
            windowController.simpleMessage(SIMPLE_ERROR, e.getLocalizedMessage());
        }
    }
    public void userSignIn(String nameUser, String password) {
        try {
            userController.singIn(nameUser, password);
            windowController.simpleMessage(SIMPLE_ERROR,
                    "You data\n" + "Login/name: "
                            + nameUser + "\n" + "Password: "
                            + password);
            currentUser = UserContainer.getInstance().getUserByName(nameUser);
            windowController.runWin(SHEET_AMOUNT);
        } catch (SimpleMessageException e) {
            windowController.simpleMessage(SIMPLE_ERROR, e.getLocalizedMessage());
        }

    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void registrSheetAmount(String nameDistrict,
                                   String lineLong,
                                   String numberOfCrossing,
                                   String typeTrench) {
        int line;
        int crossing;
        try {
            line = Integer.parseInt(lineLong);
            crossing = Integer.parseInt(numberOfCrossing);
            InputDate inputDate = new InputDate(line, TypeTrench.size(typeTrench), crossing);
            District district = new District(nameDistrict, inputDate);
            try {
                if (dataController.putDistrict(currentUser, district)) {
                    windowController.simpleMessage(SIMPLE_ERROR, "Участок < " + district.getName() + " > добавлен");
                    windowController.update();
                }
            } catch (SimpleMessageException e) {
                windowController.simpleMessage(SIMPLE_ERROR, e.getMessage());
            }
        } catch (NumberFormatException e) {
            windowController.simpleMessage(SIMPLE_ERROR, "Длинна траншеи, пересечения не должны быть пустыми");
        }
    }
}
