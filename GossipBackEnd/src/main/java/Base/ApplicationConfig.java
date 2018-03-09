package Base;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"Base"})
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	

	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	
	public @Bean MongoClient mongoClient() throws Exception{
        return new MongoClient(new ServerAddress("ds229295.mlab.com", 29295), new ArrayList<MongoCredential>() {

            {
                add(MongoCredential.createCredential("tushar2721", "wwe", "thakre2721".toCharArray()));
            }
            
        });
      
    }
	
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        System.out.println("Done 1");
        
        return new SimpleMongoDbFactory(mongoClient(), "wwe");
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        
        System.out.println("Done 2");
        
        return mongoTemplate;
    }
	
    //Profile pic multipart
    @Bean(name = "multipartResolver")
   	public CommonsMultipartResolver createMultipartResolver() {
   		
   		System.out.println("Multipart Resolver");
   		
   	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
   	    resolver.setDefaultEncoding("utf-8");
   	    return resolver;
   	}
}

