package com.perscholas.javaserver;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class JavaServerListener
 *
 */

@WebListener
public class JavaServerListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public JavaServerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Request attribute removed at: " + LocalDateTime.now());
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Request attribute added at: " + LocalDateTime.now());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Attribute replaced at: " + LocalDateTime.now());
    }
	
}
