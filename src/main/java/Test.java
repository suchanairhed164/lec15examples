import java.io.ByteArrayInputStream;
import java.io.*;

/*
public class Test {
    public static void main(String s[]){
        byte[] bytes = {1,-1,0};
        ByteArrayInputStream in =
                new ByteArrayInputStream(bytes);
        int readedInt = in.read(); // readedInt=1
        System.out.println("first element read is: "
                + readedInt);
        readedInt = in.read();
// readedInt=255. Однако
// (byte)readedInt даст значение -1

        System.out.println("second element read is: "
                + readedInt);
        readedInt = in.read(); // readedInt=0
        System.out.println("third element read is: "
                + readedInt);
    }
}

 */
// Родительский класс, не реализующий Serializable
class Parent {
    public String firstName;
    private String lastName;
    public Parent(){
        System.out.println("Create Parent");
        firstName="old_first";
        lastName="old_last";
    }
    public void changeNames() {
        firstName="new_first";
        lastName="new_last";
    }
    public String toString() {
        return super.toString()+",first="+firstName+",last="+lastName;
    }
}
// Класс Child, впервые реализовавший Serializable
class Child extends Parent implements Serializable {
    private int age;
    public Child(int age) {
        System.out.println("Create Child");
        this.age=age;
    }
    public String toString() {
        return super.toString()+",age="+age;
    }
}
// Наследник Serializable-класса
class Child2 extends Child {
    private int size;
    public Child2(int age, int size) {
        super(age);
        System.out.println("Create Child2");
        this.size=size;
    }
    public String toString() {
        return super.toString()+",size="+size;
    }
}
// Запускаемый класс для теста
public class Test {
    public static void main(String[] arg) {
        try {
            FileOutputStream fos=new FileOutputStream("output.bin");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            Child c=new Child(2);
            c.changeNames();
            System.out.println(c);
            oos.writeObject(c);
            oos.writeObject(new Child2(3, 4));
            oos.close();
            System.out.println("Read objects:");
            FileInputStream fis=new FileInputStream("output.bin");
            ObjectInputStream ois=new ObjectInputStream(fis);
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
            ois.close();
        } catch (Exception e) { // упрощенная обработка для краткости
            e.printStackTrace();
        }
    }
}