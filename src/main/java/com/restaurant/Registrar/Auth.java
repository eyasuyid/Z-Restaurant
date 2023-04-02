package com.restaurant.Registrar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.utils.Print;
import com.restaurant.dbutils.users.Customerdb;
import com.restaurant.users.Customer;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/user/signin.jsp");
		rd.forward(request, response);
//		response.sendRedirect("/Restaurant/user/signin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		Customerdb cdb = new Customerdb();
		Customer cus = cdb.validCustomer(email, password);
		RequestDispatcher rd = request.getRequestDispatcher("/user/signin.jsp");
		if (cus == null) {
			request.setAttribute("error", "Email and Password don't match");
			rd.forward(request, response);
		} else {
			session.setAttribute("customer", cus);
			response.sendRedirect("/Restaurant/home.jsp");
		}
	}
}
