package gui_service;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;



public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public void showpanel() throws IOException {
	
	}
	public MainPanel() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
				//��������
//		   try {			   
//	            ServerSocket ss = new ServerSocket(8888);	 
//	            System.out.println("�����ڶ˿ں�:8888");
//	            Socket s = ss.accept();	 
//	            InputStream is = s.getInputStream();
//	            System.out.println(ss.getInetAddress().getHostAddress()+"�������ˣ�"); 
//	            //����������װ��DataInputStream
//	            DataInputStream dis = new DataInputStream(is);
//	            //ʹ��readUTF��ȡ�ַ���
//	            String msg = dis.readUTF();
//	            System.out.println(msg);
//	            dis.close();
//	            s.close();
//	            ss.close();
//	        } catch (IOException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//	 
	}	
}
