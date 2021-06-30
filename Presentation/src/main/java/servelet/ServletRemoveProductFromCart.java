package servelet;

import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ServlerRemoveProductCart", value = "/removeproductcart")
public class ServletRemoveProductFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        removeProductFromCart(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        removeProductFromCart(request, response);
    }

    protected void removeProductFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        Map<Integer,Integer> productsOrder = (Map<Integer, Integer>) userSession.getAttribute("order");
        int productId = Integer.parseInt(request.getParameter("id"));
        if(productsOrder.get(productId) > 1){
            productsOrder.put(productId,productsOrder.get(productId)-1);
        } else {
            productsOrder.remove(productId);
        }
        response.sendRedirect(request.getContextPath()+"/panier");

    }


}
