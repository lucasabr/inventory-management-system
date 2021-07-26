package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.Navigation;
public class Update implements ActionListener, KeyListener{
    private JPanel updatePanel;
    private JFrame frame;
    private JPanel parent;


    private Update(){
        JLabel text = new JLabel("Hello world");
        updatePanel = new JPanel();
        updatePanel.add(text);
        updatePanel.addKeyListener(this);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        Update updateInstance = new Update();
        updateInstance.frame = frame;
        updateInstance.parent = menu;
        return updateInstance.updatePanel;
    }



    public void actionPerformed(ActionEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.updatePanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
