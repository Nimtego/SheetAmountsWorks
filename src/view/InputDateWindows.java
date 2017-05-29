package view;

import controller.Header;

import javax.swing.*;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class InputDateWindows extends JFrame{
    private Header header;
    private JFormattedTextField formattedLinesLong;
    private JFormattedTextField formattedNameSite;
    private JButton buttonExit;
    private JButton buttonClear;
    private JButton buttonNewSite;
    private JButton buttonSaveSite;
    private JLabel labelLinesLong;
    private JLabel labelPower;
    private JLabel labelVoltage;
    private JComboBox comboBoxCableType;
    private JLabel labelCableType;
    private JLabel labelNameSite;
    private JLabel labelDescription;
    private JFormattedTextField formattedPower;
    private JFormattedTextField formattedVoltage;
    private JPanel inputDateWindows;
    private JTextArea textAreaDescription;

    public InputDateWindows(final Header header) {
        this.getContentPane().add(inputDateWindows);
/*        JScrollPane scrollPane = new JScrollPane(textAreaDescription);
        scrollPane.setBounds(10,60,780,500);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
        this.header = header;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void clearTextField() {
        formattedLinesLong.setText("");
        formattedPower.setText("");
        formattedVoltage.setText("");
        formattedNameSite.setText("");
        textAreaDescription.setText("");
    }

    public JFormattedTextField getFormattedLinesLong() {
        return formattedLinesLong;
    }

    public void setFormattedLinesLong(JFormattedTextField formattedLinesLong) {
        this.formattedLinesLong = formattedLinesLong;
    }

    public JFormattedTextField getFormattedNameSite() {
        return formattedNameSite;
    }

    public void setFormattedNameSite(JFormattedTextField formattedNameSite) {
        this.formattedNameSite = formattedNameSite;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(JButton buttonExit) {
        this.buttonExit = buttonExit;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public void setButtonClear(JButton buttonClear) {
        this.buttonClear = buttonClear;
    }

    public JButton getButtonNewSite() {
        return buttonNewSite;
    }

    public void setButtonNewSite(JButton buttonNewSite) {
        this.buttonNewSite = buttonNewSite;
    }

    public JButton getButtonSaveSite() {
        return buttonSaveSite;
    }

    public void setButtonSaveSite(JButton buttonSaveSite) {
        this.buttonSaveSite = buttonSaveSite;
    }

    public JLabel getLabelLinesLong() {
        return labelLinesLong;
    }

    public void setLabelLinesLong(JLabel labelLinesLong) {
        this.labelLinesLong = labelLinesLong;
    }

    public JLabel getLabelPower() {
        return labelPower;
    }

    public void setLabelPower(JLabel labelPower) {
        this.labelPower = labelPower;
    }

    public JLabel getLabelVoltage() {
        return labelVoltage;
    }

    public void setLabelVoltage(JLabel labelVoltage) {
        this.labelVoltage = labelVoltage;
    }

    public JComboBox getComboBoxCableType() {
        return comboBoxCableType;
    }

    public void setComboBoxCableType(JComboBox comboBoxCableType) {
        this.comboBoxCableType = comboBoxCableType;
    }

    public JLabel getLabelCableType() {
        return labelCableType;
    }

    public void setLabelCableType(JLabel labelCableType) {
        this.labelCableType = labelCableType;
    }

    public JLabel getLabelNameSite() {
        return labelNameSite;
    }

    public void setLabelNameSite(JLabel labelNameSite) {
        this.labelNameSite = labelNameSite;
    }

    public JLabel getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(JLabel labelDescription) {
        this.labelDescription = labelDescription;
    }

    public JFormattedTextField getFormattedPower() {
        return formattedPower;
    }

    public void setFormattedPower(JFormattedTextField formattedPower) {
        this.formattedPower = formattedPower;
    }

    public JFormattedTextField getFormattedVoltage() {
        return formattedVoltage;
    }

    public void setFormattedVoltage(JFormattedTextField formattedVoltage) {
        this.formattedVoltage = formattedVoltage;
    }

    public JPanel getInputDateWindows() {
        return inputDateWindows;
    }

    public void setInputDateWindows(JPanel inputDateWindows) {
        this.inputDateWindows = inputDateWindows;
    }

    public JTextArea getTextAreaDescription() {
        return textAreaDescription;
    }

    public void setTextAreaDescription(JTextArea textAreaDescription) {
        this.textAreaDescription = textAreaDescription;
    }
}


