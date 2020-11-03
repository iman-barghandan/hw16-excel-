package servlet;

import domains.Person;
import services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        PersonService personService = new PersonService();
        if (!req.getParameter("FirstName").equals("") && !req.getParameter("LastName").equals("") && !req.getParameter("PhoneNumber").equals("")) {
            Person person = personService.insertPerson(req.getParameter("FirstName"), req.getParameter("LastName"), req.getParameter("PhoneNumber"));
            if (person != null) {
                printWriter.println("Registration completed successfully");
            } else printWriter.println("The information entered is not valid");
        } else printWriter.println("The information entered is empty");
    }
}
