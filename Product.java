package jdbc.maven;

public class Product {
	private int id;
	private String productname;
	private double price;
	private String manufacturer;
	private double discount;
	private int warranty;
	private String date;
	private double gst;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWaranty() {
		return warranty;
	}
	public void setWaranty(int waranty) {
		this.warranty = waranty;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		
		return "Product [id=" + id +"\n"+ " productname=" + productname + "\n"+", price=" + price + "\n"+ "manufacturer="
				+ manufacturer + "\n"+" discount=" + discount +"\n"+ " warranty=" + warranty + "\n"+" date=" + date +"\n"+ "gst=" + gst
				+ "\n"+"All details saved sucessfully]";
	}
	

}
