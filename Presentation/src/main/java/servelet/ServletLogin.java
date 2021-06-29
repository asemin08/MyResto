package servelet;

import eu.ensup.myresto.LoginUserDto;
import eu.ensup.myresto.User;
import eu.ensup.myresto.UserDto;
import eu.ensup.myresto.UserService;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        if (request.getParameter("login") != null) {
            LoginUserDto loginUserDto = new LoginUserDto(request.getParameter("login"), request.getParameter("password"));
            UserService userService = new UserService();
            try {
                userSession.removeAttribute("user");
                UserDto user = userService.validateUser(loginUserDto);
                userSession.setAttribute("user", user);
                request.getRequestDispatcher("accueil.jsp").forward(request, response);
            } catch (ServiceException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
