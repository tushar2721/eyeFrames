package Base.base.forum;

import java.util.List;

public interface ForumDao{
	
	    public void fcreate (Forum forum);	
		
		public List<Forum> fshowAll();
		
		public Forum ffind(Forum forum);
		public void fupdate (Forum forum);
		
		public void fdelete (Forum forum);
		/*public void deleteAll();*/
	}
	
	
