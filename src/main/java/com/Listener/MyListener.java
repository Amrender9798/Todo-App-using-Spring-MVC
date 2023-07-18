package com.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.ArrayList;
import com.entities.todo;

public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context created.......");
		List<todo> list = new ArrayList<>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list",list);
		
		
	}

}
