/*
 * Created by MVG
 * (C) 2019 Moscow, Russia
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class SendMessagePanel extends JPanel {
    private JTextField textField;
    private JTextArea textArea;
    private String br;
    private Date date;
    private final SimpleDateFormat dateFormat;

    SendMessagePanel(JTextArea textArea) {
        this.textArea = textArea;

        textField = new JTextField() {
            @Override
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };

        br = "";
        dateFormat = new SimpleDateFormat("HH:mm:ss");

        setup();
    }

    private void setup() {
        setLayout(new BorderLayout());
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new SendBtnListener());
        textField.addActionListener(new SendBtnListener());
        Font f = textField.getFont();
        textField.setFont(f.deriveFont(f.getStyle() | Font.BOLD));

        add(textField, BorderLayout.CENTER);
        add(sendButton, BorderLayout.EAST);
    }

    private String getTime() {
        date = new Date();
        return dateFormat.format(date);
    }

    private void append() {
        String text = textField.getText();

        if (!text.isEmpty()) {
            textArea.setText(String.format("%s%s->[%s] %s", textArea.getText(), br, getTime(), text));
            textField.setText("");
            br = "\n";
        }
    }

    private class SendBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                append();
            }

            if (e.getSource() instanceof JTextField) {
                append();
            }
        }
    }

}
