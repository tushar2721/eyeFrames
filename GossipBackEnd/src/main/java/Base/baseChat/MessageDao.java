package Base.baseChat;

import java.util.List;

public interface MessageDao{
	
	public void create (Message message);
	public List<Message> showAll();
	
}