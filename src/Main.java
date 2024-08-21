import javax.imageio.IIOException;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FileHandler handler=new FileHandler();
        try {
            handler.initializer();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(Bank.list.get(2).passWord);
    }
}