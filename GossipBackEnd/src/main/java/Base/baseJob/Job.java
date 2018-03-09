package Base.baseJob;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="jobs")
public class Job {
	
	@Id
	private String id;
	private String jtittle,jdesc,salary,comment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJtittle() {
		return jtittle;
	}
	public void setJtittle(String jtittle) {
		this.jtittle = jtittle;
	}
	public String getJdesc() {
		return jdesc;
	}
	public void setJdesc(String jdesc) {
		this.jdesc = jdesc;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
    
			
}