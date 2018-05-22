package gui_service;

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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;

import gui.InsertPanel;
import gui.MainPanel;
import 宠物商店文件版.Cat;
import 宠物商店文件版.Pet;
//服务端
public class FileSender extends Thread{  
	static {
		MainPanel.GUINF();
	}
    private ServerSocket ss=null;  
    public FileSender() throws IOException{  
    
    }  
    public void sendFile(String filePath,int port){  
        DataOutputStream dos=null;  
        DataInputStream dis=null;  
        
        File file = new File("D:/Pet.txt");
        if(file.exists()){
                 ObjectInputStream ois;
                 try {
               FileInputStream fn=new FileInputStream(file);
              ois = new ObjectInputStream(fn);
              int i =0 ;
              while(fn.available()>0){//代表文件还有内容
           
             ArrayList <Cat> p = ( ArrayList <Cat>)ois.readObject();//从流中读取对象

             // System.out.println(p.get(i).name);
              i++ ;

             }

              ois.close();//注意在循环外面关闭
            } catch (Exception e1) {
            // TODO Auto-generated catch block
           e1.printStackTrace();
            }
        }
        Socket socket=null;  
        try {  
           File file1=new File(filePath);  
            ss=new ServerSocket(port);  
            socket=ss.accept();  
            dos=new DataOutputStream(socket.getOutputStream());  
            dis=new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));  
              
            int buffferSize=1024;  
            byte[]bufArray=new byte[buffferSize];  
            dos.writeUTF(file1.getName());   
            dos.flush();   
            dos.writeLong((long) file1.length());   
            dos.flush();   
            while (true) {   
                int read = 0;   
                if (dis!= null) {   
                  read = dis.read(bufArray);   
                }   
  
                if (read == -1) {   
                  break;   
                }   
                dos.write(bufArray, 0, read);   
              }   
              dos.flush();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } finally {   
              // 关闭所有连接   
              try {   
                if (dos != null)   
                  dos.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (dis != null)   
                  dis.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (socket != null)   
                  socket.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (ss != null)   
                  ss.close();   
              } catch (IOException e) {   
              }   
            }   
 
  
    }  
    public void run() {
	    try {
	    	new FileSender().sendFile("D:/Pet.txt", 8821);
	    	JDialog dia1 = new JDialog();
	    	dia1.setTitle("提示！");
			dia1.setSize(200, 150);
			dia1.setLocation(390, 300);
			JLabel label1 = new JLabel("       data from Client is uploading......");
			dia1.add(label1);
			dia1.setModal(true);
			dia1.setVisible(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  }
    public static void main(String []args) throws Exception{  
        new FileSender().start();
   
    }  
}    