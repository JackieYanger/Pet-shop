package �����̵��ļ���;

import java.util.ArrayList;
//�������ɾ�Ĳ�
public class PetShop {
	public  ArrayList<Pet> Pets  =new ArrayList<Pet>();
	private int foot;				// ���ݵı���λ��
	public PetShop() {				// ���췽�����ٳ�������Ĵ�С
	  
	}
	
	public int getFoot() {
		return foot;
	}

	public void setFoot(int foot) {
		this.foot = foot;
	}
//add pets in the end
	public void add(Pet pets) {			// ���ӳ���
		Pets.add(pets);
	}
	//add pets by location
	public void add(int location,Pet pets) {
		if(location<0||location>Pets.size())
		{
			System.out.println(" Your insert is illegal��");
			return ;
		}
		Pets.add(location,pets);
	}
  //remove by pets'name
	public void delete(Pet pets) {
		if(Pets.isEmpty()) {
			System.out.println("List is empty!");
			return ;
		}
		Pets.remove(pets);
	}
	//remove by location
  public void delete(int location) {
	  if(location>Pets.size()) {
		  System.out.println("Your input is out of range!");
		  return ;
	  }
		if(Pets.isEmpty()) {
			System.out.println("List is empty!");
			return ;
		}
		Pets.remove(location);
	}
  //get pets' location
  public int pets_location(Pet pets) {
	  if(Pets.contains(pets)==false)
		  return 0;
	  else
	  return Pets.indexOf(pets);
  }
  //get pets
  public Pet finds(Pet pets) {
	  if(Pets.contains(pets)==false)
		  return null;
	  else
	  return  Pets.get(pets_location(pets));
  }
  //name modify
  public void modify(Pet pets,String name) {
	  finds(pets).name = name ;
  }
  //age modify
//  public void modify(Pet pets,String age) {
//	  finds(pets).age = age ;
//  }
}
