package views;
import javax.swing.*;

import exceptions.NotExpectedLengthException;

import java.awt.*;
import java.awt.event.*;

import functions.CSVReadAndUpdate;
import functions.Navigation;
public class Update implements ActionListener, KeyListener{
    private JPanel updatePanel;
    private JFrame frame;
    private JPanel parent;
    private JButton button;
    

    private Update(JFrame frame){
        button = new JButton("Choose CSV File");
        button.addActionListener(this);
        updatePanel = new JPanel();
        updatePanel.add(button);
        this.frame = frame;
        updatePanel.addKeyListener(this);
        updatePanel.setFocusable(true);
    }
    
    public static JPanel getInstance(JPanel menu, JFrame frame){
        Update updateInstance = new Update(frame);
        updateInstance.parent = menu;
        return updateInstance.updatePanel;
    }



    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==button) {
    		
    		JFileChooser fc = new JFileChooser();
    		int response = fc.showOpenDialog(null);
    		
    		if(response == JFileChooser.APPROVE_OPTION) {
    			try {
					CSVReadAndUpdate.readFile(3, fc.getSelectedFile().getAbsolutePath());
				} catch (NotExpectedLengthException e1) {
					JOptionPane.showMessageDialog(this.frame, e1.getMessage());
				}
    		}
    	}
    	this.updatePanel.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) Navigation.navigate(this.updatePanel, this.parent, this.frame);
    }


    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}
