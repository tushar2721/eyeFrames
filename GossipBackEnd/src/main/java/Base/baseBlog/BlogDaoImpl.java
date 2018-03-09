package Base.baseBlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository("BlogDao")
@Qualifier("BlogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
	final String COLLECTION = "blogs";
	
	public void create(Blog blog) {
		if(blog !=null)
    	{
       this.mongoTemplate.insert(blog,COLLECTION);	
	}
	}
	
	public void update(Blog blog) {
			mongoTemplate.save(blog);
			
		}

	public List<Blog> showAll() {
		return (List <Blog>) mongoTemplate.findAll(Blog.class); 
		
	}

	@Override
	public Blog find(Blog blog) {
		Query query = new Query(Criteria.where("_id").is(blog.getId()));
		return mongoTemplate.findOne(query,Blog.class,COLLECTION);
	}

	@Override
	public void delete(Blog blog) {
		Query query = new Query(Criteria.where("_id").is(blog.getId()));
		mongoTemplate.remove(query,COLLECTION);
		
	}	
	
	}
	
	

