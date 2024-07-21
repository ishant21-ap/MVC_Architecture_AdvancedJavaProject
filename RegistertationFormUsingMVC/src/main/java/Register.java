

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		Model model = new Model();   // using set parameter we have injected value
		
		 // Check if user already exists
		if (model.checkUserExists(email)) {
		    // User already exists, redirect to failure page
		    HttpSession session = request.getSession();
		    session.setAttribute("email", email); // Set email attribute in session
		    response.sendRedirect("/RegistertationFormUsingMVC/userExists.jsp");
		    return;
		}
	    
	    // User does not exist, proceed with registration
		model.setFullname(fullname);
		model.setPhone(phone);
		model.setEmail(email);
		model.setPassword(password);
		model.setGender(gender);
		
	
		int row = model.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("fullname", fullname);
		
		if(row == 0) {  // if no data is inserted
			response.sendRedirect("/RegistertationFormUsingMVC/failure.jsp");
		}
		else {
			response.sendRedirect("/RegistertationFormUsingMVC/success.jsp");
		}
		
	}

}
