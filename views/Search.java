package views;
import javax.swing.*;
public class Search {
    private JPanel searchPanel;
    private JPanel parent;
    private JFrame frame;

    private Search(){
        JLabel text = new JLabel("Hello world");
        searchPanel = new JPanel();
        searchPanel.add(text);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        Search searchInstance = new Search();
        searchInstance.parent = menu;
        searchInstance.frame = frame;
        return searchInstance.searchPanel;
    }
}
