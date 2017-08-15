package controller;

import model.calculation.CalculationDate;
import model.constant.KeyWorks;
import model.constant.TypeTrench;
import model.district.District;
import model.exceptions.SimpleMessageException;
import model.input.InputDate;
import model.input.InputDateExpanded;
import model.input.SizeTrench;
import model.session.Session;
import model.user.User;
import model.user.UserContainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static controller.TegWin.*;
import static model.calculation.Discrition.CAP;
import static model.constant.KeyWorks.*;

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
            currentUser = UserContainer.getInstance().getUserByName(nameUser);
            windowController.runWin(SHEET_AMOUNT);
            windowController.simpleMessage(SIMPLE_ERROR, "Welcome < " + nameUser +" >");
        } catch (SimpleMessageException e) {
            windowController.simpleMessage(SIMPLE_ERROR, e.getLocalizedMessage());
        }
    }
    public void userSignIn(String nameUser, String password) {
        try {
            userController.singIn(nameUser, password);
            currentUser = UserContainer.getInstance().getUserByName(nameUser);
            windowController.runWin(SHEET_AMOUNT);
            windowController.simpleMessage(SIMPLE_ERROR,
                    "You data\n" + "Login/name: "
                            + nameUser + "\n" + "Password: "
                            + password);
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

    public void generateExcel() {
        String pattern = "C:\\МЯСНИКОВ\\IDEA_Projeckt\\SimpleSheetAmount\\output\\Pattern.xlsx";
        String dest = "C:\\МЯСНИКОВ\\IDEA_Projeckt\\SimpleSheetAmount\\output\\" +currentUser.getLogIn() +"_" +"project.xlsx";
        File filePattern = new File(pattern);
        File fileDest = new File(dest);
        try {
            Files.copy(filePattern.toPath(), fileDest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        ExcelParser excelParser = new ExcelParser();

        try {
            ExcelParser.generate(generateArray(), fileDest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[][] generateArray() {
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(currentUser.getLogIn());
        int rows = getRows(districtList);
        String[][] excel = new String[rows][CAP.length];
        System.out.println(rows);
        int currentRows = 0;
        int currentColumn = 0;
        int serialNumber = 1;
        for (int j = 0; j < CAP.length; j++) {
            excel[currentRows][j] = CAP[j];
        }
        currentRows++;
        for (District dis : districtList) {
            String nameDis = dis.getName();
            excel[currentRows++][0] =
                    String.valueOf(serialNumber + ". \"" + nameDis + "\"");
            List<String[][]> allWork = Arrays.asList(dis.getCalculationDate().getExcavation().formating(),
                    dis.getCalculationDate().getFabric().formating(),
                    dis.getCalculationDate().getWorkType().formating());
            for (String[][] work : allWork) {
                for (int i = 0; i < work.length; i++) {
                    for (int j = 0; j < work[i].length; ) {
                        if (currentColumn == 0) {
                            excel[currentRows][currentColumn] = String.valueOf("   " +serialNumber + "." + (i+1));
                            currentColumn++;
                            continue;
                        }
                        System.out.println("i " +i +" j " +j +" row " +currentRows +" col " +currentColumn);
                        excel[currentRows][currentColumn++] = work[i][j++];
                    }
                    currentColumn = 0;
                    currentRows++;
                }
            }
            serialNumber++;
        }
        return excel;
    }


    private int getRows(List<District> districtList) {
        int count = 0;
        List<String[][]> list = new ArrayList<>();
        for (District district : districtList) {
            String[][] str = district.getCalculationDate().getExcavation().formating();
            String[][] str2 = district.getCalculationDate().getFabric().formating();
            String[][] str3 = district.getCalculationDate().getWorkType().formating();
            list.add(str);
            list.add(str2);
            list.add(str3);
        }
        for (String[][] string : list) {
            count += string.length;
        }
        count += districtList.size() + 1;
        return count;
    }

    public void expanded() {
        windowController.runWin(SHEET_AMOUNT_EXP);
    }

    public void sheetAmount(Map<KeyWorks, String> worksVolumeMap, List<Boolean> checkBox) {
        System.out.println("Works sheet amount");
        for (KeyWorks keyWorks : worksVolumeMap.keySet()) {
            if (worksVolumeMap.get(keyWorks).isEmpty() &&
                    !keyWorks.equals(QUANTITY_SUPPORT) &&
                    !keyWorks.equals(HEIGHT_SUPPORT)) {
                windowController.simpleMessage(SIMPLE_ERROR, "Пустые поля");
            }
        }

        String tmp = "";
        float lineLong = 0;
        int branches = 0;
        float longCrossing = 0;
        int pipeStock = 0;
        int quantitySupport = 0;
        int heightSupport = 0;
        String pipeType = worksVolumeMap.get(PIPE_TYPE);

        try {
            tmp = worksVolumeMap.get(LINE_LONG);
            lineLong = Float.parseFloat(tmp);
            tmp = worksVolumeMap.get(QUANTITY_BRANCHES);
            branches = Integer.parseInt(tmp);
            tmp = worksVolumeMap.get(LONG_CROSSING);
            longCrossing = Float.parseFloat(tmp);
            tmp = worksVolumeMap.get(PIPE_STOCK);
            pipeStock = Integer.parseInt(tmp);
            if (!worksVolumeMap.get(QUANTITY_SUPPORT).isEmpty() &&
                    !worksVolumeMap.get(HEIGHT_SUPPORT).isEmpty()) {
                tmp = worksVolumeMap.get(QUANTITY_SUPPORT);
                quantitySupport = Integer.parseInt(tmp);
                tmp = worksVolumeMap.get(HEIGHT_SUPPORT);
                heightSupport = Integer.parseInt(tmp);
            }
        } catch (NumberFormatException e) {
            windowController.simpleMessage(SIMPLE_ERROR, "\"" +tmp +"\"" +" - не подходит");
        }
        SizeTrench sizeTrench = TypeTrench.size(worksVolumeMap.get(TRENCH_TYPE));
        InputDateExpanded inputDateExpanded =
                new InputDateExpanded(lineLong, sizeTrench, 1); // TODO: 15.08.2017 кол пересечек не нужн
        inputDateExpanded.setQuantityBranches(branches);
        inputDateExpanded.setLongCrossing(longCrossing);
        inputDateExpanded.setPipeStock(pipeStock);
        inputDateExpanded.setQuantitySupport(quantitySupport);
        inputDateExpanded.setHeightSupport(heightSupport);
        String name = worksVolumeMap.get(NAME_DISTRICT);
        District district = new District(name, inputDateExpanded);
        try {
            if (dataController.putDistrict(currentUser, district)) {
                windowController.simpleMessage(SIMPLE_ERROR, "Участок < " + district.getName() + " > добавлен");
                windowController.update();
            }
        } catch (SimpleMessageException e) {
            windowController.simpleMessage(SIMPLE_ERROR, e.getMessage());
        }
        windowController.update();
    }
}
