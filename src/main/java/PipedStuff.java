import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStuff {
    public static void main(String stg[]){

        try {
            int countRead = 0;
            byte[] toRead = new byte[100];
            PipedInputStream pipeIn = new PipedInputStream();
            PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

            // Считывать в массив, пока он полностью не будет заполнен
            while(countRead<toRead.length) {

                // Записать в поток некоторое количество байт
                for(int i=0; i<(Math.random()*10); i++) {
                    pipeOut.write((byte)(Math.random()*127));
                }

                // Считать из потока доступные данные,
                // добавить их к уже считанным.
                int willRead = pipeIn.available();
                if(willRead+countRead>toRead.length)

                    //Нужно считать только до предела массива
                    willRead = toRead.length-countRead;
                countRead += pipeIn.read(toRead, countRead, willRead);
            }
        } catch (IOException e) {
            System.out.println ("Impossible IOException occur: ");
            e.printStackTrace();
        }

    }
}
