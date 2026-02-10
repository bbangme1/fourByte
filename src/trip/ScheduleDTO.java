package trip;

import java.sql.Date;

public class ScheduleDTO {
	private String place;
	private String departure;
	private String location;
	private Date visitDate;
	private Date time;
	
	public ScheduleDTO() {} // 생성자 메서드
	public ScheduleDTO(String place, String departure, String location, Date visitDate, Date time) {
		this.place = place;
		this.departure = departure;
		this.location = location;
		this.visitDate = visitDate;
		this.time = time;
	}

	public ScheduleDTO(String place, String departure, String location, Date visitDate, Date time) {
		super();
		this.place = place;
		this.departure = departure;
		this.location = location;
		this.visitDate = visitDate;
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}