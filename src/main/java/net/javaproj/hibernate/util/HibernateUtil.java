package net.javaproj.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import net.javaproj.hibernate.model.Student;

public class HibernateUtil
{
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		if(sf==null)
		{
			try {
				Configuration config = new Configuration(); 
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sonoDemo?useSSL=false");
				settings.put(Environment.USER, "neha");
				settings.put(Environment.PASS, "neha");
				
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MYSQL5Dialect");
				
				
				settings.put(Environment.SHOW_SQL, "true");
				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(settings);
				
				config.addAnnotatedClass(Student.class);
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties()).build();
				
				
				sf = config.buildSessionFactory(serviceRegistry);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return sf;
	}
	
}