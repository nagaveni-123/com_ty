package jdbc.maven;

import java.util.Scanner;

public class MainDriverObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		boolean res=true;
		while(res) {
			
			System.out.println("1.save Person\n2.Update Person\n3.select person\n 4.exit");
			int choice=new Scanner(System.in).nextInt();
			switch(choice) {
			case 1:	System.out.println("Enetr the id");
			int id=new Scanner(System.in).nextInt();
			System.out.println("Enetr the Name");
			String name=new Scanner(System.in).next();
			System.out.println("Enetr the adress");
			String address=new Scanner(System.in).next();
			System.out.println("Enetr the Phone number");
			Long phone=new Scanner(System.in).nextLong();
			System.out.println("Enetr the Pincode");
			int pin=new Scanner(System.in).nextInt();
			Person p=new Person();
			p.setId(id);
			p.setName(name);
			p.setAdress(address);
			p.setPhone(phone);
			p.setPincode(pin);
				String res1=p.savePerson(p);
			System.out.println(res);
			case 2:	System.out.println("Enetr the id");
			int id1=new Scanner(System.in).nextInt();
			System.out.println("Enetr the Name");
			String name1=new Scanner(System.in).next();
			System.out.println("Enetr the adress");
			String address1=new Scanner(System.in).next();
			System.out.println("Enetr the Phone number");
			Long phone1=new Scanner(System.in).nextLong();
			System.out.println("Enetr the Pincode");
			int pin1=new Scanner(System.in).nextInt();
			Person p1=new Person();
			p1.setId(id1);
			p1.setName(name1);
			p1.setAdress(address1);
			p1.setPhone(phone1);
			p1.setPincode(pin1);
				String res2=p1.updatePerson(p1);
			System.out.println(res2);
			break;
			
			case 3:System.out.println("Enetr the id");
			int id2=new Scanner(System.in).nextInt();
			Person p3=new Person();
			Person person =p3.gettPerson(id2);
			System.out.println(person.getId());
			System.out.println(person.getName());
			System.out.println(person.getAdress());
			System.out.println(person.getPhone());
			System.out.println(person.getPincode());
			break;
			case 4:res=false;
			
			
			
			
			
			}
		}
	}

}
