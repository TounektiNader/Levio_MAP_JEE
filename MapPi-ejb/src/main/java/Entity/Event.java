package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
@Table(name="Events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EventId")
	private int eventId;

	@Column(name="Description")
	private String description;

	@Column(name="End")
	private String end;

	@Column(name="IsFullDay")
	private short isFullDay;

	@Column(name="Start")
	private String start;

	@Column(name="Subject")
	private String subject;

	@Column(name="Themecolor")
	private String themecolor;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public short getIsFullDay() {
		return this.isFullDay;
	}

	public void setIsFullDay(short isFullDay) {
		this.isFullDay = isFullDay;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getThemecolor() {
		return this.themecolor;
	}

	public void setThemecolor(String themecolor) {
		this.themecolor = themecolor;
	}

}