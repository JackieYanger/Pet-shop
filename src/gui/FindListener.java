package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindListener  implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		FindPanel instance = new FindPanel();
		instance.showpanel();
	}

}
