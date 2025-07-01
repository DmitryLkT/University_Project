package org.LukDT.utils;

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
import java.util.logging.Level;
import java.util.logging.Logger;


public final class JsonUtils {
    private static final Logger logger = Logger.getLogger(JsonUtils.class.getName());

    private JsonUtils() {}

    public static String StudentCollectionSerialization(List<Student> list) {
        logger.info("Старт метода StudentCollectionSerialization()");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);

        try(FileWriter writer = new FileWriter("studentCollection.json")) {
            writer.write(json);
        }catch(IOException e) {
            logger.log(Level.SEVERE, "Коллекцию не удалось сериалтзовать");
        }
        return json;
    }

    public static List<Student> StudentCollectionDeserialization() {
        logger.info("Старт метода StudentCollectionDeserialization()");
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("studentCollection.json")) {
            Type type = new TypeToken<List<Student>>(){}.getType();

            return gson.fromJson(reader, type);
        } catch(IOException e) {
            logger.log(Level.SEVERE, "Коллекцию не удалось десериалтзовать");
        }
        return null;
    }

    public static Student StudentDeserialization() {
        logger.info("Старт метода StudentDeserialization()");
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("student.json")) {
            return gson.fromJson(reader, Student.class);

        } catch(IOException e) {
            logger.log(Level.SEVERE, "Объект не удалось десериалтзовать");
        }
        return null;
    }

    public static String StudentSerialization(Student s) {
        logger.info("Старт метода StudentSerialization()");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(s);

        try(FileWriter writer = new FileWriter("student.json")) {
            writer.write(json);
        }catch(IOException e) {
            logger.log(Level.SEVERE, "Объект не удалось сериалтзовать");
        }

        return json;
    }

    public static String UniversityCollectionSerialization(List<University> universities) {
        logger.info("Старт метода UniversityCollectionSerialization()");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(universities);

        try(FileWriter writer = new FileWriter("universityCollection.json")) {
            writer.write(json);
        }catch(IOException e) {
            logger.log(Level.SEVERE, "Коллекцию не удалось сериалтзовать");
        }

        return json;
    }

    public static List<University> UniversityCollectionDeserialization() {
        logger.info("Старт метода UniversityCollectionDeserialization()");
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("universityCollection.json")) {
            Type type = new TypeToken<List<University>>(){}.getType();

            return gson.fromJson(reader, type);
        }catch(IOException e) {
            logger.log(Level.SEVERE, "Коллекцию не удалось десериалтзовать");
        }
        return null;
    }


    public static University UniversityDeserialization() {
        logger.info("Старт метода UniversityDeserialization()");
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("university.json")) {
            return gson.fromJson(reader, University.class);

        }catch (IOException e) {
            logger.log(Level.SEVERE, "Объект не удалось десериалтзовать");
        }
        return null;
    }

    public static String UniversitySerialization(University u) {
        logger.info("Старт метода UniversityDeserialization()");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(u);
        try(FileWriter writer = new FileWriter("university.json")) {
            writer.write(json);
        } catch(IOException e) {
            logger.log(Level.SEVERE, "Объект не удалось сериалтзовать");
        }
        return json;
    }
}
