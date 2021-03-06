package view.windows.windows_colection;

import controller.WindowController;
import model.district.District;
import view.buttons.ComboBoxListenerDistrict;
import view.buttons.sheet_amount.ButtonsListenerCalculateAll;
import view.buttons.sheet_amount.ButtonsListenerNewDistrict;
import view.buttons.user_reg.ButtonsListenerExit;
import view.windows.WindowView;

import javax.swing.*;
import java.util.List;

import static model.constant.Pipe.PIPE_STOCK;
import static model.constant.Pipe.TYPE_PIPE;
import static model.constant.TypeTrench.TYPE_TRENCH;
import static model.constant.WindowConstant.*;

/**
 * Created by myasnikov
 * on 10.08.2017.
 */
public class WindowSheetAmountExpanded extends WindowView {
    private JPanel jPanel;
    private JFormattedTextField formattedNameDistrict;
    private JFormattedTextField formattedTextLineLong;
    private JFormattedTextField formattedTextBranches;
    private JFormattedTextField formattedTextSupport;
    private JFormattedTextField formattedTextWidthTrench;
    private JFormattedTextField formattedTextHeightTrench;
    private JFormattedTextField formattedTextLongCrossing;
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
    private JLabel labelNameUser;


    public WindowSheetAmountExpanded(WindowController owner) {
        super(owner);
        this.getContentPane().add(jPanel);
        buttonBack.addActionListener(new ButtonsListenerExit(this));
        buttonAddDistrict.addActionListener(new ButtonsListenerNewDistrict(this));
        buttonCallculate.addActionListener(new ButtonsListenerCalculateAll(this));
        comboBoxAllDistrict.addActionListener(new ComboBoxListenerDistrict(this));
        setBox(comboBoxTypeTrench, TYPE_TRENCH);
        setBox(comboBoxPipeStock, PIPE_STOCK);
        setBox(comboBoxTypePipe, TYPE_PIPE);
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
    }


    public void startingCondition(String userName, List<District> districtList) {
 //       String nameDistrict = String.valueOf(comboBoxAllDistrict.getSelectedItem());
        comboBoxAllDistrict.removeAllItems();
        for (District district : districtList) {
            comboBoxAllDistrict.addItem(district.getName());
            System.out.println(district.getName());
        }
/*        District district = null;
        this.labelNameUser.setText(" < " +userName +" > ");
        for (District dis : districtList) {
            if (dis.getName().equals(nameDistrict)) {
                district = dis;
            }

        }
        if (district != null) { // TODO: 15.08.2017
            formattedTextLineLong.setText(String.valueOf(district.getInputDate().getLineLong()));
        }*/
    }


    public void setUserName(String name) {
        labelNameUser.setText(name);
    }

    public String getNameDistrict() {
        return formattedNameDistrict.getText();
    }

    public String getTypeTrench() {
        return String.valueOf(comboBoxTypeTrench.getSelectedItem());
    }

    public String getLineLOng() {
        return formattedTextLineLong.getText();
    }

    public String getBranches() {
        return formattedTextBranches.getText();
    }

    public String getLongCrossing() {
        return formattedTextLongCrossing.getText();
    }

    public String getPipeStock() {
        return String.valueOf(comboBoxPipeStock.getSelectedItem());
    }

    public String getQuantitySupport() {
        return formattedTextSupport.getText();
    }
    public String getHeightSupport() {
        return formattedTextHeightSupport.getText();
    }

    public String getPipeType() {
        return String.valueOf(comboBoxTypePipe.getSelectedItem());
    }

    public boolean isLighting() {
        return lightingCheckBox.isSelected();
    }

    public boolean isSynthetic() {
        return syntheticMaterialCheckBox.isSelected();
    }

    public boolean isPlates() {
        return layingOfPlatesCheckBox.isSelected();
    }
    public boolean isAlarmTape() {
        return alarmTapeCheckBox.isSelected();
    }
    public boolean isCrushedStone() {
        return fillingCrushedStoneCheckBox.isSelected();
    }
    public boolean isBoard() {
        return boardCheckBox.isSelected();
    }

    public void setBox(JComboBox<String> comboBox, final String[] trenchType) {
        for (String string : trenchType)
            comboBox.addItem(string);
    }

    public String getChoiseDistrict() {
        System.out.println(String.valueOf(comboBoxAllDistrict.getSelectedItem()));
        return String.valueOf(comboBoxAllDistrict.getSelectedItem());
    }

    public void setLineLong(float lineLong) {
        formattedTextLineLong.setText(String.valueOf(lineLong));
    }

    public void setBranches(Integer branches) {
        formattedTextBranches.setText(String.valueOf(branches));
    }

    public void setDistrictName(String districtName) {
        formattedNameDistrict.setText(districtName);
    }

    public void setLongCrossing(Number longCrossing) {
        formattedTextLongCrossing.setText(String.valueOf(longCrossing));
    }

    public void setQuantitySupport(Integer quantitySupport) {
        formattedTextSupport.setText(String.valueOf(quantitySupport));
    }

    public void setHeightSupport(Integer heightSupport) {
        formattedTextHeightSupport.setText(String.valueOf(heightSupport));
    }

    public void setTrenchType(String trenchType) {
        comboBoxTypeTrench.setSelectedItem(trenchType);
    }
}
