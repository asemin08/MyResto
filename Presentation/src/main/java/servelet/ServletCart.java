package servelet;

import eu.ensup.myresto.Product;
import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@WebServlet(name = "ServletPanier", value = "/panier")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = request.getServletPath();
            switch (action) {
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/panier":
                    operations(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServiceException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            switch (action) {
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/panier":
                    operations(request, response);
                    break;
                default:
                    break;
            }


        } catch (ServiceException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        Map<Integer, Integer> productCount = new HashMap<>();
        List<Integer> productsOrder = (List<Integer>) userSession.getAttribute("order");
        Set<ProductDto> productDtos = new HashSet<>();
        if (productsOrder != null)
            for (int productId : productsOrder) {
                if (productCount.get(productId) != null) {
                    productCount.put(productId, productCount.get(productId) + 1);
                } else {
                    productCount.put(productId, 1);
                    productDtos.add(productService.getOneProduct(productId));
                }
            }
        userSession.setAttribute("productSet", productDtos);
        userSession.setAttribute("productCount", productCount);
        request.getRequestDispatcher("panier.jsp").forward(request, response);

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceException {
        ProductService productService = new ProductService();
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        req.getRequestDispatcher("panier.jsp").forward(req, resp);

    }

}
