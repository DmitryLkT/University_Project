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
        String json = gson.toJson(list);

        try(FileWriter writer = new FileWriter("studentCollection.json")) {
            writer.write(json);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static List<Student> StudentCollectionDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("studentCollection.json")) {
            Type type = new TypeToken<List<Student>>(){}.getType();

            return gson.fromJson(reader, type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Student StudentDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("student.json")) {
            return gson.fromJson(reader, Student.class);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String StudentSerialization(Student s) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(s);

        try(FileWriter writer = new FileWriter("student.json")) {
            writer.write(json);
        }catch(IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String UniversityCollectionSerialization(List<University> universities) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(universities);

        try(FileWriter writer = new FileWriter("universityCollection.json")) {
            writer.write(json);
        }catch(IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static List<University> UniversityCollectionDeserialization() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("universityCollection.json")) {
            Type type = new TypeToken<List<University>>(){}.getType();

            return gson.fromJson(reader, type);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static University UniversityDeserialization() {
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("university.json")) {
            return gson.fromJson(reader, University.class);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String UniversitySerialization(University u) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(u);
        try(FileWriter writer = new FileWriter("university.json")) {
            writer.write(json);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
