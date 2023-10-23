package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.CustomerService;
import vn.edu.iuh.fit.backend.services.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet(urlPatterns = {"/control"}, name = "control")
public class ControlServlet extends HttpServlet {
    public ControlServlet() {
    }

    CustomerService customerService = new CustomerService();
    EmployeeService employeeService = new EmployeeService();

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
                    case "updateCustomer":
                        long custID = Long.parseLong(req.getParameter("id"));
                        Optional<Customer> customer = customerService.findCustomer(custID);
                        if (customer.isPresent()) {
                            Customer actualCustomer = customer.get();
                            session.setAttribute("idUpdate", custID);
                            session.setAttribute("customerUpdate", actualCustomer);
                            resp.sendRedirect("updateCustomer.jsp");
                        }
                        break;
                    case "deleteCustomer":
                        deletCustomer(req, resp);
                        break;
                    case "list-employee":
                        resp.sendRedirect("listEmployee.jsp");
                        break;
                    case "updateEmployee":
                        long empId = Long.parseLong(req.getParameter("id"));
                        Optional<Employee> employee = employeeService.findById(empId);
                        if (employee.isPresent()) {
                            Employee actualEmployee = employee.get();
                            session.setAttribute("updateEmployee", actualEmployee);
                            session.setAttribute("idEmpUpdate", empId);
                            resp.sendRedirect("updateEmployee.jsp");
                        }
                        break;
                    case "deleteEmployee":
                        deleteEmployee(req,resp);
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
                        updateCustomer(req, resp);
                        break;
                    case "insertEmployee":
                        insertEmployee(req, resp);
                        break;
                    case "updateEmployee":
                        updateEmployee(req, resp);
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
        Customer customer = new Customer(address, email, phone, name);
        customerService.insertCustomer(customer);
        resp.sendRedirect("listCustomer.jsp");
    }

    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long id = (long) session.getAttribute("idUpdate");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer customer = new Customer(id, address, email, phone, name);
        customerService.updateCustomer(customer);
        resp.sendRedirect("listCustomer.jsp");
    }

    public void deletCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        if (customerService.deleteCustomer(id)) {
            resp.sendRedirect("listCustomer.jsp");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }

    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String s_dob = req.getParameter("dob");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(s_dob, dateTimeFormatter);
        Employee employee = new Employee(address, dob, email, name, phone, EmployeeStatus.ACTIVE);
        employeeService.insertEmp(employee);
        resp.sendRedirect("listEmployee.jsp");

    }

    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long id = (long) session.getAttribute("idEmpUpdate");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String s_dob = req.getParameter("dob");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(s_dob, dateTimeFormatter);
        Employee employee = new Employee(id, address, dob, email, name, phone, EmployeeStatus.ACTIVE);
        employeeService.updateEmp(employee);
        resp.sendRedirect("listEmployee.jsp");
    }

    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long empID = Long.parseLong(req.getParameter("id"));
        System.out.println(empID);
        if (employeeService.deleteEmp(empID)) {
            System.out.println("Xoa thanh cong");
            resp.sendRedirect("listEmployee.jsp");
        } else {
            System.out.println("Xoa that bai!");
        }
    }
}
