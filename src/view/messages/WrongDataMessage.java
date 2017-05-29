package view.messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by myasnikov
 * on 29.05.2017.
 */
public class WrongDataMessage {
    public static void wrongEntering(final String message, Point point) {
        JFrame jFrame = new JFrame(message);
        jFrame.setBounds(point.x + 100, point.y + 100, (message.length() + 100) * 2, 100);
        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        JButton jButtonOk = new JButton("OK");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(jButtonOk);
        jFrame.add(buttonsPanel);
        jFrame.add(messageLabel, BorderLayout.NORTH);
        jButtonOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        jFrame.setVisible(true);
    }
}
