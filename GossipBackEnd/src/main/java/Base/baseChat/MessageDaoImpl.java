package Base.baseChat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;



@Repository("MessageDao")
@Qualifier("MessageDao")
public class MessageDaoImpl implements MessageDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
	final String COLLECTION = "message";
	
	@Override
	public void create(Message message) {
		if(message !=null)
    	{
       this.mongoTemplate.insert(message,COLLECTION);
		
	}	
	}

	@Override
	public List<Message> showAll() {
		return (List <Message>) mongoTemplate.findAll(Message.class);
	}
}
	

