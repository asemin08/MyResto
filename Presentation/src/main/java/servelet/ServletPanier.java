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
import java.util.Set;

@WebServlet(name = "ServletPanier", value = "/ServletPanier")
public class ServletPanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = request.getServletPath();
            switch (action) {
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/ServletPanier":
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

    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();

        Set<ProductDto> List = productService.getAllProducts();
        userSession.setAttribute("listProduct", List);
        request.getRequestDispatcher("panier.jsp").forward(request, response);

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceException {
        ProductService productService = new ProductService();
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        req.getRequestDispatcher("panier.jsp").forward(req, resp);

    }

}
