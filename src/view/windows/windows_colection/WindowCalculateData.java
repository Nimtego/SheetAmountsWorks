package view.windows.windows_colection;

import controller.WindowController;
import view.buttons.ButtonsListenerToExcel;
import view.buttons.user_reg.ButtonsListenerExit;
import view.windows.WindowView;

import javax.swing.*;

import static model.constant.WindowConstant.*;

/**
 * Created by myasnikov
 * on 07.08.2017.
 */
public class WindowCalculateData extends WindowView {
    private JTextArea textAreaCalculateData;
    private JPanel jPanel;
    private JButton back;
    private JButton toExcel;

    public WindowCalculateData(WindowController windowController) {
        super(windowController);
        back.addActionListener(new ButtonsListenerExit(this));
        toExcel.addActionListener(new ButtonsListenerToExcel(this));
        this.getContentPane().add(jPanel);
        this.setBounds(CENTER_LOCATION_X, CENTER_LOCATION_Y, SIZE_WIDTH, SIZE_HEIGHT);
    }


    public void setTextAreaCalculateData(String string) {
        this.textAreaCalculateData.setText(string);
    }
}
