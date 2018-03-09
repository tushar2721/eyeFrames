package Base.baseJob;

import java.util.List;

public interface JobDao{
	
	public void create (Job job);
	public List<Job> jshowAll();
	
	public Job find(Job job);
	public void update (Job job);
	
	public void delete (Job job);
	/*public void deleteAll();*/
}