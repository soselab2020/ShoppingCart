package ntou.cs.example;

/*
 * Type: Value Object
 */
public class OrderItem {
	private final String name;
	private final int price;
	private final int quantity;

	public OrderItem(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}	

}
