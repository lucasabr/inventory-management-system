package views;
import javax.swing.*;

import exceptions.NotExpectedLengthException;

import java.awt.*;
import java.awt.event.*;

import functions.CSVReadAndUpdate;
import functions.Navigation;
public class AddNew implements ActionListener, KeyListener {
    private JPanel addNewPanel;
    private JPanel parent;
    private JButton button;
    private JFrame frame;
    private AddNew(){
        button = new JButton("Choose File");
        button.addActionListener(this);
        addNewPanel = new JPanel();
        addNewPanel.add(button);
        addNewPanel.addKeyListener(this);
        addNewPanel.setFocusable(true);
    }
    public static JPanel getInstance(JPanel menu, JFrame frame){
        AddNew addNewInstance = new AddNew();
        addNewInstance.parent = menu;
        addNewInstance.frame = frame;
        return addNewInstance.addNewPanel;
    }

    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==button) {
    		
    		JFileChooser fc = new JFileChooser();
    		int response = fc.showOpenDialog(null);
    		
    		if(response == JFileChooser.APPROVE_OPTION) {
    			try {
					CSVReadAndUpdate.readFile(6, fc.getSelectedFile().getAbsolutePath());
				} catch (NotExpectedLengthException e1) {
					JOptionPane.showMessageDialog(this.frame, e1.getMessage());
				}
    		}
    	}
    	this.addNewPanel.requestFocus();
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.addNewPanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
