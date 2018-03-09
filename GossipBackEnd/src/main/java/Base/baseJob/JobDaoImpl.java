package Base.baseJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository("JobDao")
@Qualifier("JobDao")
public class JobDaoImpl implements JobDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
	final String COLLECTION = "jobs";
		
	public void create(Job job) {
		if(job !=null)
    	{
       this.mongoTemplate.insert(job,COLLECTION);
		
	}
	}
	@Override
	public List<Job> jshowAll() {
		return (List <Job>) mongoTemplate.findAll(Job.class);
		
	}

	@Override
	public Job find(Job job) {
		Query query = new Query(Criteria.where("_id").is(job.getId()));
		return mongoTemplate.findOne(query,Job.class,COLLECTION);
	}

	@Override
	public void update(Job job) {
		mongoTemplate.save(job);
		
	}

	@Override
	public void delete(Job job) {
		Query query = new Query(Criteria.where("_id").is(job.getId()));
		mongoTemplate.remove(query,COLLECTION);
		
	}	
	
	}
	
	

