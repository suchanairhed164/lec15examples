import java.io.*;

public class ReadWrite {
    public static void main(String[] as){
        String fileName = "d:\\file.txt";

//Строка, которая будет записана в файл
        String data = "Some data to be written and read.\n";
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Write some data to file: " + fileName);

            // Несколько раз записать строку
            for(int i=(int)(Math.random()*10);--i>=0;)
                bw.write(data);
            bw.close();

            // Считываем результат
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            int count = 0;
            System.out.println("Read data from file: " + fileName);

            // Считывать данные, отображая на экран
            while((s=br.readLine())!=null)
                System.out.println("row " + ++count + " read:" + s);
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
