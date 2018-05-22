package 宠物商店文件版;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public  class Cat extends Pet implements   Serializable   {
	private static final long serialVersionUID = 1L;

	public Cat() {
		
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age =age;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost =cost;
	}
	public Cat(String name, String color, String age,String variety,String cost) {	// 通过构造设置属性
		this.setName (name) ;
		this.setColor(color) ;
		this.setAge(age) ;
		this.setVariety(variety);
		this.setCost(cost);
	}
	 public String toString(){   // 覆写toString()方法  
	        return "name：" + this.name + "；color：" + this.color+" age:"+this.age +" variety :"+this.variety+" cost :"+ this.cost ;  
	    }  

}
