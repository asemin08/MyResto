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

@WebServlet(name = "ServletPanier", value = "/panier")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();

        try {
            try {
                String action = request.getServletPath();
                switch (action) {
                    case "/delete":
                        deleteProduct(request, response);

                        break;
                    case "/panier":
                        operations(request, response,userSession);
                        break;
                    default:
                        break;
                }
            } catch (ServiceException e) {
                request.getRequestDispatcher("404.jsp").forward(request, response);
                e.printStackTrace();
            }
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();

        try {
            try {
                String action = request.getServletPath();
                switch (action) {
                    case "/delete":
                        deleteProduct(request, response);

                        break;
                    case "/panier":
                        operations(request, response,userSession);
                        break;
                    default:
                        break;
                }
            } catch (ServiceException e) {
                request.getRequestDispatcher("404.jsp").forward(request, response);
                e.printStackTrace();
            }
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response,HttpSession userSession) throws ServletException, IOException, ServiceException {
        ProductService productService = new ProductService();
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
