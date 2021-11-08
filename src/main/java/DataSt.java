import java.io.*;

public class DataSt {
    public static void main(String[] ar){
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DataOutputStream outData = new DataOutputStream(out);
            outData.writeByte(128);
            // этот метод принимает аргумент int, но записывает
            // лишь младший байт
            outData.writeInt(128);
            outData.writeLong(128);
            outData.writeDouble(128);
            outData.close();
            byte[] bytes = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bytes);
            DataInputStream inData = new DataInputStream(in);
            System.out.println("Чтение в правильной последовательности: ");
            System.out.println("readByte: " + inData.readByte());
            System.out.println("readInt: " + inData.readInt());
            System.out.println("readLong: " + inData.readLong());
            System.out.println("readDouble: " + inData.readDouble());
            inData.close();
            System.out.println("Чтение в измененной последовательности:");
            in = new ByteArrayInputStream(bytes);
            inData = new DataInputStream(in);
            System.out.println("readInt: " + inData.readInt());
            System.out.println("readDouble: " + inData.readDouble());
            System.out.println("readLong: " + inData.readLong());
            inData.close();
        } catch (Exception e) {
            System.out.println("Impossible IOException occurs: " +
                    e.toString());
            e.printStackTrace();
        }
    }
}
