package Base.base.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository("ForumDao")
@Qualifier("ForumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
	final String COLLECTION = "forums";
	
	public void fcreate(Forum forum) {
		if(forum !=null)
    	{
       this.mongoTemplate.insert(forum,COLLECTION);	
	}
	}
	
	public void fupdate(Forum forum) {
			mongoTemplate.save(forum);
			
		}

	public List<Forum> fshowAll() {
		return (List <Forum>) mongoTemplate.findAll(Forum.class); 
		
	}

	@Override
	public Forum ffind(Forum forum) {
		Query query = new Query(Criteria.where("_id").is(forum.getId()));
		return mongoTemplate.findOne(query,Forum.class,COLLECTION);
	}

	@Override
	public void fdelete(Forum forum) {
		Query query = new Query(Criteria.where("_id").is(forum.getId()));
		mongoTemplate.remove(query,COLLECTION);
		
	}	
	
	}
	
	

