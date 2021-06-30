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

@WebServlet(name = "ServletAddProductToCart", value = "/addproductcart")
public class ServletAddProductToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addProductToCart(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addProductToCart(request, response);
    }

    protected void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        Map<Integer, Integer> productsOrder = (Map<Integer, Integer>) userSession.getAttribute("order");
        int productId = Integer.parseInt(request.getParameter("id"));
        productsOrder.put(productId, productsOrder.get(productId) + 1);
        response.sendRedirect(request.getContextPath() + "/panier");
    }


}
