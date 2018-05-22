package gui;

import 宠物商店文件版.Cat;
import 宠物商店文件版.Pet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

//客户端
public class FileIncepter extends Thread{  
    JDialog dialog = new JDialog();
	
     JPanel panel = new JPanel();
     JLabel label_1 = new JLabel();
     JLabel label_2 = new JLabel();
     JLabel label_3 = new JLabel();
     JLabel label_4 = new JLabel();
	static {
		MainPanel.GUINF();
	}
    public FileIncepter(){  
          
    }  
    public void receiveFile(String savePath,String ip,int port){  
        Socket socket=null;  
        try {   
            socket = new Socket(ip,port);   
          } catch (UnknownHostException e1) {   
            e1.printStackTrace();   
          } catch (IOException e1) {   
            e1.printStackTrace();   
          }   
        DataInputStream dis=null;  
        try {   
            dis = new DataInputStream(new BufferedInputStream(socket   
                .getInputStream()));   
          } catch (IOException e1) {   
            e1.printStackTrace();   
          }   
        int bufferSize = 1024;   
        // 缓冲区   
        byte[] buf = new byte[bufferSize];   
        int passedlen = 0;   
        long len = 0;   
        // 获取文件名称   
       try{  
        savePath += dis.readUTF();   
        DataOutputStream fileOut = new DataOutputStream(   
            new BufferedOutputStream(new BufferedOutputStream(   
                new FileOutputStream(savePath))));   
        len = dis.readLong();   
    //    JDialog dialog = new JDialog();
 	   dialog.setSize(380, 150);
	   dialog.setLocation(400, 400);	 
	   dialog.setTitle("   Response from the server");
//        JPanel panel = new JPanel();
//        JLabel label_1 = new JLabel();
//        JLabel label_2 = new JLabel();
//        JLabel label_3 = new JLabel();
//        JLabel label_4 = new JLabel();
        label_1.setText("文件的长度为:" + len + "    B");
        label_2.setText("开始接收文件!");
//        System.out.println("文件的长度为:" + len + "    B");           
//        System.out.println("开始接收文件!");   
        while (true) {   
            int read = 0;   
            if (dis!= null) {   
              read = dis.read(buf);   
            }   
            passedlen += read;   
            Thread.sleep(1000);
            if (read == -1) {   
              break;   
            }   
            label_3.setText("文件接收了" + (passedlen * 100 / len) + "%");
           // System.out.println("文件接收了" + (passedlen * 100 / len) + "%");   
            fileOut.write(buf, 0, read);   
          }   
        label_4.setText("接收完成，文件存为" + savePath);
       //   System.out.println("接收完成，文件存为" + savePath);   
          fileOut.close();   
          label_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
          label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
          label_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
          label_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
          panel.setLayout(new GridLayout(4,1));
          panel.add(label_1);
          panel.add(label_2);
          panel.add(label_3);
          panel.add(label_4);
          dialog.add(panel);
        
          dialog.setAlwaysOnTop(true);
          dialog.setResizable(false);
          dialog.setVisible(true);
        } catch (Exception e) {   
          e.printStackTrace();   
          return;   
        }   
       
    }  
    public void run() {
    	new FileIncepter().receiveFile("D:\\1", "localhost", 8821);   
    	
    
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {   
     //  new FileIncepter().start();
    	File f = new File("D:" + File.separator + "1Pet.txt") ;	// 定义保存路径
		ObjectInputStream ois = null ;	// 声明对象输入流
		InputStream input = new FileInputStream(f) ;	// 文件输入流
		ois = new ObjectInputStream(input) ;	// 实例化对象输入流
		
		ArrayList<Cat> obj = (ArrayList<Cat>)ois.readObject() ;	// 读取对象
		for(int i=0;i<obj.size();i++) {
			System.out.println(obj.get(i).toString());
		}
		
		ois.close() ;	// 关闭
      }    
}  