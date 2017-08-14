package controller;

import model.constant.KeyWorks;
import model.constant.TypeTrench;
import model.district.District;
import model.input.SizeTrench;
import model.user.User;
import model.user.UserContainer;
import view.StructWindow;
import view.buttons.ButtonsListener;
import view.buttons.ButtonsListenerToExcel;
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
import static model.constant.TypeTrench.TYPE_TRENCH;

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
        windowViewMap = WindowViewFabric.simpleMapView(this);

    }

    public void runWin(TegWin tegWin) {
        switch (tegWin) {
            case USER_REG:
                addWindow(windowViewMap.get(tegWin));
                //create();/*addWindow(windowViewMap.get(tegWin))*/;
                break;
            case SHEET_AMOUNT:
                addWindow(windowViewMap.get(tegWin));
                break;
            case CALCULATION_DATA:
                addWindow(windowViewMap.get(tegWin));
                break;
            case SHEET_AMOUNT_EXP:
                addWindow(windowViewMap.get(tegWin));
                break;
        }
    }



    private void addWindow(WindowView windowView) {
        if (windowView instanceof WindowSheetAmountExpanded) { // TODO: 14.08.2017 переделать 
            ((WindowSheetAmountExpanded) windowView).setUserName(" <" +owner.getCurrentUser().getLogIn() +">");
        }
        windowView.pack();
        if (structWindow != null) {
            structWindow.add(windowView);
        }
        else {
            structWindow = new StructWindow(windowView);
        }
        display();
    }

    private void display() {
        structWindow.getData().setVisible(false);
        for (StructWindow struct : structWindow.getNodes()) {
            struct.getData().setVisible(false);
        }
        structWindow.getActivity().getData().setVisible(true);
    }

    public void buttonReport(ButtonsListener buttonsListener) {
        System.out.println("buttonReport");
        WindowView windowView = structWindow.getActivity().getData();
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
            if (buttonsListener instanceof ButtonsListenerCalculateAll) {
                WindowSheetAmountExpanded windowSheetAmountExpanded =
                        (WindowSheetAmountExpanded) buttonsListener.getOwner();
                Map<KeyWorks, String> worksVolumeMap = new HashMap<>();
                SizeTrench sizeTrench = TypeTrench.size(windowSheetAmountExpanded.getTypeTrench());

                worksVolumeMap.put(NAME_DISTRICT, windowSheetAmountExpanded.getNameDistrict());
                worksVolumeMap.put(TRENCH_HEIGHT, String.valueOf(sizeTrench.getHeight()));
                worksVolumeMap.put(TRENCH_WIDTH, String.valueOf(sizeTrench.getWidth()));
                worksVolumeMap.put(LINE_LONG, windowSheetAmountExpanded.getLineLOng());
                worksVolumeMap.put(QUANTITY_BRANCHES, windowSheetAmountExpanded.getBranches());
                worksVolumeMap.put(LONG_CROSSING, windowSheetAmountExpanded.getLongCrossing());
                worksVolumeMap.put(PIPE_STOCK, windowSheetAmountExpanded.getPipeStock());
                worksVolumeMap.put(QUANTITY_SUPPORT, windowSheetAmountExpanded.getQuantitySupport());
                worksVolumeMap.put(HEIGHT_SUPPORT, windowSheetAmountExpanded.getHeightSupport());
                // TODO: 14.08.2017  
/*                String nameDistrict = windowSheetAmountExpanded.getNameDistrict();
                String lineLong = windowSheetAmountExpanded.getLineLong();
                String numberOfCrossing = windowSheetAmountExpanded.getCrossing();
                String typeTrench = windowSheetAmountExpanded.getTypeTrench();
                owner.registrSheetAmount(nameDistrict, lineLong, numberOfCrossing, typeTrench);*/
            }
            if (buttonsListener instanceof ButtonsListenerExpanded) {owner.expanded();}
            if (buttonsListener instanceof ButtonsListenerCalculateAll) {
                WindowSheetAmount windowSheetAmount = (WindowSheetAmount) buttonsListener.getOwner();
                owner.calculateAll();
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
        StructWindow forDelete = structWindow.getActivity();
        forDelete.getData().setVisible(false);
        forDelete.getData().dispose();
        //if (!(structWindow.getData() instanceof WindowViewUserReg))
        forDelete.delete();
        structWindow = structWindow.getActivity();
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

    public void sheetAmount() {
        User user = owner.getCurrentUser();
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
        ((WindowSheetAmount) structWindow.getData()).setStartingCondition(user.getLogIn(), districtList);
        ((WindowSheetAmount) structWindow.getData()).setTrenchType(TYPE_TRENCH);
        display();
    }

    public void update() {
        if (structWindow.getData() instanceof WindowSheetAmount)
            sheetAmount();
        else
            display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


