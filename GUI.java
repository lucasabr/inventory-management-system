import java.awt.BorderLayout;
import javax.swing.*;
import views.Menu;
public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        JPanel menu = Menu.getInstance(frame);
        frame.add(menu, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Inventory Management System");
    }
    public static void main(String[] args) {
        new GUI();
    }
}