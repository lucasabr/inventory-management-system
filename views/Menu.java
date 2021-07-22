package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu implements ActionListener{
    private JPanel menuPanel;
    private JButton search;
    private JButton update;
    private JButton pickList;
    private JButton lowStock;
    private JLabel title;
    private JFrame frame;
    private JPanel searchPanel;
    private JPanel updatePanel;
    private JPanel pickListPanel;
    private JPanel lowStockPanel;

    private void initChildren(){
        searchPanel = Search.getInstance(this.menuPanel, this.frame);
        updatePanel = Update.getInstance(this.menuPanel, this.frame);
        pickListPanel = PickList.getInstance(this.menuPanel, this.frame);
        lowStockPanel = LowStock.getInstance(this.menuPanel, this.frame);
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
        update = new JButton("Forms");
        pickList = new JButton("Picklist");
        lowStock = new JButton("Low Stock Count");
        search.addActionListener(this);
        update.addActionListener(this);
        pickList.addActionListener(this);
        lowStock.addActionListener(this);
        buttons.add(search);
        buttons.add(update);
        buttons.add(pickList);
        buttons.add(lowStock);
        return buttons;
    }

    private Menu(){
        title = new JLabel("Inventory Management Software");
        JPanel buttons = createButtons();
        createLayout(title, buttons);
        initChildren();
    }

    public static JPanel getInstance(JFrame frame){
        Menu menuInstance = new Menu();
        menuInstance.frame = frame;
        return menuInstance.menuPanel;
    }

    private void updateScreen(JPanel next) {
        frame.remove(this.menuPanel);
        frame.add(next);
        frame.revalidate();
        frame.repaint();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==update) updateScreen(this.updatePanel);
        else if(e.getSource()==search) updateScreen(this.searchPanel);
        else if(e.getSource()==pickList) updateScreen(this.pickListPanel);
        else if(e.getSource()==lowStock) updateScreen(this.lowStockPanel);
    }
}
