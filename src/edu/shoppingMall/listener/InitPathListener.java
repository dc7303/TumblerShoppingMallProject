package edu.shoppingMall.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InitPathListener
 *
 */
@WebListener
public class InitPathListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         String contextPath = application.getContextPath();
         application.setAttribute("contextPath", contextPath);
         application.setAttribute("packegePath", "edu.shoppingMall");
    }
	
}
