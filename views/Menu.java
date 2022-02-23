package views;
import javax.swing.*;
import functions.Navigation;
import java.awt.*;
import java.awt.event.*;
public class Menu implements ActionListener, KeyListener{
    private JButton search, update, addNew, receive;
    private JLabel title;
    private JFrame frame;
    private JPanel menuPanel, searchPanel, updatePanel, addNewPanel, receivePanel;

    private void initChildren(){
        searchPanel = Search.getInstance(this.menuPanel, this.frame);
        updatePanel = Update.getInstance(this.menuPanel, this.frame);
        addNewPanel = AddNew.getInstance(this.menuPanel, this.frame);
        receivePanel = Receive.getInstance(this.menuPanel, this.frame);
    }
    private void createLayout(JLabel title, JPanel buttons){
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        this.menuPanel.add(title, c);
        c.ipady=300;
        c.ipadx=600;
        c.gridy = 1;
        this.menuPanel.add(buttons, c);
    }
    private JPanel createButtons(){
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttons.setLayout(new GridLayout(2, 2));
        search = new JButton("Search Items");
        update = new JButton("Add Sales");
        addNew = new JButton("Add New Items");
        receive = new JButton("Receive Orders");
        search.addActionListener(this);
        update.addActionListener(this);
        addNew.addActionListener(this);
        receive.addActionListener(this);
        buttons.add(search);
        buttons.add(update);
        buttons.add(addNew);
        buttons.add(receive);
        return buttons;
    }

    private Menu(JFrame frame){
        title = new JLabel("Inventory Management Software");
        JPanel buttons = createButtons();
        createLayout(title, buttons);
        menuPanel.addKeyListener(this);
        menuPanel.setFocusable(true);
        this.frame = frame;
        initChildren();
    }

    public static JPanel getInstance(JFrame frame){
        Menu menuInstance = new Menu(frame);
        return menuInstance.menuPanel;
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==update) Navigation.navigate(this.menuPanel, this.updatePanel, frame);
        else if(e.getSource()==search) Navigation.navigate(this.menuPanel, this.searchPanel, frame);
        else if(e.getSource()==addNew) Navigation.navigate(this.menuPanel, this.addNewPanel, frame);
        else if(e.getSource()==receive) Navigation.navigate(this.menuPanel, this.receivePanel, frame);
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.menuPanel, null, frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
