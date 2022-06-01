package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        productRepository.insert(new Product("Samsung_Galaxy_S20_FE", 580));
        productRepository.insert(new Product("Apple_iPhone_11", 730));
        productRepository.insert(new Product("Apple iPhone_12", 820));
        productRepository.insert(new Product("Realme_8", 280));
        productRepository.insert(new Product("Xiaomi_Redmi_Note_11", 290));
        productRepository.insert(new Product("Motorola_Moto_G60", 290));
        productRepository.insert(new Product("OnePlus_Nord_N100", 199));
        productRepository.insert(new Product("OPPO_A53", 210));
        productRepository.insert(new Product("Nokia_G21", 199));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            req.setAttribute("products", productRepository.findAll());
            getServletContext().getRequestDispatcher("/products.jsp").forward(req, resp);
        }


//        PrintWriter wr = resp.getWriter();
//        wr.println("<h1> Products </h1>");
//        wr.println("<table>");
//        wr.println("<tr>");
//        wr.println("<th>Id</th>");
//        wr.println("<th>Title</th>");
//        wr.println("<th>Cost</th>");
//        wr.println("</tr>");
//
//        for (Product product : productRepository.findAll()) {
//            wr.println("<tr>");
//            wr.println("<td>"); wr.println(product.getId());
//            wr.println("</td>");
//            wr.println("<td>"); wr.println(product.getTitle());
//            wr.println("</td>");
//            wr.println("<td>"); wr.println(product.getCost());
//            wr.println("</td>");
//            wr.println("</tr>");
//        }
//
//        wr.println("</table>");
    }
}