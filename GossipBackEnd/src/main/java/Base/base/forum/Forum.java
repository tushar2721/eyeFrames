package Base.base.forum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="forums")
public class Forum {
	
	@Id
	private String id;
	private String ftittle,fdesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFtittle() {
		return ftittle;
	}
	public void setFtittle(String ftittle) {
		this.ftittle = ftittle;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	
}
