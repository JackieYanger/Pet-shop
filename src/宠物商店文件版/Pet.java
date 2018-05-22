package 宠物商店文件版;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public  class Pet  implements   Serializable{
	private static final long serialVersionUID = 1L;
	public String name;			// 宠物名字
	public String color;			// 宠物颜色
	public String age;			// 宠物年龄
	public String  variety ;   // 宠物品种
    public String cost; //宠物价钱
  //  public static Pet pet= new Pet();
	
}
