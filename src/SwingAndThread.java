import javax.swing.*;
import java.awt.*;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SwingAndThread extends JFrame {

    int count = 0;

    public SwingAndThread() {
        setBounds(300, 200, 250, 100);
        Container container = getContentPane();
        container.setLayout(null);

        Icon icon = new ImageIcon("src/messi.jpeg");
        JLabel jl = new JLabel(icon);
        jl.setBounds(10, 10, 200, 50);
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    jl.setBounds(count, 10, 200, 50);
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count += 4;
                    if (count >= 200) {
                        count = 10;
                    }
                }
            }
        };
        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new SwingAndThread();
    }
}