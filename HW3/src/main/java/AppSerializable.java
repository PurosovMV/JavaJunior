import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;


public class AppSerializable {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public void app(String FILE_BIN, String FILE_JSON, String FILE_XML, Student student) {


        try {
            // Сериализация в файл 'students.bin'
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_BIN))) {
                oos.writeObject(student);
                System.out.println("Сериализация в файл 'students.bin' выполнена успешно!");
            }

            // Сериализация в файл 'students.json'
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), student);
            System.out.println("Сериализация в файл 'students.json' выполнена успешно!");

            // Сериализация в файл 'students.xml'
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(FILE_XML), student);
            System.out.println("Сериализация в файл 'students.xml' выполнена успешно!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            // Десериализация из файла 'students.bin'
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_BIN))) {
                student = (Student) ois.readObject();
                System.out.println("Десериализация из файла 'students.bin' выполнена успешно!");
                System.out.println(student);
            }

            // Десериализация из файла 'students.json'
            File fileJSON = new File(FILE_JSON);
            student = objectMapper.readValue(fileJSON, Student.class);
            System.out.println("Десериализация из файла 'students.json' выполнена успешно!");
            System.out.println(student);

            // Десериализация из файла 'students.xml'
            File fileXML = new File(FILE_XML);
            student = xmlMapper.readValue(fileXML, Student.class);
            System.out.println("Десериализация из файла 'students.xml' выполнена успешно!");
            System.out.println(student);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
