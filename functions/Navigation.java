package functions;
import javax.swing.*;
public class Navigation {
    public static void navigate(JPanel before, JPanel after, JFrame frame){
        if(after==null) System.exit(0);
        frame.remove(before);
        frame.add(after);
        after.setFocusable(true);
        frame.revalidate();
        frame.repaint();
    }
}
