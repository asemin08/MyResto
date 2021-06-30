package servelet;

import eu.ensup.myresto.Product;
import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.UserService;
import eu.ensup.myresto.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@WebServlet(name = "ServletPanier", value = "/panier")
public class ServletCart extends HttpServlet {

    private static final Logger log = LogManager.getLogger(UserService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        Map<Integer, Integer> productsIds = (Map<Integer, Integer>) userSession.getAttribute("order");
        Set<ProductDto> productDtos = new HashSet<>();
            for(Map.Entry<Integer,Integer> entry : productsIds.entrySet()){
                try {
                    productDtos.add(productService.getOneProduct(entry.getKey()));
                } catch (ServiceException e) {
                    log.error(e.getMessage());
                }
            }
        userSession.setAttribute("productSet",productDtos);
        request.getRequestDispatcher("panier.jsp").forward(request, response);

    }

}
