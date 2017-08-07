package view.windows.windows_colection;

import controller.WindowController;
import model.district.District;
import view.buttons.sheet_amount.ButtonsListenerCalculateAll;
import view.buttons.sheet_amount.ButtonsListenerCalculateThis;
import view.buttons.sheet_amount.ButtonsListenerEdit;
import view.buttons.sheet_amount.ButtonsListenerNewDistrict;
import view.buttons.user_reg.ButtonsListenerExit;
import view.windows.WindowView;

import javax.swing.*;
import java.util.List;

import static model.constant.TypeTrench.TYPE_TRENCH;
import static model.constant.WindowConstant.*;

/**
 * Created by myasnikov
 * on 02.08.2017.
 */
public class WindowSheetAmount extends WindowView{
    private JComboBox<String> comboBoxDistrictsName;
    private JButton exit;
    private JButton newDistrict;
    private JButton edit;
    private JFormattedTextField formattedTextLineLong;
    private JFormattedTextField formattedTextCountCrossing;
    private JButton calculateThis;
    private JButton calculateAll;
    private JComboBox<String> comboBoxTypeTrench;
    private JPanel jPanel;
    private JLabel userName;
    private JFormattedTextField formattedTextNewDistrict;


    public WindowSheetAmount(WindowController windowController) {
        super(windowController);
        exit.addActionListener(new ButtonsListenerExit(this));
        newDistrict.addActionListener(new ButtonsListenerNewDistrict(this));
        edit.addActionListener(new ButtonsListenerEdit(this));
        calculateThis.addActionListener(new ButtonsListenerCalculateThis(this));
        calculateAll.addActionListener(new ButtonsListenerCalculateAll(this));
        setTrenchType(TYPE_TRENCH);
        this.getContentPane().add(jPanel);
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);

    }
    public void setStartingCondition(String userName, List<District> districtList) {
        String str = String.valueOf(comboBoxDistrictsName.getSelectedItem());
        comboBoxDistrictsName.removeAllItems();
        comboBoxTypeTrench.removeAllItems();
        for (District district : districtList) {
            comboBoxDistrictsName.addItem(district.getName());
        }
        District district = null;
        this.userName.setText(" < " +userName +" > ");
        for (District dis : districtList) {
            if (dis.getName().equals(str)) {
                district = dis;
            }

        }
        if (district != null) {
            formattedTextLineLong.setText(String.valueOf(district.getInputDate().getLineLong()));
            formattedTextCountCrossing.setText(String.valueOf(district.getInputDate().getNumberOfCrossings()));
            formattedTextNewDistrict.setText(String.valueOf(district.getName()));
        }
    }
    public void setTrenchType(String[] trenchType) {
        for (String string : trenchType)
            comboBoxTypeTrench.addItem(string);
    }
    public String getLineLong() {
        return formattedTextLineLong.getText();
    }
    public String getCrossing() {
        return formattedTextCountCrossing.getText();
    }
    public String getNameDistrict() {
        return formattedTextNewDistrict.getText();
    }
    public String getTypeTrench() {
        return String.valueOf(comboBoxTypeTrench.getSelectedItem());
    }
    public String getSelectedDistrict() {
        return String.valueOf(comboBoxDistrictsName.getSelectedItem());
    }
}
