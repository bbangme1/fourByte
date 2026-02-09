package trip;

import java.sql.Date;

public class TripDTO {
	private String name;
	private String phone;
	private Date startDate;
	private Date endDate;
	private int count;
	
	public TripDTO() {
	}

	public TripDTO(String name, String phone, Date startDate, Date endDate, int count) {
		super();
		this.name = name;
		this.phone = phone;
		this.startDate = startDate;
		this.endDate = endDate;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
