package servelet;

import eu.ensup.myresto.OrderProductService;
import eu.ensup.myresto.User;
import eu.ensup.myresto.UserDto;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletOrder", value = "/orders")
public class ServletOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderProductService orderProductService = new OrderProductService();
        HttpSession userSession = request.getSession();

        try {
            if (request.getSession().getAttribute("user") != null)
            {
                var orders = orderProductService.getAllOrderProductsForOneUser(((UserDto)request.getSession().getAttribute("user")).getId());
                userSession.setAttribute("listOrders", orders);
            }else
                this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);

        } catch (ServiceException e) {
            userSession.setAttribute("error", e.getMessageViewForUser());

        }
        this.getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
    }
}
