package gui;

import java.io.IOException;

import javax.swing.JPanel;

import gui_service.FileSender;

public class WritePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public void showpanel() throws IOException {
		// TODO Auto-generated method stub
		 new FileSender().start();
	     new FileIncepter().start(); 
	}

}
