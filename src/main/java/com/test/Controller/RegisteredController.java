package com.test.Controller;



import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.Dao.LoginServer;
import com.test.Service.User;

@Controller
public class RegisteredController {

	@RequestMapping(value = "/Registered")
	public ModelAndView Registered () {
		return new ModelAndView("Registered","command",new User());
	}
	@RequestMapping(value = "/RegisteredAction", method =RequestMethod.POST)
	public String RegisteredAction(User user) throws JSONException {		
		ApplicationContext context =new ClassPathXmlApplicationContext("bean.xml");
		LoginServer adduserJDBCTemplate =(LoginServer) context.getBean("LoginJDBCTemplate");
		if(user.getPassword().equals(user.getPasswordAgain())) {
			boolean result = adduserJDBCTemplate.AddUser(user);
		if(result) {			
			System.out.println("ע��ɹ�");	
			((AbstractApplicationContext) context).close();
			return "index";
			
		}else {			
			System.out.println("ע��ʧ��");
			((AbstractApplicationContext) context).close();
			return "Registered";
		}
		}else {
			System.out.println("�������벻һ�£�");
			((AbstractApplicationContext) context).close();
			return "Registered";
		}				
	}
	
	}
	

