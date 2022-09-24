package jdbc.maven;

import java.util.Scanner;

public class MobileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean res = true;
		while (res) {

			System.out.println("1.Insert Mobile Details\n2.Update Mobile Details\n3.Get Mobile Details\n 4.exit");
			int choice = new Scanner(System.in).nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enetr the id");
				int id = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Name of the mobile");
				String name = new Scanner(System.in).next();
				System.out.println("Enetr the brand of the mobile");
				String brand = new Scanner(System.in).next();
				System.out.println("Enetr the color:");
				String color = new Scanner(System.in).next();
				System.out.println("Enetr the price:");
				double price = new Scanner(System.in).nextDouble();
				System.out.println("Enetr the Ram size:");
				int ram = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer:");
				String manufacturer = new Scanner(System.in).next();
				Mobile m = new Mobile();
				MobileDAO m1 = new MobileDAO();

				m.setId(id);
				m.setName(name);
				m.setBrand(brand);
				m.setColor(color);
				m.setPrice(price);
				m.setRam(ram);
				m.setManufacturer(manufacturer);
				String res1 = m1.mobileInsert(m);
				System.out.println(res1);
				break;
			case 2:
				System.out.println("Enetr the id");
				int id1 = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Name of the mobile");
				String name1 = new Scanner(System.in).next();
				System.out.println("Enetr the brand of the mobile");
				String brand1 = new Scanner(System.in).next();
				System.out.println("Enetr the color:");
				String color1 = new Scanner(System.in).next();
				System.out.println("Enetr the price:");
				double price1 = new Scanner(System.in).nextDouble();
				System.out.println("Enetr the Ram size:");
				int ram1 = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer:");
				String manufacturer1 = new Scanner(System.in).next();
				MobileDAO m3 = new MobileDAO();
				Mobile m2 = new Mobile();
				m2.setId(id1);
				m2.setName(name1);
				m2.setBrand(brand1);
				m2.setColor(color1);
				m2.setPrice(price1);
				m2.setRam(ram1);
				m2.setManufacturer(manufacturer1);
				String res2 = m3.updatePerson(m2);
				System.out.println(res2);
				break;

			case 3:
				System.out.println("Enetr the id");
				int id2 = new Scanner(System.in).nextInt();
				MobileDAO m4 = new MobileDAO();
				Mobile mobile = m4.getMobile(id2);
				System.out.println(mobile.getId());
				System.out.println(mobile.getName());
				System.out.println(mobile.getBrand());
				System.out.println(mobile.getColor());
				System.out.println(mobile.getPrice());
				System.out.println(mobile.getRam());
				System.out.println(mobile.getManufacturer());
				break;
			case 4:
				res = false;
			}
		}

	}

}
