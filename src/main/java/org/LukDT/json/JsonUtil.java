package org.LukDT.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.LukDT.model.Student;
import org.LukDT.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class JsonUtil {
    private JsonUtil() {

    }

    public static Student StudentDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("student.json")) {
            Student student = gson.fromJson(reader, Student.class);

            return student;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void StudentSerialization(Student s) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("student.json")) {
            gson.toJson(s, writer);
        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Сериализованный JSON:\n" + gson.toJson(s));
    }

    public static University UniversityDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("university.json")) {
            University university = gson.fromJson(reader, University.class);

            return university;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void UniversitySerialization(University u) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("university.json")) {
            gson.toJson(u, writer);
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Сериализованный JSON:\n" + gson.toJson(u));
    }
}
