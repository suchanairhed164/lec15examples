import java.io.*;

public class SerializationTest {
    public static void main(String[] s) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream os =
                new ByteArrayOutputStream();
        Object objSave = new Integer(1);
        ObjectOutputStream oos =
                new ObjectOutputStream(os);
        oos.writeObject(objSave);

        byte[] bArray = os.toByteArray();

        ByteArrayInputStream is =
                new ByteArrayInputStream(bArray);
        ObjectInputStream ois =
                new ObjectInputStream(is);
        Object objRead = ois.readObject();

        System.out.println("readed object is: " +
                objRead.toString());
        System.out.println("Object equality is: " +
                (objSave.equals(objRead)));
        System.out.println("Reference equality is: " +
                (objSave==objRead));
    }
}
