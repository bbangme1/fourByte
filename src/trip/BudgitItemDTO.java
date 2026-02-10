package trip;

public class BudgitItemDTO {
	private String itemName;
	private int price;
	
	public BudgitItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public BudgitItemDTO(String itemName, int price) {
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