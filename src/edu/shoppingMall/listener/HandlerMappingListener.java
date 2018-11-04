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
 * 각 controller를 Map에 담아 application 영역에 담기위한 Listener
 * 동일 패키지 내부에 저장되어 있는 ActionMapping.properties를 불러온다.
 * 그렇기 때문에 키워드명과 controller 이름을 properties file에서 관리하도록합니다.
 * @author mark
 *
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }


    public void contextInitialized(ServletContextEvent e)  { 
        //필요한 객체를 미리 생성하여 map에 넣고 application영역에 map저장
        Map<String, Controller> map = new HashMap<>();
        
        ServletContext application = e.getServletContext();
        String fileName = application.getInitParameter("fileName");     //web.xml에 context-param에 입력되어있음.
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
