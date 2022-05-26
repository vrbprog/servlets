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
        productRepository.insert(new Product("Samsung Galaxy S20 FE", 580));
        productRepository.insert(new Product("Apple iPhone 11", 730));
        productRepository.insert(new Product("Apple iPhone 12 mini", 780));
        productRepository.insert(new Product("Apple iPhone 12", 820));
        productRepository.insert(new Product("Realme 8", 280));
        productRepository.insert(new Product("Xiaomi Redmi Note 11", 290));
        productRepository.insert(new Product("Motorola Moto G60", 290));
        productRepository.insert(new Product("OnePlus Nord N100", 199));
        productRepository.insert(new Product("OPPO A53", 210));
        productRepository.insert(new Product("Nokia G21", 199));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        wr.println("<h1> Products </h1>");
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Title</th>");
        wr.println("<th>Cost</th>");
        wr.println("</tr>");

        for (Product product : productRepository.findAll()) {
            wr.println("<tr>");
            wr.println("<td>"); wr.println(product.getId());
            wr.println("</td>");
            wr.println("<td>"); wr.println(product.getTitle());
            wr.println("</td>");
            wr.println("<td>"); wr.println(product.getCost());
            wr.println("</td>");
            wr.println("</tr>");
        }

        wr.println("</table>");
    }
}