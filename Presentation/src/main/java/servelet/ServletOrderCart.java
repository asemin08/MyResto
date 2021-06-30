package servelet;

import eu.ensup.myresto.*;
import eu.ensup.myresto.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletOrderCart", value = "/ordercart")

public class ServletOrderCart extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletOrderCart.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();

        try {
            orderCart(request, response);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    protected void orderCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var orderProductService = new OrderProductService();
        HttpSession userSession = request.getSession();
        Map<Integer, Integer> productsIds = (Map<Integer, Integer>) userSession.getAttribute("order");
        List<Integer> idList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : productsIds.entrySet()) {
            for (var i = 0; i < entry.getValue(); i++) {
                idList.add(entry.getKey());
            }
        }
        var userDto = (UserDto) userSession.getAttribute("user");
        var orderProductDto = new OrderProductDto(userDto.getId(), idList, new Date(System.currentTimeMillis()));
        try {
            orderProductService.createOrderProduct(orderProductDto);
            userSession.removeAttribute("order");
            response.sendRedirect(request.getContextPath() + "/orders");
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessageViewForUser());
            log.error(e.getMessage());
            request.getRequestDispatcher("panier.jsp").forward(request, response);
        }

    }

}
