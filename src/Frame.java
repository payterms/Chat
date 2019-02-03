/*
 * Created by MVG
 * (C) 2019 Moscow, Russia
 * */

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

class Frame extends JFrame {

    Frame() {
        setTitle("Net chat");// Заголовк окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 400);
        setBackground(Color.BLACK);

        MainTextPanel bigTextPanel = new MainTextPanel();
        bigTextPanel.setBackground(Color.BLACK);
        SendMessagePanel sendMessagePanel = new SendMessagePanel(bigTextPanel.getTextArea());
        sendMessagePanel.setBackground(Color.BLACK);
        // достаточно центральной и южной частей (в южной разместим поле ввода сообщения и кнопку отправки)
        add(bigTextPanel, BorderLayout.CENTER);
        add(sendMessagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
