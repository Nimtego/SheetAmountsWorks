package controller;

import model.constant.KeyWorks;
import model.constant.TypeTrench;
import model.district.District;
import model.input.InputDateExpanded;
import model.user.User;
import model.user.UserContainer;
import view.StructWindow;
import view.buttons.ButtonsListener;
import view.buttons.ButtonsListenerToExcel;
import view.buttons.ComboBoxListenerDistrict;
import view.buttons.sheet_amount.ButtonsListenerCalculateAll;
import view.buttons.sheet_amount.ButtonsListenerExpanded;
import view.buttons.sheet_amount.ButtonsListenerNewDistrict;
import view.buttons.simple_error.ButtonsListenerOk;
import view.buttons.user_reg.ButtonsListenerExit;
import view.buttons.user_reg.ButtonsListenerGuest;
import view.buttons.user_reg.ButtonsListenerLogIn;
import view.buttons.user_reg.ButtonsListenerSingIn;
import view.windows.WindowView;
import view.windows.WindowViewFabric;
import view.windows.windows_colection.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.constant.KeyWorks.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class WindowController implements ActionListener{
    private Header owner;
    private Map<TegWin, WindowView> windowViewMap;
    private StructWindow structWindow = null;

    public WindowController(Header owner) {
        this.owner = owner;
        structWindow = new StructWindow();
        windowViewMap = WindowViewFabric.simpleMapView(this);

    }

    public void runWin(TegWin tegWin) {
        switch (tegWin) {
            case USER_REG:
                addWindow(windowViewMap.get(tegWin));
                //WindowViewUserRegCopy.create();/*addWindow(windowViewMap.get(tegWin))*/;
                break;
            case SHEET_AMOUNT:
                addWindow(preparation(windowViewMap.get(tegWin)));
                break;
            case CALCULATION_DATA:
                addWindow(windowViewMap.get(tegWin));
                break;
            case SHEET_AMOUNT_EXP:
                addWindow(preparation(windowViewMap.get(tegWin)));
                break;
        }
    }
    private WindowView preparation(WindowView windowView) {
        WindowView prepare;
        if (windowView instanceof WindowSheetAmount) {
            User user = owner.getCurrentUser();
            List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
            prepare = windowView;
            ((WindowSheetAmount)prepare).startingCondition(user.getLogIn(), districtList);
            return prepare;
        }
        if (windowView instanceof WindowSheetAmountExpanded) {
            User user = owner.getCurrentUser();
            List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
            prepare = windowView;
            ((WindowSheetAmountExpanded)prepare).startingCondition(user.getLogIn(), districtList);
            return prepare;
        }
        return null;
    }


    private void addWindow(WindowView windowView) {
        windowView.pack();
        structWindow.add(windowView);
        display();
    }

    private void display() {
        structWindow.allInvisible();
        if (!structWindow.isEmpty())
            structWindow.getActivity().setVisible(true);
        System.out.println(structWindow.getSize());
    }

    public void buttonReport(ButtonsListener buttonsListener) {
        System.out.println("buttonReport");
        WindowView windowView = structWindow.getActivity();
        if (windowView instanceof WindowCalculateData) {
            if (buttonsListener instanceof ButtonsListenerToExcel) {
                owner.generateExcel();
            }
        }
        if (windowView instanceof WindowViewUserReg) {
            if (buttonsListener instanceof ButtonsListenerLogIn) {
                WindowViewUserReg windowViewUserReg = (WindowViewUserReg) buttonsListener.getOwner();
                String nameUser = windowViewUserReg.getLogIn();
                String password = windowViewUserReg.getPassword();
                owner.userLogIn(nameUser, password);
            }
            if (buttonsListener instanceof ButtonsListenerSingIn) {
                WindowViewUserReg windowViewUserReg = (WindowViewUserReg) buttonsListener.getOwner();
                String nameUser = windowViewUserReg.getLogIn();
                String password = windowViewUserReg.getPassword();
                owner.userSignIn(nameUser, password);
            }
            if (buttonsListener instanceof ButtonsListenerGuest) {
                String nameUser = "Guest";
                String password = "12345";
                owner.userLogIn(nameUser, password);
            }
        }
        if (windowView instanceof WindowSheetAmount) {
            if (buttonsListener instanceof ButtonsListenerNewDistrict) {
                WindowSheetAmount windowSheetAmount = (WindowSheetAmount) buttonsListener.getOwner();
                String nameDistrict = windowSheetAmount.getNameDistrict();
                String lineLong = windowSheetAmount.getLineLong();
                String numberOfCrossing = windowSheetAmount.getCrossing();
                String typeTrench = windowSheetAmount.getTypeTrench();
                owner.registrSheetAmount(nameDistrict, lineLong, numberOfCrossing, typeTrench);
            }
            if (buttonsListener instanceof ButtonsListenerExpanded) {owner.expanded();}
            if (buttonsListener instanceof ButtonsListenerCalculateAll) {
                WindowSheetAmount windowSheetAmount = (WindowSheetAmount) buttonsListener.getOwner();
                owner.calculateAll();
            }
        }
        if (windowView instanceof WindowSheetAmountExpanded) {
            if (buttonsListener instanceof ButtonsListenerNewDistrict) {
                System.out.println("ButtonsListenerNewDistrict");
                WindowSheetAmountExpanded windowSheetAmountExpanded =
                        (WindowSheetAmountExpanded) buttonsListener.getOwner();
                
                Map<KeyWorks, String> worksVolumeMap = new HashMap<>();
                worksVolumeMap.put(NAME_DISTRICT, windowSheetAmountExpanded.getNameDistrict());
                worksVolumeMap.put(TRENCH_TYPE, windowSheetAmountExpanded.getTypeTrench());
                worksVolumeMap.put(LINE_LONG, windowSheetAmountExpanded.getLineLOng());
                worksVolumeMap.put(QUANTITY_BRANCHES, windowSheetAmountExpanded.getBranches());
                worksVolumeMap.put(LONG_CROSSING, windowSheetAmountExpanded.getLongCrossing());
                worksVolumeMap.put(PIPE_STOCK, windowSheetAmountExpanded.getPipeStock());
                worksVolumeMap.put(PIPE_TYPE, windowSheetAmountExpanded.getPipeType());
                worksVolumeMap.put(QUANTITY_SUPPORT, windowSheetAmountExpanded.getQuantitySupport());
                worksVolumeMap.put(HEIGHT_SUPPORT, windowSheetAmountExpanded.getHeightSupport());

                Map<KeyWorks, Boolean> additionalOptions = new HashMap<>();
                System.out.println(windowSheetAmountExpanded.isSynthetic());
                additionalOptions.put(SYNTHETIC_BOOL, windowSheetAmountExpanded.isSynthetic());
                additionalOptions.put(PLATES_BOOL, windowSheetAmountExpanded.isPlates());
                additionalOptions.put(ALARM_TAPE_BOOL, windowSheetAmountExpanded.isAlarmTape());
                additionalOptions.put(BOARD_BOOL, windowSheetAmountExpanded.isBoard());
                additionalOptions.put(CRUSHED_STONE_BOOL, windowSheetAmountExpanded.isCrushedStone());
                System.out.println("Plate bool " +windowSheetAmountExpanded.isPlates());
                owner.sheetAmount(worksVolumeMap, additionalOptions);
            }
            if (buttonsListener instanceof ButtonsListenerCalculateAll) {
                owner.calculateAll();
            }
            if (buttonsListener instanceof ComboBoxListenerDistrict) {
                System.out.println("Combo box work");
                if (!((WindowSheetAmountExpanded)structWindow.getActivity()).getChoiseDistrict().isEmpty())
                    update();
            }
        }
        if (!(windowView instanceof WindowSimpleError)) {
            if (buttonsListener instanceof ButtonsListenerExit) {
                deleteWindow();
            }
        }
        if (windowView instanceof WindowSimpleError) {
            System.out.println("ttttt");
            if (buttonsListener instanceof ButtonsListenerOk) {
                deleteWindow();
            }
        }
    }

    private void deleteWindow() {
        System.out.println("test");
        structWindow.removeActivity();
        display();
    }

    public void simpleMessage(TegWin simpleError, String errorMessage) {
        WindowView windowSimpleError = windowViewMap.get(simpleError);
        if (windowSimpleError instanceof WindowSimpleError)
            ((WindowSimpleError)windowSimpleError).setMessage(" " + errorMessage + " ");
        if (windowSimpleError instanceof WindowCalculateData)
            ((WindowCalculateData)windowSimpleError).setTextAreaCalculateData(" " +errorMessage +" ");
        addWindow(windowSimpleError);
    }

/*    public void sheetAmount() {
        User user = owner.getCurrentUser();
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
        if (structWindow.getActivity() instanceof WindowSheetAmount) {
            ((WindowSheetAmount) structWindow.getActivity()).setStartingCondition(user.getLogIn(), districtList);
            ((WindowSheetAmount) structWindow.getActivity()).setTrenchType(TYPE_TRENCH);
        }
        if (structWindow.getActivity() instanceof WindowSheetAmountExpanded) {
            ((WindowSheetAmountExpanded) structWindow.getActivity()).setStartingCondition(user.getLogIn(), districtList);
            ((WindowSheetAmountExpanded) structWindow.getActivity()).setTrenchType(TYPE_TRENCH);
        }
        display();
    }*/

    public void update() {
        WindowView windowView = structWindow.getActivity();
        if (windowView instanceof WindowSheetAmountExpanded) {
            WindowSheetAmountExpanded window = (WindowSheetAmountExpanded) windowView;
            String nameDistrict = window.getChoiseDistrict();
            if (UserContainer.getInstance().getDistrictByName(nameDistrict) != null) {
                District dis = UserContainer.getInstance().getDistrictByName(nameDistrict);
                if (dis.getInputDate() instanceof InputDateExpanded) {
                    InputDateExpanded inputDate = (InputDateExpanded) dis.getInputDate();
                    window.setDistrictName(dis.getName());
                    window.setLineLong(inputDate.getLineLong());
                    window.setBranches(inputDate.getQuantityBranches().getValue());
                    window.setLongCrossing(inputDate.getLongCrossing().getValue());
                    window.setQuantitySupport(inputDate.getQuantitySupport().getValue());
                    window.setHeightSupport(inputDate.getHeightSupport().getValue());
                    window.setTrenchType(TypeTrench.trenchBySize(inputDate.getSizeTrench()));

/*                    private JFormattedTextField formattedTextWidthTrench;
                    private JFormattedTextField formattedTextHeightTrench;
                    private JFormattedTextField formattedTextHeightSupport;
                    private JComboBox<String> comboBoxTypeTrench;
                    private JComboBox<String> comboBoxPipeStock;
                    private JComboBox<String> comboBoxTypePipe;
                    private JComboBox<String> comboBoxAllDistrict;
                    private JCheckBox lightingCheckBox;
                    private JCheckBox syntheticMaterialCheckBox;
                    private JCheckBox layingOfPlatesCheckBox;
                    private JCheckBox alarmTapeCheckBox;
                    private JCheckBox fillingCrushedStoneCheckBox;
                    private JCheckBox boardCheckBox;
                    private JButton buttonBack;
                    private JButton buttonAddDistrict;
                    private JButton buttonCallculate;
                    private JLabel labelNameUser;*/
                }
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void updateDis() {

    }
}


