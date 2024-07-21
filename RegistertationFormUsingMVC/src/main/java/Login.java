

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Model model = new Model();
		boolean isValidUser = model.validateUser(email, password);
		
		HttpSession session = request.getSession();
		
		if(isValidUser) {
			 String fullName = model.getFullNameByEmail(email);
			session.setAttribute("email", email);
			 session.setAttribute("fullname", fullName);
			response.sendRedirect("/RegistertationFormUsingMVC/dashboard.jsp");
		}
		else {
			session.setAttribute("error", "Invalid email or password");
			response.sendRedirect("/RegistertationFormUsingMVC/loginFailed.jsp");
		}
	}

}
