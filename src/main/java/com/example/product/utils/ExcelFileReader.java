package com.example.product.utils;

import com.example.product.model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelFileReader implements IFileReader {
    @Override
    public List<Product> readFile(String fileName) {
        try {
            List<Product> resultList = new ArrayList<>();

            try (FileInputStream fileInputStream = new FileInputStream(new File(fileName));
                 Workbook workbook = new XSSFWorkbook(fileInputStream)) {

                Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên


                // Bỏ qua hàng đầu tiên (header)
                Iterator<Row> iterator = sheet.iterator();

                if (iterator.hasNext()) {
//                    System.out.println("DCCC");
//                    System.out.println(iterator.next());
                    iterator.next(); // Bỏ qua hàng đầu tiên (header)
                }

                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();

                    Product product = new Product();

                    while (cellIterator.hasNext()) {
                        Cell currentCell = cellIterator.next();
                        int columnIndex = currentCell.getColumnIndex();

                        switch (columnIndex) {
                            case 0:
                                product.setId((int) currentCell.getNumericCellValue());
                                break;
                            case 1:
                                product.setName(currentCell.getStringCellValue());
                                break;
                            case 2:
                                product.setDescription(currentCell.getStringCellValue());
                                break;
                            case 3:
                                product.setThumbnail(currentCell.getStringCellValue());
                                break;
                            case 4:
                                product.setPrice((int) currentCell.getNumericCellValue());
                                break;
                            case 5:
                                product.setRating((currentCell.getNumericCellValue()));
                                break;
                            case 6:
                                product.setPriceDiscount((int) currentCell.getNumericCellValue());
                                break;
                            // Thêm các trường khác tương ứng
                        }
                    }

                    resultList.add(product);
                }

            }
            return resultList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
