import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerHandler {
    Scanner sc=new Scanner(System.in);
    public void create(){
        System.out.println("Enter the Name");
        String name=sc.nextLine();
        System.out.println("Enter the Balance");
        Long balance=sc.nextLong();
        System.out.println("Enter the password");
        String passWord=sc.next();
        System.out.println("Reenter the Password");
        String password2=sc.next();
        if(!(passWord.equals(password2))){
            System.out.println("Password MisMatch");
            return;

        }
        String encrypted_password= encrypt(passWord);
        int size=Bank.list.size();
        Bank.refCustomerAccount=Bank.list.get(size-1).accountId;
        Bank.refCustomerAccount=Bank.list.get(size-1).accountNumber;
        Bank.refCustomerAccount++;
        Bank.refCustomerId++;
        String str="\n"+Bank.refCustomerId+" "+Bank.refCustomerAccount+" "+name+" "+balance+" "+encrypted_password;

        try {
            BufferedWriter br=new BufferedWriter(new FileWriter("src\\bank_db.txt",true));
            br.write(str);
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Customer newCustomer=new Customer(
                      Bank.refCustomerId,
                      Bank.refCustomerAccount,
                      name,
                     balance,
                encrypted_password

        );
        Bank.list.add(newCustomer);
    }
    public String encrypt(String password){
        char[] arr=password.toCharArray();
        String st="";
        for(char ch:arr){
            if(ch=='9') st+="0";
            else if(ch=='z') st+="a";
            else if(ch=='Z') st+="A";
            else{
                st+=(char)(ch+1);
            }

        }
        return st;
    }

}
