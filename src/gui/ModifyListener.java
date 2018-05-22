package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ModifyPanel instance = new ModifyPanel();
		instance.showpanel();
	}

}
