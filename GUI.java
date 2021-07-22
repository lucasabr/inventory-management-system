import java.awt.BorderLayout;

import javax.swing.*;
import views.Menu;
public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        JPanel menu = Menu.getInstance();
        frame.add(menu, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
}