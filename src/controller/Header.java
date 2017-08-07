package controller;

import model.calculation.CalculationDate;
import model.constant.TypeTrench;
import model.district.District;
import model.exceptions.SimpleMessageException;
import model.input.InputDate;
import model.session.Session;
import model.user.User;
import model.user.UserContainer;

import java.util.List;

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
    private CalculationController calculationController;
    private User currentUser;

    public Header() {
    }

    public void running() {
        session = new Session();
        dataController = new DataController();
        windowController = new WindowController(this);
        userController = new UserController(session.getUserContainer());
        calculationController = new CalculationController();
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

    public void calculate(String nameDistrict){
        District district = UserContainer.getInstance().getDistrictByName(nameDistrict);
        CalculationDate calculationDate = calculationController.calculate(district);
        district.setCalculationDate(calculationDate);
        windowController.simpleMessage(CALCULATION_DATA, "< " +district.getName() +" >\n" +calculationDate.toString());
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

    public void calculateAll() {
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(currentUser.getLogIn());
        for (int i = 0; i < districtList.size(); i++) {
            districtList.get(i).setCalculationDate(calculationController.calculate(districtList.get(i)));
        }
        StringBuilder sb = new StringBuilder();
        for (District dis : districtList) {
            sb.append("\n==========")
                    .append(dis.getInputDate().getSizeTrench())
                    .append("============")
                    .append("\n")
                    .append(dis.getName())
                    .append("\n")
                    .append("=====================")
                    .append(dis.getInputDate())
                    .append("\n").append("************************").append("\n")
                    .append(dis.getCalculationDate());
        }
        windowController.simpleMessage(CALCULATION_DATA, "< " +currentUser.getLogIn() +" >\n" +String.valueOf(sb));
    }
}
