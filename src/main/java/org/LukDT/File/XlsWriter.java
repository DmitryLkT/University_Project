package org.LukDT.File;

import org.LukDT.model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private static final String FILE = "src/main/resources/universityInfoStatistics.xlsx";
    private static final String SHEET_NAME = "Статистика";
    private static final String[] HEADERS = {
            "Профиль обучения",
            "Средний бал за экзамен",
            "Колличество студентов по профилю",
            "Названия университетов",
            "Количество университетов по профилю"
    };

    private XlsWriter() {}

    public static void writeUniversity(List<Statistics> list) {
        try(FileOutputStream fos = new FileOutputStream(FILE);
            Workbook wb = createTableStatistics()) {

            Sheet sheet = wb.getSheet(SHEET_NAME);
            int count = 1;

            for(Statistics element : list) {
                Row row = sheet.createRow(count++);
                row.createCell(0).setCellValue(element.getStatisticsProfile().toString());
                row.createCell(1).setCellValue(element.getStatisticsAvg());
                row.createCell(2).setCellValue(element.getStatisticsCountStudents());
                row.createCell(3).setCellValue(element.getStatisticsNameUniversity());
                row.createCell(4).setCellValue(element.getStatisticsCountUniversity());
            }

            // Автоподбор ширины столбцов
            for (int i = 0; i < HEADERS.length; i++) {
                sheet.autoSizeColumn(i);
            }

            //Сохраняем
            wb.write(fos);

        } catch(IOException e) {
            throw new RuntimeException("Ошибка при записи в Excel ", e);
        }
    }

    private static Workbook createTableStatistics() {
        //Создание новой книги Excel
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet(SHEET_NAME);

        //Создание шрифта
        Font font = wb.createFont();
        font.setFontName("Calibri");
        font.setBold(true);

        //Создание стиля и применение шрифта
        CellStyle style = wb.createCellStyle();
        style.setFont(font);

        Row row = sheet.createRow(0);
        for(int i = 0; i < HEADERS.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(HEADERS[i]);
            //Создание ячейки с этим стилем
            cell.setCellStyle(style);
        }

        return wb;
    }
}
