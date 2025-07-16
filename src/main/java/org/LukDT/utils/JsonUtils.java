package org.LukDT.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.LukDT.model.Student;
import org.LukDT.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class JsonUtils {
    private static final Logger logger = Logger.getLogger(JsonUtils.class.getName());
    private static final Path path = Paths.get("").toAbsolutePath();
    private static final Path pathG = path.resolve("src/main/java/org/LukDT/Gson");
    private static final LocalTime now = LocalTime.now().withNano(0);
    private static final String time = String.valueOf(now).replace(":", "_");

    private JsonUtils() {}

    public static <T> void collectionSerialization(List<T> list, String name) {
        logger.info("Старт метода collectionSerialization()");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(list);

        create(pathG);

        String fileName = time + "_" + name + ".json";

        Path filePath = pathG.resolve(fileName);

        try {
            Files.writeString(filePath, json);
            logger.info("Файл успешно создан");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка сериализации");
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> collectionDeserialization(String name, Class<T> clazz) {
        logger.info("Старт метода collectionDeserialization()");

        Gson gson = new Gson();
        Path path = pathG.resolve(name);

        try(Reader reader = Files.newBufferedReader(path)) {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, type);

        } catch(IOException e) {
            logger.log(Level.SEVERE, "Ошибка десериализации");
            throw new RuntimeException();
        }
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

    private static void create(Path path) {
        try {
            if(!Files.exists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при создании папки");
        }
    }
}
