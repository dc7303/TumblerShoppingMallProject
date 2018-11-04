package edu.shoppingMall.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import edu.shoppingMall.controller.Controller;

/**
 * �� controller�� Map�� ��� application ������ ������� Listener
 * ���� ��Ű�� ���ο� ����Ǿ� �ִ� ActionMapping.properties�� �ҷ��´�.
 * �׷��� ������ Ű������ controller �̸��� properties file���� �����ϵ����մϴ�.
 * @author mark
 *
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }


    public void contextInitialized(ServletContextEvent e)  { 
        //�ʿ��� ��ü�� �̸� �����Ͽ� map�� �ְ� application������ map����
        Map<String, Controller> map = new HashMap<>();
        
        ServletContext application = e.getServletContext();
        String fileName = application.getInitParameter("fileName");     //web.xml�� context-param�� �ԷµǾ�����.
        try {
            ResourceBundle rb = ResourceBundle.getBundle(fileName);
            Iterator<String> it = rb.keySet().iterator();
            while(it.hasNext()) {
                String key = it.next();
                String value = rb.getString(key);
                //System.out.println(key + " : " + value);
                Controller classObj = (Controller)Class.forName(value).newInstance();
                map.put(key, classObj);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        application.setAttribute("map", map);
    }
	
}
