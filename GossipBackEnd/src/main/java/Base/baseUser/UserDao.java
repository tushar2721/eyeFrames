package Base.baseUser;

import java.util.List;

public interface UserDao{
	
	public void create (User user);
	public User findUserByEmail(String email);
	public void update(User user);
	public List<User> ushowAll();
	public User ufind(User user);
	
}