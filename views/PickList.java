package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.Navigation;
public class PickList implements ActionListener, KeyListener {
    private JPanel pickListPanel;
    private JPanel parent;
    private JFrame frame;
    private PickList(){
        JLabel text = new JLabel("Hello world");
        pickListPanel = new JPanel();
        pickListPanel.add(text);
        pickListPanel.addKeyListener(this);
        pickListPanel.setFocusable(true);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        PickList pickListInstance = new PickList();
        pickListInstance.parent = menu;
        pickListInstance.frame = frame;
        return pickListInstance.pickListPanel;
    }

    public void actionPerformed(ActionEvent e){}
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.pickListPanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
