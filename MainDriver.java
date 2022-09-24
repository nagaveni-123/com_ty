package jdbc.maven;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DAO d=new DAO();
		boolean res=true;
		while(res) {
			System.out.println("1.save Person\n2.Update Person\n3.delete person\n4.select person\n 5.exit");
			int choice=new Scanner(System.in).nextInt();
			switch(choice) {
			case 1:System.out.println("Enetr the id");
			int id=new Scanner(System.in).nextInt();
			System.out.println("Enetr the Name");
			String name=new Scanner(System.in).next();
			System.out.println("Enetr the adress");
			String address=new Scanner(System.in).next();
			System.out.println("Enetr the Phone number");
			Long phone=new Scanner(System.in).nextLong();
			System.out.println("Enetr the Pincode");
			int pin=new Scanner(System.in).nextInt();
				d.savePerson(id, name, address, phone, pin);
			break;
			case 2:System.out.println("Enetr the id");
			int id1=new Scanner(System.in).nextInt();
			System.out.println("Enetr the Name");
			String name1=new Scanner(System.in).next();
			System.out.println("Enetr the adress");
			String address1=new Scanner(System.in).next();
			System.out.println("Enetr the Phone number");
			Long phone1=new Scanner(System.in).nextLong();
			System.out.println("Enetr the Pincode");
			int pin1=new Scanner(System.in).nextInt();
				String a=d.updatePerson(id1, name1, address1, phone1, pin1);
				System.out.println(a);
			break;
			case 3:System.out.println("Enetr the id");
			int id3=new Scanner(System.in).nextInt();
				d.DeletePerson(id3);
			break;
			case 4:System.out.println("Enetr the id");
			int id4=new Scanner(System.in).nextInt();
				d.selectPerson(id4);
			break;
			case 5:res=false;
			break;
			}
			
			
		}
		

	}

}
