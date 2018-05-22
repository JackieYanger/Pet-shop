package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeListener implements ActionListener {

//	public  HomeListener instance =new HomeListener();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		HomePanel instance= new HomePanel();
		instance.showpanel();
	}

}
