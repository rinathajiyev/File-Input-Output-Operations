package fileOperations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    private static void writeIntoFile(String fileName, String text, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(text);
        }
    }

    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static String readFromFile(String fileName) throws Exception {
        try (InputStream in = new FileInputStream(fileName);
             InputStreamReader r = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(r)) {
            String line = null;
            String result = "";

            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
            return result;
        }
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        FileOutputStream fos = new FileOutputStream(fileName);

        fos.write(data);
        fos.flush();
        fos.close();
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytesArray = new byte[(int) file.length()];
            fileInputStream.read(bytesArray);
            return bytesArray;
        }
    }

    public static void writeBytesWithNio(byte[] data, String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data);
    }

    public static byte[] readBytesWithNio(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;
    }

    public static void writeObjectToFile(Serializable object, String fileName) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
        }
    }

    public static Object readFileDeserialize(String fileName) throws Exception {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            obj = ois.readObject();
        } finally {
            return obj;
        }
    }
}
