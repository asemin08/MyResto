package servelet;

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
public class ServletRegister extends HttpServlet
{
    private static final Logger log = LogManager.getLogger(ServletRegister.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Récupération des info du formulaire
        String login = request.getParameter("login");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String address = request.getParameter("address");
        String role = "Client";
        String image = request.getParameter("image");
        String password1 = request.getParameter("password[1]");
        String password2 = request.getParameter("password[2]");

        UserDto user = new UserDto(login, firstName, lastName, address, role, image);

        //Traitement des infos
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        try {
            int res = userService.create(user);

            if( res != 1 )
            {
                log.error("La création de l'utilisateur "+user.getFirstName()+" "+user.getLastName()+" a échouer");
                dispatcher = request.getRequestDispatcher("/register.jsp");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("/login.jsp");
            }
        }
        catch (ServiceException e) {
            request.setAttribute("error", "Identifiant ou mot de passe incorrect");
            dispatcher= request.getRequestDispatcher("/register.jsp");
        }

        //Redirection
        dispatcher.forward(request, response);
    }
}
