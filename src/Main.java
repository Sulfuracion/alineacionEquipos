import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
        File Alineacion= new File("alineacion.txt");
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(Alineacion));
            int cont=1;
            for (int i=0;i<11;i++){
                String numeros=Integer.toString(cont);
                bw.write(numeros);
                bw.newLine();
                cont++;

            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}