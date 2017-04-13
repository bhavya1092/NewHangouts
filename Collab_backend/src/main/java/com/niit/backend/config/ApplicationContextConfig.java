package com.niit.backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.backend.dao.BlogDAO;
import com.niit.backend.dao.BlogDAOImpl;
import com.niit.backend.dao.ChatDAO;
import com.niit.backend.dao.ChatDAOImpl;
import com.niit.backend.dao.EventDAO;
import com.niit.backend.dao.EventDAOImpl;
import com.niit.backend.dao.ForumDAO;
import com.niit.backend.dao.ForumDAOImpl;
import com.niit.backend.dao.JobDAO;
import com.niit.backend.dao.JobDAOImpl;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.dao.UserDAOImpl;
import com.niit.backend.model.Blog;
import com.niit.backend.model.Chat;
import com.niit.backend.model.Event;
import com.niit.backend.model.Forum;
import com.niit.backend.model.Job;
import com.niit.backend.model.UserDetails;

	@Configuration
	@ComponentScan("com")
	@EnableTransactionManagement
	public class ApplicationContextConfig 
	
	{

		@Bean(name = "dataSource")
		public DataSource getOracleDataSource() 
		
		
		{
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            dataSource.setUsername("Bhavyadb");
			dataSource.setPassword("Bhavya92");
			System.out.println("Data Source");
			return dataSource;
		}
		
		
		   private Properties getHibernateProperties() 
		
		{

			Properties connectionProperties = new Properties();
            connectionProperties.setProperty("hibernate.show_sql", "true");
			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			connectionProperties.setProperty("hibernate.format_sql", "true");
			connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
			// dataSource.setConnectionProperties(connectionProperties);
			System.out.println("Hibernate");
			return connectionProperties;
			
		}
		   
		   
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)
		
		{

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource); 
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(UserDetails.class);
			sessionBuilder.addAnnotatedClass(Blog.class);
			sessionBuilder.addAnnotatedClass(Forum.class);
			sessionBuilder.addAnnotatedClass(Event.class);
			sessionBuilder.addAnnotatedClass(Chat.class);
			sessionBuilder.addAnnotatedClass(Job.class);
		
			
			System.out.println("Session Factory");
			return sessionBuilder.buildSessionFactory();
		}
		
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory); 
			System.out.println("Transaction");
			return transactionManager;
			
		}
		
		
		@Autowired
		@Bean(name = "userdetails")
		public UserDetails getUser() 
		
		{
			return new UserDetails();
		}

		@Autowired
		@Bean(name = "userDAO")
		public UserDAO getUserDAO(SessionFactory sessionFactory) 
		
		{
			return new UserDAOImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name = "blog")
		public Blog getBlog() 
		
		{
			return new Blog();
		}

		@Autowired
		@Bean(name = "blogDAO")
		public BlogDAO getBlogDAO(SessionFactory sessionFactory) 
		
		{
			return new BlogDAOImpl(sessionFactory);
		}
		
	
	   @Autowired
	   @Bean(name ="forum")
	   public Forum getForum()
	   
	   {
		   return new Forum();
	   }
	   
	
	
	   @Autowired
	   @Bean(name = "forumDAO")
	   public ForumDAO getForumDAO(SessionFactory sessionFactory) 
	   
	   {
		   
		   return new ForumDAOImpl(sessionFactory);
		   
	   }
	   
	
	    @Autowired
	    @Bean(name = "event")
	    public Event getEvent()
	    
	    {
	    	return new Event();
	    }
	    
	    
	    @Autowired
	    @Bean(name ="eventDAO")
	    public EventDAO getEventDAO(SessionFactory sessionFactory)
	    
	    {
	    	
	    
	    	return new EventDAOImpl(sessionFactory);
	    			
	    }
	   
	
       @Autowired
	   @Bean(name ="job")
	   public Job getJob()
	   
	   {
		   return new Job();
		   
	   }
	   
	
       @Autowired
	   @Bean(name = "jobDAO")
	   public JobDAO getJobDAO(SessionFactory sessionFactory) 
	   
	   {
		   
		   return new JobDAOImpl(sessionFactory);
		   
	   }
	   
	   @Autowired
	   @Bean(name ="chat")
	   public Chat getChat()
	   
	   {
		   return new Chat();
		   
	   }
	   
	
       @Autowired
	   @Bean(name = "chatDAO")
	   public ChatDAO getChatDAO(SessionFactory sessionFactory) 
	   
	   {
		   
		   return new ChatDAOImpl(sessionFactory);
		   
	   }
       
	}  
	
	
	    
	
	   
	   



