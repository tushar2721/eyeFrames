package Base;


import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Base.baseChat.Message;
import Base.baseChat.MessageDao;


@Controller
public class SocketController {
	
@Autowired
	
private SimpMessagingTemplate simpMessagingTemplate;
	
	
@MessageMapping("/user/{from}")
	
//@SendTo("/topic/users")
	
public void showUsers(@DestinationVariable String from){
	
System.out.println("Getting " + from);
		
List<Message> users = new ArrayList<Message>();
		
if (from!=null) {
			
Message user = new Message();
			
user.setFrom(from);
			
users.add(user);
		}
		
//return users;
		
simpMessagingTemplate.convertAndSend("/topic/users", users);
	}


}
