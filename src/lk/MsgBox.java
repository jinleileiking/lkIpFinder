package lk;

import javax.swing.JOptionPane;

public class MsgBox {
    public static void show(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
