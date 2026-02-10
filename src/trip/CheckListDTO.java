package trip;

public class CheckListDTO {
	private String itemName;
	private boolean isChecked;
	
	public CheckListDTO() {
		// TODO Auto-generated constructor stub
	}

	public CheckListDTO(String itemName, boolean isChecked) {
		super();
		this.itemName = itemName;
		this.isChecked = isChecked;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
}
