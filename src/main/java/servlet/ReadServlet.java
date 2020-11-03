package servlet;

import excel.ReadDemo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

public class ReadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        ReadDemo readDemo = new ReadDemo();
        XSSFSheet sheet = readDemo.read();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case NUMERIC:
                        printWriter.println(cell.getNumericCellValue() + "\t\t");
                        break;
                    case STRING:
                        printWriter.println(cell.getStringCellValue() + "\t\t");
                        break;
                }

            }
            printWriter.println("<br>");
            printWriter.println("---------");
            printWriter.println("<br>");
        }


    }
}
