package 宠物商店文件版;

public class Dog extends Pet {
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
		this.age = age;
	}

	public Dog(String name, String color, String age,String variety) {	// 通过构造设置属性
		this.setName (name) ;
		this.setColor(color) ;
		this.setAge(age) ;
		this.setVariety(variety);
	}

}
