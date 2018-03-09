package Base.baseUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import Base.base.forum.Forum;



@Repository("UserDao")
@Qualifier("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
	final String COLLECTION = "users";
	
	public void create(User user) {
		if(user !=null)
    	{
       this.mongoTemplate.insert(user,COLLECTION);
    }
		
	}
	//Find by email & update
	public User findUserByEmail(String email) {
		Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class, COLLECTION);
		
	}

	public void update(User user) {
		mongoTemplate.save(user);
		
	}
	
	public List<User> ushowAll() {
		return (List <User>) mongoTemplate.findAll(User.class); 
		
	}
	
	public User ufind(User user) {
		Query query = new Query(Criteria.where("email").is(user.getEmail()));
        return mongoTemplate.findOne(query, User.class, COLLECTION);
	}
}

