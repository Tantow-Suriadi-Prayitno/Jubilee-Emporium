package pages;

public class Charm {
	 private String name;
	    private String imagePath;
	    private int quantity;

	    public Charm(String name, String imagePath, int quantity) {
	        this.name = name;
	        this.imagePath = imagePath;
	        this.quantity = quantity;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getImagePath() {
	        return imagePath;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
}
