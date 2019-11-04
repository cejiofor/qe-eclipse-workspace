package com.perscholas.listeners;

import java.time.LocalDateTime;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AppListeners
 *
 */
@WebListener
public class AppListener implements 
	ServletContextListener, 
	ServletContextAttributeListener, 
	HttpSessionListener, 
	HttpSessionAttributeListener, 
	HttpSessionIdListener, 
	ServletRequestListener, 
	ServletRequestAttributeListener{

	// ServletContextListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/
		ServletContextListener.html */
	@Override
        public void contextInitialized(ServletContextEvent sce)  { 
            System.out.println("Context initialized at: " + LocalDateTime.now());
        }
	
	@Override
        public void contextDestroyed(ServletContextEvent sce)  { 
             System.out.println("Context destroyed at: " + LocalDateTime.now());
        }
	
	// ServletContextAttributeListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/
		ServletContextAttributeListener.html */
	@Override
        public void attributeAdded(ServletContextAttributeEvent scae)  { 
            System.out.println("Servlet Context attribute added at: " + LocalDateTime.now());
        }
	
	@Override
        public void attributeRemoved(ServletContextAttributeEvent scae)  { 
            System.out.println("Context attribute removed at: " + LocalDateTime.now());
        }
	
	@Override
        public void attributeReplaced(ServletContextAttributeEvent scae)  { 
            System.out.println("Context attribute replaced at: " + LocalDateTime.now());
        }
	
	// HttpSessionListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/
		HttpSessionListener.html */
	@Override
        public void sessionCreated(HttpSessionEvent se)  { 
            System.out.println("Session created at: " + LocalDateTime.now());
        }
	
	@Override
        public void sessionDestroyed(HttpSessionEvent se)  { 
            System.out.println("Session destroyed at: " + LocalDateTime.now());
        }
	
	// HttpSessionIdListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/
		HttpSessionIdListener.html */
	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		System.out.println("Session ID changed at: " + LocalDateTime.now());
	}
	
	// HttpSessionAttributeListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/
		HttpSessionAttributeListener.html */
	@Override
        public void attributeAdded(HttpSessionBindingEvent se)  { 
            System.out.println("Session attribute added at: " + LocalDateTime.now());
        }
	
	@Override
        public void attributeRemoved(HttpSessionBindingEvent se)  { 
            System.out.println("Session attribute removed at: " + LocalDateTime.now());
        }
	
	@Override
        public void attributeReplaced(HttpSessionBindingEvent se)  { 
            System.out.println("Request attribute replaced at: " + LocalDateTime.now());
        }
	
	// ServletRequestListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/
		ServletRequestListener.html */
	@Override
        public void requestDestroyed(ServletRequestEvent sre)  { 
            System.out.println("Request destroyed at: " + LocalDateTime.now());
        }
	
	@Override
        public void requestInitialized(ServletRequestEvent sre)  { 
            System.out.println("Request initialized at: " + LocalDateTime.now());
        }
	
	// ServletRequestAttributeListener
	/* https://javaee.github.io/javaee-spec/javadocs/javax/servlet/
		ServletRequestAttributeListener.html */
	@Override
        public void attributeAdded(ServletRequestAttributeEvent srae)  { 
            System.out.println("Request attribute added at: " + LocalDateTime.now());
        }

	@Override
        public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
            System.out.println("Request attribute removed at: " + LocalDateTime.now());
        }

	@Override
        public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
            System.out.println("Attribute replaced at: " + LocalDateTime.now());
        }
	
}