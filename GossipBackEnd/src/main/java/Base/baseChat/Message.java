package Base.baseChat;

import org.springframework.data.annotation.Id;

public class Message {
    
	@Id
	private String id;
	private String from;
	private String to;
	private String text;
	private String date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", from=" + from + ", to=" + to + ", text=" + text + ", date=" + date + "]";
	}
	
	
}
		
