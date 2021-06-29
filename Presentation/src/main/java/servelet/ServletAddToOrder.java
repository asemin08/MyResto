package servelet;

import eu.ensup.myresto.ProductDto;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ServletAddToOrder", value = "/addToOrder")
public class ServletAddToOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession userSession = request.getSession();
        Set<ProductDto> productList = new HashSet<>();
        JSONObject jsonObject = new JSONObject();
        ProductDto productDto = new ProductDto(Integer.parseInt(request.getParameter("productId")), request.getParameter("productName"), Float.parseFloat(request.getParameter("productPrice")), request.getParameter("productPicture"), request.getParameter("productDesc"), 0);
        if (userSession.getAttribute("order") != null) {
            productList.add(productDto);
        } else {
            //TODO decrypt json and add to cart
        }
        userSession.setAttribute("order", jsonObject.put("set", productList).toString());


        System.out.println(request.getParameter("productId"));
        this.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);


    }


}
