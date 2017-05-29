package controller;

import exception.*;
import model.CalculationData;
import model.District;
import model.InputData;
import view.InputDateWindows;
import view.buttons.ButtonClear;
import view.buttons.ButtonExit;
import view.buttons.ButtonSaveSite;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class InputDateController {
    private static int numberDefSite = 1;
    public static InputDateWindows getInstance(final Header header) {
        InputDateWindows inputDateWindows = new InputDateWindows(header);
        inputDateWindows.getButtonClear().addActionListener(new ButtonClear(inputDateWindows));
        inputDateWindows.getButtonExit().addActionListener(new ButtonExit(inputDateWindows));
        inputDateWindows.getButtonSaveSite().addActionListener(new ButtonSaveSite(inputDateWindows));
        inputDateWindows.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inputDateWindows.pack();
        inputDateWindows.setSize(new Dimension(400, 400));
        inputDateWindows.setLocationRelativeTo(null);
        return inputDateWindows;
    }

    public static CalculationData generateInputDate(InputDateWindows inputDateWindows) throws Exception {
        String power = inputDateWindows.getFormattedPower().getText();
        String voltage = inputDateWindows.getFormattedVoltage().getText();
        String lineLong = inputDateWindows.getFormattedLinesLong().getText();
        String nameSite = inputDateWindows.getFormattedNameSite().getText();
        String description = inputDateWindows.getTextAreaDescription().getText();
        if (power.equals("") || voltage.equals("") || lineLong.equals("")) {
            String message = "Not correct ";
            if (power.equals("")) {
                message = message + inputDateWindows.getLabelPower().getText() +" ";
            }
            if (voltage.equals("")) {
                message = message + inputDateWindows.getLabelVoltage().getText() +" ";
            }
            if (lineLong.equals("")) {
                message = message + inputDateWindows.getLabelLinesLong().getText() +" ";
            }
            throw new Exception(message);
        }

        float powerFloat = checkData(power);
        float voltageFloat = checkData(voltage);
        float lineLongFloat = checkData(lineLong);
        InputData inputData = InputData.inputDataBuilder().power(powerFloat)
                    .voltage(voltageFloat)
                    .linesLong(lineLongFloat)
                    .build();
        District district = new District(nameSite.equals("") ? ("DNS №" +numberDefSite++) : nameSite, description);
        System.out.println(district);
        CalculationData calculationData = new CalculationData(district);
        calculationData.setInputData(inputData);
        return calculationData;
    }
    private static float checkData(String power) throws ExceptionSheetWorks {
        for (int i = 0; i < power.length(); i++) {
            if (!Character.isDigit(power.charAt(i))) {
                if (power.charAt(i) != '.' || power.charAt(i) != ',') {
                    throw new ExceptionSheetWorks("NOT DIGITAL");
                }
            }
        }
        return Float.valueOf(power.replaceAll("[^0-9]", ""));
    }
}
