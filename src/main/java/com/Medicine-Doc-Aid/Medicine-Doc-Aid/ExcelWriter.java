//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExcelWriter {
//    public static void main(String[] args) throws IOException {
//        // Create a Workbook
//        Workbook workbook = new XSSFWorkbook();
//
//        // Create a Sheet
//        Sheet sheet = workbook.createSheet("Data");
//
//        // Create a Row
//        Row header = sheet.createRow(0);
//
//        // Create cells
//        header.createCell(0).setCellValue("ID");
//        header.createCell(1).setCellValue("Name");
//        header.createCell(2).setCellValue("Age");
//
//        // Create another row with data
//        Row row = sheet.createRow(1);
//        row.createCell(0).setCellValue(1);
//        row.createCell(1).setCellValue("John Doe");
//        row.createCell(2).setCellValue(29);
//
//        // Write the output to a file
//        try (FileOutputStream fileOut = new FileOutputStream("data.xlsx")) {
//            workbook.write(fileOut);
//        }
//
//        // Closing the workbook
//        workbook.close();
//        System.out.println("Excel file written successfully.");
//    }
//}
