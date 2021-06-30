package servelet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServlerRemoveProductCart", value = "/removeproductcart")
public class ServletRemoveProductFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();
        try {
            removeProductFromCart(request, response);
        } catch (IOException e) {
            userSession.setAttribute("error", e.getMessage());

        }
    }

    protected void removeProductFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession userSession = request.getSession();
        Map<Integer, Integer> productsOrder = (Map<Integer, Integer>) userSession.getAttribute("order");
        var productId = Integer.parseInt(request.getParameter("id"));
        if (productsOrder.get(productId) > 1) {
            productsOrder.put(productId, productsOrder.get(productId) - 1);
        } else {
            productsOrder.remove(productId);
        }
        response.sendRedirect(request.getContextPath() + "/panier");

    }


}
