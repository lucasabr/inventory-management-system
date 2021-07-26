package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.Navigation;
public class Search implements ActionListener, KeyListener {
    private JPanel searchPanel;
    private JPanel parent;
    private JFrame frame;

    private Search(){
        JLabel text = new JLabel("Hello world");
        searchPanel = new JPanel();
        searchPanel.add(text);
        searchPanel.addKeyListener(this);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        Search searchInstance = new Search();
        searchInstance.parent = menu;
        searchInstance.frame = frame;
        return searchInstance.searchPanel;
    }

    public void actionPerformed(ActionEvent e){}
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.searchPanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
