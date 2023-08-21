package careercamp;

public class Product {
	 private int prodId;
	    private String prodName;
	    private double price;
	    private int quantity;
	    private double discount;

	    public Product(int prodId, String prodName, double price, int quantity, double discount) {
	        this.prodId = prodId;
	        this.prodName = prodName;
	        this.price = price;
	        this.quantity = quantity;
	        this.discount = discount;
	    }

	    // Getters and setters here...

	    @Override
	    public String toString() {
	        return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", quantity=" + quantity
	                + ", discount=" + discount + "]";
	    }

		public int getProdId() {
			// TODO Auto-generated method stub
			return prodId;
		}
		public double getPrice() {
		    return price;
		}
		public double getDiscount() {
		    return discount;
		}
		public String getProdName() {
		    return prodName;
		}

		
		


}
