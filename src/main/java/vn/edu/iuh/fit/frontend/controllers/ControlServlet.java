package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.services.CustomerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = {"/control"}, name = "control")
public class ControlServlet extends HttpServlet {
    public ControlServlet() {
    }

    CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                switch (action) {
                    case "list-customer":
                        resp.sendRedirect("listCustomer.jsp");
                        break;
                    case "update":
                        long custID = Long.parseLong(req.getParameter("id"));
                        Optional<Customer> customer = customerService.findCustomer(custID);
                        if (customer.isPresent()) {
                            Customer actualCustomer = customer.get();
                            session.setAttribute("idUpdate", custID);
                            session.setAttribute("customerUpdate", actualCustomer);
                            resp.sendRedirect("updateCustomer.jsp");
                        }
                        break;
                    case "delete":
                        deletCustomer(req,resp);
                        break;
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object objectAction = req.getParameter("action");
            if (objectAction != null) {
                String action = objectAction.toString();
                switch (action) {
                    case "insertCustomer":
                        insertCustomer(req, resp);
                        break;
                    case "updateCustomer":
                        updateCustomer(req,resp);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer customer = new Customer(address, email, phone, name );
        customerService.insertCustomer(customer);
        resp.sendRedirect("listCustomer.jsp");
    }
    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        long id = (long) session.getAttribute("idUpdate");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer customer = new Customer(id,address, email, phone, name );
        customerService.updateCustomer(customer);
        resp.sendRedirect("listCustomer.jsp");
    }
    public void deletCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        long id = Long.parseLong(req.getParameter("id"));
        if(customerService.deleteCustomer(id)){
            resp.sendRedirect("listCustomer.jsp");
        }else {
            System.out.println("Xóa thất bại!");
        }
    }
}
