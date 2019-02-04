/*
 * Created by MVG
 * (C) 2019 Moscow, Russia
 * */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class MainTextPanel extends JPanel {
    private JTextArea textArea;

    MainTextPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        textArea = new JTextArea();
        textArea.setLineWrap(true);//способность переносить текст
        textArea.setEditable(false);// без возможности редактирования
        Font f = textArea.getFont();// меняем шрифт на наклонный
        textArea.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
        textArea.setForeground(Color.LIGHT_GRAY);

        Border line = BorderFactory.createLineBorder(Color.WHITE);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        textArea.setBorder(border);
        textArea.setBackground(Color.DARK_GRAY);

        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane, BorderLayout.CENTER);// размещаем в центральной части главной панели
    }

    JTextArea getTextArea() {
        return textArea;
    }
}
