package views;
import javax.swing.*;
public class Update {
    private JPanel updatePanel;
    private JFrame frame;
    private JPanel parent;
    private Update(){
        JLabel text = new JLabel("Hello world");
        updatePanel = new JPanel();
        updatePanel.add(text);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        Update updateInstance = new Update();
        updateInstance.frame = frame;
        updateInstance.parent = menu;
        return updateInstance.updatePanel;
    }
}
