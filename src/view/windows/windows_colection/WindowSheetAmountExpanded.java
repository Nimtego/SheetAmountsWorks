package view.windows.windows_colection;

import controller.WindowController;
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
    private JFormattedTextField formattedNameDistrict;
    private JFormattedTextField formattedTextLineLong;
    private JFormattedTextField formattedTextBranches;
    private JFormattedTextField formattedTextSupport;
    private JComboBox comboBoxTypeTrench;
    private JFormattedTextField formattedTextWidthTrench;
    private JFormattedTextField formattedTextHeightTrench;
    private JCheckBox lightingCheckBox;
    private JFormattedTextField formattedTextLongCrossing;
    private JComboBox comboBoxPipeStock;
    private JFormattedTextField formattedTextHeightSupport;
    private JCheckBox syntheticMaterialCheckBox;
    private JButton buttonBack;
    private JButton buttonAddDistrict;
    private JPanel jPanel;
    private JCheckBox layingOfPlatesCheckBox;
    private JCheckBox alarmTapeCheckBox;
    private JCheckBox fillingCrushedStoneCheckBox;
    private JCheckBox boardCheckBox;
    private JComboBox comboBoxTypePipe;
    private JLabel labelNameUser;

    public WindowSheetAmountExpanded(WindowController owner) {
        super(owner);
        this.getContentPane().add(jPanel);
        buttonBack.addActionListener(new ButtonsListenerExit(this));
        buttonAddDistrict.addActionListener(new ButtonsListenerNewDistrict(this));
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
    }
}
