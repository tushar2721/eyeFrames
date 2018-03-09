package Base.baseBlog;

import java.util.List;

public interface BlogDao{
	
	public void create (Blog blog);
	public List<Blog> showAll();
	
	public Blog find(Blog blog);
	public void update (Blog blog);
	
	public void delete (Blog blog);
	/*public void deleteAll();*/
}