package org.LukDT.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.LukDT.model.Student;
import org.LukDT.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public final class JsonUtil {
    private JsonUtil() {}

    public static void StudentCollectionSerialization(List<Student> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("studentCollection.json")) {
            gson.toJson(list, writer);
            System.out.println("Коллекция сериализованна");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> StudentCollectionDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("studentCollection.json")) {
            Type type = new TypeToken<List<Student>>(){}.getType();
            List<Student> list = gson.fromJson(reader, type);

            return list;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public static void UniversityCollectionSerialization(List<University> universities) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("universityCollection.json")) {
            gson.toJson(universities, writer);
            System.out.println("Коллекция сериализованна");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static List<University> UniversityCollectionDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("universityCollection.json")) {
            Type type = new TypeToken<List<University>>(){}.getType();
            List<University> list = gson.fromJson(reader, type);

            return list;
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
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
