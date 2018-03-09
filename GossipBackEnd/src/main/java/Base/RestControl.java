package Base;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import Base.baseUser.UserDao;
import Base.base.forum.Forum;
import Base.base.forum.ForumDao;
import Base.baseBlog.Blog;
import Base.baseBlog.BlogDao;
import Base.baseChat.Message;
import Base.baseChat.MessageDao;
import Base.baseJob.Job;
import Base.baseJob.JobDao;
import Base.baseUser.User;

@RestController
public class RestControl {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody String body)
	{ 
		System.out.println(body);
	 try {
		JSONParser j=new JSONParser();
		JSONObject obj=(JSONObject) j.parse(body);
		User ob=new User();
		
		
		
		ob.setAddress(obj.get("address").toString());
		ob.setMobile(obj.get("mobile").toString());
		ob.setEmail(obj.get("email").toString());
		ob.setGender(obj.get("gender").toString());
		ob.setProfilePicUrl(ob.getGender().equals("Male") ? "images/blank.jpg" : "images/blank1.png");
		ob.setName(obj.get("name").toString());
		ob.setPassword(obj.get("password").toString());
		ob.setPincode(obj.get("pincode").toString());
		System.out.println("Data here");
		userDao.create(ob);
		System.out.println("Data saved....");
		 
		 
		 
	} 
	 catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
	 }
	 return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
	}
	
	//Blog Creation
	@Autowired
	BlogDao blogDao;
	
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<String> addBlog(@RequestBody String body)
	{ 
		System.out.println(body);
	 try {
		JSONParser j1=new JSONParser();
		JSONObject obj1=(JSONObject) j1.parse(body);
		Blog ob1=new Blog();
		
		
		
		ob1.setTittle(obj1.get("Tittle").toString());
		ob1.setDesc(obj1.get("Description").toString());
		System.out.println("Data here");
		blogDao.create(ob1);
		System.out.println("Data saved....");
		 
		 
		 
	} 
	 catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
	 }
	 return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
	}
	
	//Blog ShowAll
	@RequestMapping(value="/fetchAllBlogs",method=RequestMethod.GET)
    public ResponseEntity<String> fetchAllBlogs()
    {
        System.out.println("fetchAllBlogs");
        
        ObjectMapper mapper = new ObjectMapper();
        
        try
        {
            System.out.println( mapper.writeValueAsString(blogDao.showAll()) );    
        
            return new ResponseEntity<String>(mapper.writeValueAsString(blogDao.showAll()), HttpStatus.OK);
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
            
        }
                
    }
	
	//Edit Blog
	@RequestMapping(value="/EditSaveBlog",method=RequestMethod.POST)
    public ResponseEntity<String> editBlog( @RequestBody String body  )
    {
        System.out.println("edit blog n rest");
        
        try
        {
            JSONParser j2 = new JSONParser();
            
            JSONObject obj2 = (JSONObject)j2.parse(body);
        
            System.out.println(obj2);
        
            Blog ob2 = new Blog();
            
            ob2.setId(obj2.get("id").toString());
            
            System.out.println(obj2.get("id").toString() );
            
            ob2= blogDao.find(ob2);
                       
            
            ob2.setTittle(obj2.get("tittle").toString());
            ob2.setDesc(obj2.get("desc").toString());
            
            
            blogDao.update(ob2);
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
        }
        
        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
    }
	
	//Delete Blog
	@RequestMapping(value="/deleteBlog",method=RequestMethod.POST)
    public ResponseEntity<String> deleteBlog( @RequestBody String body  )
    {
        System.out.println("Hi");
        
        try
        {
            JSONParser j3 = new JSONParser();
            
            JSONObject obj3 = (JSONObject)j3.parse(body);
        
            System.out.println(obj3);
        
            Blog ob3 = new Blog();
            
            ob3.setId(obj3.get("id").toString());
            
            blogDao.delete(ob3);
            
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
        }
        
        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
    }
	
	//Forum Creation
		@Autowired
		ForumDao forumDao;
		
		@RequestMapping(value="/addForum",method=RequestMethod.POST)
		public ResponseEntity<String> addForum(@RequestBody String body)
		{ 
			System.out.println(body);
		 try {
			JSONParser j2=new JSONParser();
			JSONObject obj2=(JSONObject) j2.parse(body);
			Forum ob2=new Forum();
			
			
			
			ob2.setFtittle(obj2.get("Ftittle").toString());
			ob2.setFdesc(obj2.get("Fdescription").toString());
			System.out.println("Data here");
			forumDao.fcreate(ob2);
			System.out.println("Data saved....");
			 
			 
			 
		} 
		 catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
		}
		
		//Forum ShowAll
		@RequestMapping(value="/fetchAllForums",method=RequestMethod.GET)
	    public ResponseEntity<String> fetchAllForums()
	    {
	        System.out.println("fetchAllForums");
	        
	        ObjectMapper mapper = new ObjectMapper();
	        
	        try
	        {
	            System.out.println( mapper.writeValueAsString(forumDao.fshowAll()) );    
	        
	            return new ResponseEntity<String>(mapper.writeValueAsString(forumDao.fshowAll()), HttpStatus.OK);
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace();
	            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
	            
	        }
	                
	    }
		
		//Edit Forum
		@RequestMapping(value="/EditSaveForum",method=RequestMethod.POST)
	    public ResponseEntity<String> editForum( @RequestBody String body  )
	    {
	        System.out.println("edit Forum n rest");
	        
	        try
	        {
	            JSONParser j2 = new JSONParser();
	            
	            JSONObject obj2 = (JSONObject)j2.parse(body);
	        
	            System.out.println(obj2);
	        
	            Forum ob2 = new Forum();
	            
	            ob2.setId(obj2.get("id").toString());
	            
	            System.out.println(obj2.get("id").toString() );
	            
	            ob2= forumDao.ffind(ob2);
	                       
	            
	            ob2.setFtittle(obj2.get("ftittle").toString());
	            ob2.setFdesc(obj2.get("fdesc").toString());
	            
	            
	            forumDao.fupdate(ob2);
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace();
	            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
	    }
		
		//Delete Forum
		@RequestMapping(value="/deleteForum",method=RequestMethod.POST)
	    public ResponseEntity<String> deleteForum( @RequestBody String body  )
	    {
	        System.out.println("Hi");
	        
	        try
	        {
	            JSONParser j3 = new JSONParser();
	            
	            JSONObject obj3 = (JSONObject)j3.parse(body);
	        
	            System.out.println(obj3);
	        
	            Forum ob3 = new Forum();
	            
	            ob3.setId(obj3.get("id").toString());
	            
	            forumDao.fdelete(ob3);
	            
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace();
	            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
	    }
		
		//Jobs Creation
				@Autowired
				JobDao jobDao;
				
				@RequestMapping(value="/addJob",method=RequestMethod.POST)
				public ResponseEntity<String> addJob(@RequestBody String body)
				{ 
					System.out.println(body);
				 try {
					JSONParser j5=new JSONParser();
					JSONObject obj5=(JSONObject) j5.parse(body);
					Job ob5=new Job();
					
					
					
					ob5.setJtittle(obj5.get("Jtittle").toString());
					ob5.setJdesc(obj5.get("Jdescription").toString());
					ob5.setSalary(obj5.get("Salary").toString());
					System.out.println("Data here");
					jobDao.create(ob5);
					System.out.println("Data saved....");
					 
					 
					 
				} 
				 catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
				 }
				 return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
				}
				
				//Jobs ShowAll
				@RequestMapping(value="/fetchAllJobs",method=RequestMethod.GET)
			    public ResponseEntity<String> fetchAllJobs()
			    {
			        System.out.println("fetchAllJobs");
			        
			        ObjectMapper mapper = new ObjectMapper();
			        
			        try
			        {
			            System.out.println( mapper.writeValueAsString(jobDao.jshowAll()) );    
			        
			            return new ResponseEntity<String>(mapper.writeValueAsString(jobDao.jshowAll()), HttpStatus.OK);
			        }
			        catch( Exception e )
			        {
			            e.printStackTrace();
			            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
			            
			        }
			                
			    }
				
				//Edit Jobs
				@RequestMapping(value="/EditSaveJob",method=RequestMethod.POST)
			    public ResponseEntity<String> editJob( @RequestBody String body  )
			    {
			        System.out.println("edit Job n rest");
			        
			        try
			        {
			            JSONParser j5 = new JSONParser();
			            
			            JSONObject obj5 = (JSONObject)j5.parse(body);
			        
			            System.out.println(obj5);
			        
			            Job ob5 = new Job();
			            
			            ob5.setId(obj5.get("id").toString());
			            
			            System.out.println(obj5.get("id").toString() );
			            
			            ob5= jobDao.find(ob5);
			                       
			            
			            ob5.setJtittle(obj5.get("jtittle").toString());
			            ob5.setJdesc(obj5.get("jdesc").toString());
			            ob5.setSalary(obj5.get("salary").toString());
			            ob5.setComment(obj5.get("comment").toString());
			            
			            jobDao.update(ob5);
			        }
			        catch( Exception e )
			        {
			            e.printStackTrace();
			            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
			        }
			        
			        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
			    }
				
				//Delete Jobs
				@RequestMapping(value="/deleteJob",method=RequestMethod.POST)
			    public ResponseEntity<String> deleteJob( @RequestBody String body  )
			    {
			        System.out.println("Hi");
			        
			        try
			        {
			            JSONParser j5 = new JSONParser();
			            
			            JSONObject obj5 = (JSONObject)j5.parse(body);
			        
			            System.out.println(obj5);
			        
			            Job ob5 = new Job();
			            
			            ob5.setId(obj5.get("id").toString());
			            
			            jobDao.delete(ob5);
			            
			        }
			        catch( Exception e )
			        {
			            e.printStackTrace();
			            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
			        }
			        
			        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
			    }	
		
	//Friends Showall
		@RequestMapping(value="/fetchAllFriends",method=RequestMethod.GET)
	    public ResponseEntity<String> fetchAllFriends()
	    {
	        System.out.println("fetchAllFriends");
	        
	        ObjectMapper mapper = new ObjectMapper();
	        
	        try
	        {
	            System.out.println( mapper.writeValueAsString(userDao.ushowAll()) );    
	        
	            return new ResponseEntity<String>(mapper.writeValueAsString(userDao.ushowAll()), HttpStatus.OK);
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace();
	            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
	            
	        }
	                
	    }		
		
	//Profile pic update
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/updateProfilePicture" , method = RequestMethod.POST)
	public ResponseEntity<String> updateProfilePicture(MultipartHttpServletRequest request,
			HttpServletResponse response, UriComponentsBuilder ucBuilder) {

		System.out.println(request.getHeader("User"));

		String email = request.getParameter("email");
		
		System.out.println("email:" + email);
		
		System.out.println(request.getFile("file").getName());
		System.out.println(request.getFile("file").getSize());
		System.out.println(request.getFile("file").getContentType());
		System.out.println(request.getFile("file").getOriginalFilename());

		JSONObject json = new JSONObject();

		BufferedOutputStream stream = null;

		try {
			
			String path = context.getRealPath("/");
			
			System.out.println(path);

			File directory = null;

			System.out.println(request.getFile("file"));

			if (request.getFile("file").getContentType().contains("image")) {
				directory = new File(path);

				System.out.println(directory);

				byte[] bytes = null;
				File file = null;
				bytes = request.getFile("file").getBytes();

				if (!directory.exists())
					directory.mkdirs();

				file = new File(directory.getAbsolutePath() + System.getProperty("file.separator")
						+ "temp.jpg");

				System.out.println(file.getAbsolutePath());

				stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(bytes);
				
				stream.close();
				
				Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
						  "cloud_name", "darling",
	    		          "api_key", "549371822323932",
	    		          "api_secret", "id0F0GCLZuT2oCZcGzX0rarTWL4"));
				
				File toUpload = new File(directory.getAbsolutePath() + System.getProperty("file.separator")
				+ "temp.jpg");
				Map uploadResult = cloudinary.uploader().upload(toUpload, ObjectUtils.emptyMap());
				
				System.out.println( uploadResult );
				System.out.println("heree...........");
				
				System.out.println( uploadResult.get("secure_url").toString() );
				
				User u = userDao.findUserByEmail(email);
				
				System.out.println(u);
				
				String imageRef = uploadResult.get("secure_url").toString();
				
			//	 u.setEmail(request.getHeader("user"));
				
			//	u = userDao.findUserByEmail(email);
				
				
				u.setProfilePicUrl(imageRef);
				
				userDao.update(u);
				
				
				return new ResponseEntity<String>("{\"msg\": \"Success\",\"imageUrl\": \""+imageRef+"\"}", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		}

		return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
	}
	
	@RequestMapping(value="/showProfileData",method=RequestMethod.POST)
    public ResponseEntity<String> showProfileData(@RequestBody String body)
    { 
        System.out.println(body);
        ObjectMapper mapper = new ObjectMapper();
     try {
        JSONParser j=new JSONParser();
        JSONObject obj=(JSONObject) j.parse(body);
        User ob=new User();
        System.out.println("hello");
        ob.setEmail(obj.get("email").toString());
        ob=userDao.findUserByEmail(obj.get("email").toString());
        
        System.out.println( mapper.writeValueAsString(userDao.findUserByEmail(obj.get("email").toString())) );
        
        return new ResponseEntity<String>(mapper.writeValueAsString(userDao.findUserByEmail(obj.get("email").toString())), HttpStatus.OK);
    } 
     catch (Exception e) {
    e.printStackTrace();
    return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
     }
     //return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
    }
	
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)
    public ResponseEntity<String> UpdatePassword(@RequestBody String body)
    { 
        System.out.println(body);
     try {
        JSONParser j=new JSONParser();
        JSONObject obj=(JSONObject) j.parse(body);
        User ob=userDao.findUserByEmail(obj.get("email").toString());
        
        
        ob.setPassword(obj.get("password").toString());
        
        userDao.update(ob);
        System.out.println("Data saved....");
     }
     catch (Exception e) {
    	    e.printStackTrace();
    	    return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
    	     }
    	    return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
    	    }

       //Profile data update
	@RequestMapping(value="/UpdateUser",method=RequestMethod.POST)
    public ResponseEntity<String> UpdateUser(@RequestBody String body)
    { 
        System.out.println(body);
     try {
        JSONParser j4=new JSONParser();
        JSONObject obj4=(JSONObject) j4.parse(body);
        User ob4=userDao.findUserByEmail(obj4.get("email").toString());        
        
        ob4.setName(obj4.get("name").toString());
        ob4.setAddress(obj4.get("address").toString());
        ob4.setMobile(obj4.get("mobile").toString());
        ob4.setPincode(obj4.get("pincode").toString());
        ob4.setGender(obj4.get("gender").toString());
        
        userDao.update(ob4);
        System.out.println("Data saved....");
     }
     catch (Exception e) {
    	    e.printStackTrace();
    	    return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
    	     }
    	    return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
    	    }

	
	//Add Friend/Request Send
			@RequestMapping(value="/addFriend",method=RequestMethod.POST)
		    public ResponseEntity<String> addFriend( @RequestBody String body  )
		    {
		        
		        System.out.println("Sent");
		        try
		        {
		            JSONParser j = new JSONParser();
		            
		            JSONObject obj = (JSONObject)j.parse(body);
		        
		            
		            User source=userDao.findUserByEmail(obj.get("SourceEmail").toString());
		            
		            User target=userDao.findUserByEmail(obj.get("TargetEmail").toString());
		            
		            boolean found = false;
		            
		            for( String s : source.getReqsend() ){
		                if( s.equals(target.getEmail()) ){
		                    found = true;
		                    break;
		                }    
		            }
		            
		            if( !found ){
		                List<String> reqout = source.getReqsend();
		                
		                reqout.add(target.getEmail());
		            
		                source.setReqsend(reqout);
		                
		                userDao.update( source );
		            }
		            
		            found = false;
		            
		            for( String s : target.getReqreceived() ){
		                if( s.equals(source.getEmail()) ){
		                    found = true;
		                    break;
		                    
		                
		                }    
		            }
		            
		            if( !found ){
		                List<String> reqin = target.getReqreceived();
		                
		                reqin.add(source.getEmail());
		            
		                target.setReqreceived(reqin);
		                
		                userDao.update( target );
		            }
		        
		            
		        }
		        catch( Exception e )
		        {
		            e.printStackTrace();
		            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		        }
		        
		        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
		    }

			
	//Undo Friend Request
			@RequestMapping(value="/undoFriend",method=RequestMethod.POST)
		    public ResponseEntity<String> undoFriend( @RequestBody String body  )
		    {
		        
		        System.out.println("undo");
		        try
		        {
		            JSONParser j = new JSONParser();
		            
		            JSONObject obj = (JSONObject)j.parse(body);
		        
		            
		            User source=userDao.findUserByEmail(obj.get("SourceEmail").toString());
		            
		            User target=userDao.findUserByEmail(obj.get("TargetEmail").toString());
		            
		            boolean found = true;
		            
		            for( String s : source.getReqsend() ){
		                if( !s.equals(target.getEmail()) ){
		                    found = false;
		                    break;
		                }    
		                System.out.println("aaya yaha control 1");
		            }
		            
		            if( found ){
		                List<String> requndo = source.getReqsend();
		                
		                requndo.remove(target.getEmail());
		                System.out.println("aaya yaha control 2");
		                source.setReqsend(requndo);
		                
		                userDao.update( source );
		                
		            }
		            
		            found = true;
		            
		            for( String s : target.getReqreceived() ){
		                if( !s.equals(source.getEmail()) ){
		                    found = false;
		                    break;
		                
		                }    
		            }
		            
		            if( found ){
		                List<String> requndoo = target.getReqreceived();
		                
		                requndoo.remove(source.getEmail());
		            
		                target.setReqreceived(requndoo);
		                System.out.println("aaya yaha control 3");
		                userDao.update( target );
		            }
		        
		            
		        }
		        catch( Exception e )
		        {
		            e.printStackTrace();
		            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		        }
		        
		        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
		    }

	//Accept Friend Request
			@RequestMapping(value="/acceptFriend",method=RequestMethod.POST)
		    public ResponseEntity<String> acceptFriend( @RequestBody String body  )
		    {
		        
		        System.out.println("accept");
		        try
		        {
		            JSONParser j = new JSONParser();
		            
		            JSONObject obj = (JSONObject)j.parse(body);
		        
		            
		            User source=userDao.findUserByEmail(obj.get("SourceEmail").toString());
		            
		            User target=userDao.findUserByEmail(obj.get("TargetEmail").toString());
		            
		            
		        	List<String> ro = source.getReqsend();
		        	ro.remove(obj.get("TargetEmail").toString());
		        	List<String> f = source.getFrnds();
		        	f.add( obj.get("TargetEmail").toString() );
		        	userDao.update(source);
		        	
		        	
		        	List<String> req = target.getReqreceived();
		        	req.remove(obj.get("SourceEmail").toString());
		        	List<String> frnd = target.getFrnds();
		        	frnd.add( obj.get("SourceEmail").toString() );
		        	userDao.update(target);
		            		            
		        }
		        catch( Exception e )
		        {
		            e.printStackTrace();
		            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		        }
		        
		        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
		    }

			//Unfriend Friend Request
			@RequestMapping(value="/unfriendFriend",method=RequestMethod.POST)
		    public ResponseEntity<String> unfriendFriend( @RequestBody String body  )
		    {
		        
		        System.out.println("unfriend");
		        try
		        {
		            JSONParser j = new JSONParser();
		            
		            JSONObject obj = (JSONObject)j.parse(body);
		        
		            
		            User source=userDao.findUserByEmail(obj.get("SourceEmail").toString());
		            
		            User target=userDao.findUserByEmail(obj.get("TargetEmail").toString());
		            
		            
		        	List<String> ro = source.getFrnds();
		        	ro.remove(obj.get("TargetEmail").toString());
		        	userDao.update(source);
		        	
		        	
		        	List<String> req = target.getFrnds();
		        	req.remove(obj.get("SourceEmail").toString());
		        	userDao.update(target);
		            		            
		        }
		        catch( Exception e )
		        {
		            e.printStackTrace();
		            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		        }
		        
		        return new ResponseEntity<String>("{\"msg\": \"Success\"}", HttpStatus.OK);
		    }
			
			
	//Chat Creation
			@Autowired
			MessageDao messageDao;
			
			@RequestMapping(value="/addMessage",method=RequestMethod.POST)
			public ResponseEntity<String> Message(@RequestBody String body)
			{ 
				System.out.println(body);
			 try {
				JSONParser j=new JSONParser();
				JSONObject obj=(JSONObject) j.parse(body);
				Message ob=new Message();
				
				
				
				ob.setFrom(obj.get("From").toString());
				ob.setTo(obj.get("To").toString());
				ob.setText(obj.get("Text").toString());
				ob.setDate(obj.get("Date").toString());
				System.out.println("Data here");
				messageDao.create(ob);
				System.out.println("Data saved....");
				 
				 
				 
			} 
			 catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"msg\" : \"Failure\"}", HttpStatus.OK);
			 }
			 return new ResponseEntity<String>("{\"msg\" : \"Success\"}", HttpStatus.OK);
			}
			
			
			//Chat ShowAll
			@RequestMapping(value="/fetchAllMessages",method=RequestMethod.GET)
		    public ResponseEntity<String> fetchAllMessages()
		    {
		        System.out.println("fetchAllMessages");
		        
		        ObjectMapper mapper = new ObjectMapper();
		        
		        try
		        {
		            System.out.println( mapper.writeValueAsString(messageDao.showAll()) );    
		        
		            return new ResponseEntity<String>(mapper.writeValueAsString(messageDao.showAll()), HttpStatus.OK);
		        }
		        catch( Exception e )
		        {
		            e.printStackTrace();
		            return new ResponseEntity<String>("{\"msg\": \"Failure\"}", HttpStatus.OK);
		            
		        }
		                
		    }		
}


	
	