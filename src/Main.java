import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        FileHandler handler=new FileHandler();
        CustomerHandler cHandle=new CustomerHandler();

        try {
            handler.initializer();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        menu();



    }
    public static void menu(){
        System.out.println("Please Enter your option \n1.Add Customer\n2.WithDraw Money\n3.Deposit\n4.FundTransfer\n5.Exit");
        int choice=sc.nextInt();
        CustomerHandler cHandle=new CustomerHandler();
        switch (choice){
            case 1 -> cHandle.create();
            case 2 -> cHandle.withdrawl();

        }
    }
}