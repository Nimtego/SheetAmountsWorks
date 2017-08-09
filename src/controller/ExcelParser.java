package controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
                cell = row.createCell(j);
                cell.setCellValue(array[i][j]);
            }
        }
/*        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());*/
        workbook.write(new FileOutputStream(file));
        workbook.close();
    }
}
