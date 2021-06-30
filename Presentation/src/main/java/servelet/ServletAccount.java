package servelet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAccount", value = "/account")
public class ServletAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();
        try {
            this.getServletContext().getRequestDispatcher("/account/index.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession userSession = request.getSession();
        try {
            this.getServletContext().getRequestDispatcher("/account/index.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }
}
