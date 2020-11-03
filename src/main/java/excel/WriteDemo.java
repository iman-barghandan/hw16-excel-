package excel;

import domains.Person;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.PersonService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDemo {
    public String write() {
        PersonService personService = new PersonService();
        List<Person> personList = personService.selectAllPerson();
        Map<Integer, String[]> personMap = new TreeMap<>();
        String[] head = {"Id", "firstName", "lastName", "phoneNumber"};
        personMap.put(1, head);
        for (int i = 0; i < personList.size(); i++) {
            long id = personList.get(i).getId();
            String stringId = id + "";
            String[] array = {stringId, personList.get(i).getFirstName(), personList.get(i).getLastName(), personList.get(i).getPhoneNumber()};
            personMap.put(i + 2, array);
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Person");

        Set<Integer> keySet = personMap.keySet();
        int rowNumber = 0;
        for (Integer key : keySet) {
            Row row = sheet.createRow(rowNumber++);
            String[] stringArray = personMap.get(key);
            int cellNumber = 0;
            for (String s : stringArray) {
                Cell cell = row.createCell(cellNumber++);
                cell.setCellValue(s);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("G://personList.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("personList written successfully on disk");
            personService.removeAll();
            return "yes";
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            return "no";
        } catch (IOException i) {
            i.printStackTrace();
            return "no";
        }
    }
}
