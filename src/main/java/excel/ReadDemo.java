package excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDemo {
    public XSSFSheet read() {
        XSSFSheet sheet;
        try {
            FileInputStream file = new FileInputStream(new File("G://personList.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
            return sheet;

        } catch (FileNotFoundException f) {
            f.printStackTrace();
            return null;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        }
    }
}
