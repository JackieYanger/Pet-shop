package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		InsertPanel insert = new InsertPanel();
		// TODO Auto-generated method stub
		insert.showpanel();
	}
	
	//public  InsertListener instance = new InsertListener();

}
