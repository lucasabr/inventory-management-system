package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.Navigation;
public class Update implements ActionListener, KeyListener{
    private JPanel updatePanel;
    private JFrame frame;
    private JPanel parent;
    private JButton damages;
    private JButton receive;
    private JPanel createButtons(){
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttons.setLayout(new GridLayout(1, 2));
        receive = new JButton("Search Items");
        damages = new JButton("Forms");
        receive.addActionListener(this);
        damages.addActionListener(this);
        buttons.add(damages);
        buttons.add(receive);
        return buttons;
    }
    private void createLayout(JLabel title, JPanel buttons){
        this.updatePanel = new JPanel();
        this.updatePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        this.updatePanel.add(title, c);
        c.ipady=300;
        c.ipadx=650;
        c.gridy = 1;
        this.updatePanel.add(buttons, c);
    }

    private Update(){
        JLabel text = new JLabel("Update Stock");
        updatePanel = new JPanel();
        JPanel buttons = createButtons();
        createLayout(text, buttons);
        updatePanel.addKeyListener(this);
        updatePanel.setFocusable(true);
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
