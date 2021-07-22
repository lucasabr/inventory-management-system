package views;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
public class Menu {
    private JPanel menuPanel;
    private Menu(){
        this.menuPanel = new JPanel();
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttons.setLayout(new GridLayout(2, 2));
        JLabel title = new JLabel("Inventory Management Software");
        JButton search = new JButton("Search Items");
        JButton update = new JButton("Forms");
        JButton pickList = new JButton("Picklist");
        JButton lowStock = new JButton("Low Stock Count");
        buttons.add(search);
        buttons.add(update);
        buttons.add(pickList);
        buttons.add(lowStock);
        menuPanel.setLayout(new GridLayout(2,1));
        menuPanel.add(title);
        menuPanel.add(buttons);

    }
    public static JPanel getInstance(){
        Menu menuInstance = new Menu();
        return menuInstance.menuPanel;
    }
}
