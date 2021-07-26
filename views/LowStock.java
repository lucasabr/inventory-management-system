package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.Navigation;
public class LowStock implements ActionListener, KeyListener {
    private JPanel lowStockPanel;
    private JPanel parent;
    private JFrame frame;
    private LowStock(){
        JLabel text = new JLabel("Hello world");
        lowStockPanel = new JPanel();
        lowStockPanel.add(text);
        lowStockPanel.addKeyListener(this);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        LowStock lowStockInstance = new LowStock();
        lowStockInstance.frame = frame;
        lowStockInstance.parent = menu;
        return lowStockInstance.lowStockPanel;
    }  


    public void actionPerformed(ActionEvent e){}
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.lowStockPanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
