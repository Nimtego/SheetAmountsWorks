package controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by myasnikov
 * on 08.08.2017.
 */
public class ExcelParser {
    public static void generate(final String[][] array, File file) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet");
        Row row;
        Cell cell;
        for (int i = 0; i < array.length; i++) {
            row = sheet.createRow(i);
            sheet.autoSizeColumn(i);
            for (int j = 0; j < array[i].length; j++) {
                CellStyle style = workbook.createCellStyle();
                style.setBorderBottom(CellStyle.BORDER_THIN);
                style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                style.setBorderLeft(CellStyle.BORDER_THIN);
                style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                style.setBorderRight(CellStyle.BORDER_THIN);
                style.setRightBorderColor(IndexedColors.BLACK.getIndex());
                style.setBorderTop(CellStyle.BORDER_THIN);
                style.setTopBorderColor(IndexedColors.BLACK.getIndex());
                cell = row.createCell(j);
                cell.setCellValue(array[i][j]);
                cell.setCellStyle(style);
            }
        }
        workbook.write(new FileOutputStream(file));
        workbook.close();
    }
}
