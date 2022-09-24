package jdbc.maven;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean res = true;
		while (res) {

			System.out.println("1.Insert Product Details\n2.Update Productls\n3.Delete Product Details\n4.GetProduct Details\n 5.getproduct all details\n6.exit");
			int choice = new Scanner(System.in).nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enetr the id");
				int id = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Name of the Product");
				String name = new Scanner(System.in).next();
				System.out.println("Enetr the Price of the product");
				double price = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer:");
				String manufacturer = new Scanner(System.in).next();
				System.out.println("Enetr the Discount:");
				double discount = new Scanner(System.in).nextDouble();
				System.out.println("Enetr the Warranty");
				int warranty = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer date:");
				String date = new Scanner(System.in).next();
				System.out.println("Enetr the Gst");
				double gst = new Scanner(System.in).nextDouble();
				Product p=new Product();
				ProductDoa pd = new ProductDoa();

				p.setId(id);
				p.setProductname(name);
				p.setPrice(price);
				p.setManufacturer(manufacturer);
				p.setDiscount(discount);
				p.setWaranty(warranty);
				p.setDate(date);
				p.setGst(gst);
				 pd.saveProduct(p);
				//System.out.println(res1);
				break;
			case 2:
				System.out.println("Enetr the id");
				int id1= new Scanner(System.in).nextInt();
				System.out.println("Enetr the Name of the Product");
				String name1 = new Scanner(System.in).next();
				System.out.println("Enetr the Price of the product");
				double price1 = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer:");
				String manufacturer1 = new Scanner(System.in).next();
				System.out.println("Enetr the Discount:");
				double discount1 = new Scanner(System.in).nextDouble();
				System.out.println("Enetr the Warranty");
				int warranty1 = new Scanner(System.in).nextInt();
				System.out.println("Enetr the Manufacturer date:");
				String date1 = new Scanner(System.in).next();
				System.out.println("Enetr the Gst");
				double gst1 = new Scanner(System.in).nextDouble();
				Product p1=new Product();
				ProductDoa pd1 = new ProductDoa();

				p1.setId(id1);
				p1.setProductname(name1);
				p1.setPrice(price1);
				p1.setManufacturer(manufacturer1);
				p1.setDiscount(discount1);
				p1.setWaranty(warranty1);
				p1.setDate(date1);
				p1.setGst(gst1);
				Product res2 = pd1.updateProduct(p1);
				System.out.println(res2);
				break;
			case 3:System.out.println("Enetr the id");
			int id2=new Scanner(System.in).nextInt();
			ProductDoa pd2 = new ProductDoa();
			String result=pd2.deleteProduct(id2);
			System.out.println(result);
			break;

			case 4:
				System.out.println("Enetr the id");
				int id3 = new Scanner(System.in).nextInt();
				
				ProductDoa pd3 = new ProductDoa();
				Product p3=pd3.getProduct(id3);
				System.out.println(p3.getId());
				System.out.println(p3.getProductname());
				System.out.println(p3.getPrice());
				System.out.println(p3.getManufacturer());
				System.out.println(p3.getDiscount());
				System.out.println(p3.getWaranty());
				System.out.println(p3.getDate());
				System.out.println(p3.getGst());
				
				break;
			case 5:ProductDoa pd4 = new ProductDoa();
			List<jdbc.maven.Product> p4=pd4.getProductAll();
			for(Product p5:p4) {
				System.out.println(p5);
			}
			break;
			case 6:
				res = false;
				break;
			}
		}

	}

	private static List Product() {
		// TODO Auto-generated method stub
		return null;
	}

}
