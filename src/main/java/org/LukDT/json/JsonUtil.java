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

    public static String StudentCollectionSerialization(List<Student> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("studentCollection.json")) {
            gson.toJson(list, writer);
            return gson.toJson(list);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public static String StudentSerialization(Student s) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("student.json")) {
            gson.toJson(s, writer);
            return gson.toJson(s);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String UniversityCollectionSerialization(List<University> universities) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("universityCollection.json")) {
            gson.toJson(universities, writer);
            return gson.toJson(universities);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public static String UniversitySerialization(University u) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("university.json")) {
            gson.toJson(u, writer);
            return gson.toJson(u);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
