package trip;

import java.sql.Date;
import java.sql.Time;

public class ScheduleDTO {
	private String place;
	private String departure;
	private String location;
	private Date visitDate;
	private Time time;
	
	public ScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleDTO(String place, String departure, String location, Date visitDate, Time time) {
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
