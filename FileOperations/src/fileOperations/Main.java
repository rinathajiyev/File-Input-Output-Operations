package fileOperations;

public class Main {

    public static void main(String[] args) throws Exception {
        // Writing and Reading String
        FileUtility.writeIntoFile("test.txt", "Java World");
        String str = FileUtility.readFromFile("test.txt");
        System.out.println(str);

        // Reading bytes
        byte[] arr = FileUtility.readBytes("test.txt");
        System.out.println(new String(arr));

        // Writing and Reading Object
        User u = new User();
        u.name = "Rocky";
        u.password = "password";

        FileUtility.writeObjectToFile(u, "object.txt");
        User u2 = (User) FileUtility.readFileDeserialize("object.txt");
        System.out.println(u2.name);
        System.out.println(u2.password);
    }
}
