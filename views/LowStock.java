package views;
import javax.swing.*;
public class LowStock {
    private JPanel lowStockPanel;
    private JPanel parent;
    private JFrame frame;
    private LowStock(){
        JLabel text = new JLabel("Hello world");
        lowStockPanel = new JPanel();
        lowStockPanel.add(text);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        LowStock lowStockInstance = new LowStock();
        lowStockInstance.frame = frame;
        lowStockInstance.parent = menu;
        return lowStockInstance.lowStockPanel;
    }  
}
