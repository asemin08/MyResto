package servelet;

import eu.ensup.myresto.RegisterUserDto;
import eu.ensup.myresto.UserDto;
import eu.ensup.myresto.UserService;
import eu.ensup.myresto.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRegister", value = "/register")
public class ServletRegister extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletRegister.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request, response);

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        if (request.getParameter("login") != null) {
            RegisterUserDto user = new RegisterUserDto(0, request.getParameter("login"), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("address"), null, null, "Client", null);
            String password1 = request.getParameter("password[1]");
            String password2 = request.getParameter("password[2]");
            if (password1.equals(password2)) {
                user.setPassword(password1);
                try {
                    if (userService.create(user) == 1) {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error", "L'inscription n'a pas été réalisée");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }
                } catch (ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Les mots de passes ne correspondent pas.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
