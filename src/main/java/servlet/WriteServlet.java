package servlet;

import excel.WriteDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        WriteDemo writeDemo = new WriteDemo();
        String result = writeDemo.write();
        if (result.equals("yes")) {
            printWriter.println("your file saved in : (G://personList.xlsx)");
        }

    }
}
