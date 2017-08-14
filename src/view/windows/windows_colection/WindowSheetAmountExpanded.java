package view.windows.windows_colection;

import controller.WindowController;
import view.buttons.sheet_amount.ButtonsListenerCalculateAll;
import view.buttons.sheet_amount.ButtonsListenerNewDistrict;
import view.buttons.user_reg.ButtonsListenerExit;
import view.windows.WindowView;

import javax.swing.*;

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
    private JComboBox comboBoxTypeTrench;
    private JComboBox comboBoxPipeStock;
    private JComboBox comboBoxTypePipe;
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
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
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
}
