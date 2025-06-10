package org.LukDT.File;

import org.LukDT.enums.StudyProfile;
import org.LukDT.model.Student;
import org.LukDT.model.University;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXlsx {
    private ReadXlsx() {

    }

    public static List<University> readUniversity() {
        List<University> list = new ArrayList<>();
        String file = "src/main/resources/universityInfo.xlsx";

        try(FileInputStream fis = new FileInputStream(file);
            Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(1);

            for(Row row : sheet) {

                if(row.getRowNum() == 0) continue;

                String id = row.getCell(0).getStringCellValue();
                String fullName = row.getCell(1).getStringCellValue();
                String shortName = row.getCell(2).getStringCellValue();
                int year = (int) row.getCell(3).getNumericCellValue();
                String profStr = row.getCell(4).getStringCellValue();
                StudyProfile prof = StudyProfile.valueOf(profStr);

                list.add(new University(id, fullName, shortName, year, prof));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Student> readStudent() {
        List<Student> list = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
            Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);


            for(Row row : sheet) {
                if(row.getRowNum() == 0) continue;

                String id = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                int course = (int) row.getCell(2).getNumericCellValue();
                float avg = (float) row.getCell(3).getNumericCellValue();

                list.add(new Student(name, id, course, avg));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
