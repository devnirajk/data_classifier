package com.Medicine_Doc_Aid.Medicine_Doc_Aid;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import com.Medicine_Doc_Aid.Medicine_Doc_Aid.APIClient;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExcelReader {
//    public static void main(String[] args) throws IOException {
//        // Open the Excel file
//        try (FileInputStream fis = new FileInputStream("data.xlsx")) {
//            Workbook workbook = new XSSFWorkbook(fis);
//            Sheet sheet = workbook.getSheetAt(0);
//
//
//            // Read each row and column
//            for (Row row : sheet) {
//                if(row.getRowNum() > 0 && row.getRowNum()<=5) {
//                    Cell composition = row.getCell(0);
//
//                    Cell generatedTextCell = row.getCell(4);  // Column E is index 4 (0-based)
//                    if (generatedTextCell == null) {
//                        generatedTextCell = row.createCell(4);
//                    }
//
//                    String department = APIClient.callGemini(composition.toString());
//                    // Write the generated text into column E
//                    generatedTextCell.setCellValue(department);
//                }
//            }
//
//            // Close the input stream
//            FileInputStream.close();
//
//            // Write the changes back to the file
//            FileOutputStream fileOutputStream = new FileOutputStream("data.xlsx");
//            workbook.write(fileOutputStream);
//
//            // Close the output stream and workbook
//            fileOutputStream.close();
//            workbook.close();
//        }
//    }
//}



import com.Medicine_Doc_Aid.Medicine_Doc_Aid.APIClient;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) throws IOException {
        // Open the Excel file
        try (FileInputStream fis = new FileInputStream("data.xlsx")) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Read each row and column
            for (Row row : sheet) {

                // Change IF Condition (RItesh)
                if(row.getRowNum() >= 6 && row.getRowNum() <= 19) {
                    Cell composition = row.getCell(0);

                    Cell generatedTextCell = row.getCell(4);  // Column E is index 4 (0-based)
                    if (generatedTextCell == null) {
                        generatedTextCell = row.createCell(4);
                    }

                    String department = APIClient.callGemini(composition.toString());
                    // Write the generated text into column E
                    generatedTextCell.setCellValue(department);
                }
            }

            // Write the changes back to the file
            try (FileOutputStream fileOutputStream = new FileOutputStream("data.xlsx")) {
                workbook.write(fileOutputStream);
            }

            // Close the workbook
            workbook.close();
        }
    }
}