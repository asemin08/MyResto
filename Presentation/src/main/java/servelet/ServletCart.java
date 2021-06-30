package servelet;

import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.UserService;
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
import java.util.*;


@WebServlet(name = "ServletPanier", value = "/panier")
public class ServletCart extends HttpServlet {

    private static final Logger log = LogManager.getLogger(UserService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        operations(request, response,userSession);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        operations(request, response,userSession);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response,HttpSession userSession) throws ServletException, IOException, ServiceException {
        ProductService productService = new ProductService();
        Map<Integer, Integer> productCount = new HashMap<>();
        List<Integer> productsOrder = (List<Integer>) userSession.getAttribute("order");
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
