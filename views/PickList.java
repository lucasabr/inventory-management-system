package views;
import javax.swing.*;
public class PickList {
    private JPanel pickListPanel;
    private JPanel parent;
    private JFrame frame;
    private PickList(){
        JLabel text = new JLabel("Hello world");
        pickListPanel = new JPanel();
        pickListPanel.add(text);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        PickList pickListInstance = new PickList();
        pickListInstance.parent = menu;
        pickListInstance.frame = frame;
        return pickListInstance.pickListPanel;
    }
}
