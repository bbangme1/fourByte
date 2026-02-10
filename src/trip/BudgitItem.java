package trip;

public class BudgitItem {
	private String itemName;
	private int price;
	
	public BudgitItem() {
		// TODO Auto-generated constructor stub
	}

	public BudgitItem(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
