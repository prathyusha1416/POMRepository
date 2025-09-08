package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;

public class ExcelUtils {

    public static List<Map<String, String>> readSheet(String fileOnClasspath, String sheetName) {
        try (InputStream is = ExcelUtils.class.getClassLoader().getResourceAsStream(fileOnClasspath);
             XSSFWorkbook wb = new XSSFWorkbook(is)) {
            XSSFSheet sheet = wb.getSheet(sheetName);
            DataFormatter fmt = new DataFormatter();
            List<Map<String, String>> data = new ArrayList<>();
            Iterator<org.apache.poi.ss.usermodel.Row> it = sheet.iterator();
            List<String> headers = new ArrayList<>();
            if (it.hasNext()) {
                org.apache.poi.ss.usermodel.Row headerRow = it.next();
                headerRow.forEach(c -> headers.add(fmt.formatCellValue(c)));
            }
            while (it.hasNext()) {
                org.apache.poi.ss.usermodel.Row row = it.next();
                Map<String, String> rowData = new LinkedHashMap<>();
                for (int i = 0; i < headers.size(); i++) {
                    String key = headers.get(i);
                    String val = fmt.formatCellValue(row.getCell(i));
                    rowData.put(key, val);
                }
                data.add(rowData);
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel: " + e.getMessage(), e);
        }
    }
}
