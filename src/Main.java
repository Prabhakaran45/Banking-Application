import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FileHandler handler=new FileHandler();
        CustomerHandler cHandle=new CustomerHandler();

        try {
            handler.initializer();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        boolean n=true;
        while(n) {
            System.out.println("To Create account enter 1\n To display account details enter 2");
            int choice = sc.nextInt();
            if (choice == 1) {
                cHandle.create();
            } else n = false;
        }
//        System.out.println(Bank.list.get(2).passWord);
//        System.out.println(Bank.list.get(3).Name);
        //System.out.println(Bank.list.get(4).Name);
    }
}