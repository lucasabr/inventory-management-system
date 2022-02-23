package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import exceptions.NotExpectedLengthException;
import functions.CSVReadAndUpdate;
import functions.Navigation;

public class Receive implements ActionListener, KeyListener{
	
    private JFrame frame;
    private JPanel parent, receivePanel;
    private JButton button;
	
    private Receive(JFrame frame) {
    	button = new JButton("Receive new orders");
    	button.addActionListener(this);
    	receivePanel = new JPanel();
    	receivePanel.add(button);
    	this.frame = frame;
    	receivePanel.addKeyListener(this);
    	receivePanel.setFocusable(true);
    }
    
    public static JPanel getInstance(JPanel parent, JFrame frame){
        Receive receiveInstance = new Receive(frame);
        receiveInstance.parent = parent;
        return receiveInstance.receivePanel;
    
    }
    
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==button) {
    		
    		JFileChooser fc = new JFileChooser();
    		int response = fc.showOpenDialog(null);
    		
    		if(response == JFileChooser.APPROVE_OPTION) {
    			try {
					CSVReadAndUpdate.readFile(2, fc.getSelectedFile().getAbsolutePath());
				} catch (NotExpectedLengthException e1) {
					JOptionPane.showMessageDialog(this.frame, e1.getMessage());
				}
    		}
    	}
    	this.receivePanel.requestFocus();
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.receivePanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
    
}
