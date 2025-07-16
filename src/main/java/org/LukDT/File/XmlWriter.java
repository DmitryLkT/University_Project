package org.LukDT.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    private XmlWriter() {}

    public static <T> void writeToXml(T object, String fileName) {
        Path path = Paths.get("").toAbsolutePath();
        Path xmlWr = path.resolve("src/main/java/org/LukDT/XmlWr");

        //if(Files.exists(xmlWr + fileName))

        try {
            if(!Files.exists(xmlWr)) {
                Files.createDirectory(xmlWr);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при создании папки");

        }

        Path filePath = xmlWr.resolve(fileName);

        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, filePath.toFile());

        } catch(JAXBException e) {
            logger.log(Level.SEVERE, "Ошибка сериализации");
        }

    }
}
