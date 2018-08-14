package com.test.Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.Dao.LoginServer;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ResponseDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/**
		 * �����̲߳������������������Ĵ���ʱ��������̰߳�ȫ������
		 * i����������̲߳������ʣ�����û���̰߳�ȫ���⣬��Ϊi��doGet��������ľֲ�������
		 * ���ж���̲߳�������doGet����ʱ��ÿһ���߳����涼���Լ���i������ �����̲߳����Ķ����Լ���i���������Բ������̰߳�ȫ����
		 * ���̲߳�������ĳһ��������ʱ������ڷ����ڲ�������һЩ��Դ(���������ϵ�) ��ôÿһ���̶߳�����Щ���������ԾͲ������̰߳�ȫ������
		 */
		//HttpSession session =null;
		// String name =(String) session.getAttribute("LoginUser");
		// System.out.println(name);
		User user = new User();
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		LoginServer userJDBCTemplate =(LoginServer) context.getBean("LoginJDBCTemplate");
		//����ʵ��������
	    user = userJDBCTemplate.FindUser("username");
	    
	  
	    /*��ʵ����ת��json*/
	    //String output = new Gson().toJson(user);
	   String username= user.getUsername();
	   String password = user.getPassword();
	   String phonenumber= user.getPhonenumber();
	   String output = "username:"+username+"/password:"+password+"/phonenumber:"+phonenumber;
        /*��������*/  
	          //String output = "����ǰ��"+text;
		response.getWriter().write(output);
		((AbstractApplicationContext) context).close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
