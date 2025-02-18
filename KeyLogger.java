import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class KeyLogger extends JFrame implements KeyListener {
    private static final String LOG_FILE = "keylog.txt";

    public KeyLogger() {
        setTitle("Keylogger");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        logKey(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // You can log special keys here if needed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Can be used for additional logging if needed
    }

    private void logKey(char key) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(key);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyLogger::new);
    }
}
