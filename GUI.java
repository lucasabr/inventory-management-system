import javax.swing.*;
import views.Menu;
public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        JPanel menu = Menu.getInstance();
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main() {
        new GUI();
    }
}