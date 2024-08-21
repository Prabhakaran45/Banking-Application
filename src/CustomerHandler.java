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
        Bank.map.put(newCustomer.accountId,newCustomer);
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
    private boolean authentication(int accId, String password){
        String encryPass=encrypt(password);
        if(Bank.map.get(accId).passWord.equals(encryPass)) return true;
        return false;

    }
    public void withdrawl(){
        System.out.println("Enter the account id:");
        int account=sc.nextInt();
        System.out.println("Enter the Password:");
        String password=sc.next();
        if(authentication(account,password)){
            System.out.println("Enter the amount to Withdraw:");
            int money=sc.nextInt();
            Customer customer=Bank.map.get(account);
            if(customer.balance<money) {
                System.out.println("Insufficient Balance");
                System.out.println("Your Balance is "+customer.balance);
            }
            else if(customer.balance-money<1000) {
                System.out.println("Need to maintain Minimum Balance");
                System.out.println("Your balance is "+customer.balance);
            }

            else{
                customer.balance-=money;
                System.out.println("You can collect your money");
                System.out.println("Remaining Balance:"+customer.balance);
            }


        }
        else {
            System.out.println("Your User Id or Password is wrong Please Try again");
        }

    }
    public void deposit(){
        System.out.println("Enter the account id:");
        int account=sc.nextInt();
        System.out.println("Enter the Password:");
        String password=sc.next();
        if (authentication(account,password)){
            System.out.println("enter the amount to deposit");
            int amount=sc.nextInt();
            Customer customer=Bank.map.get(account);
            customer.balance+=amount;
            System.out.println("Your Available Balance is :"+ customer.balance);
        }

    }
    public boolean transfer(){
        System.out.println("Enter your id");
        int account=sc.nextInt();
        System.out.println("Enter your Password:");
        String password=sc.next();
        if (authentication(account,password)){
            System.out.println("Enter the other persons id:");
            int acc2=sc.nextInt();
            Customer customer=Bank.map.get(account);
            System.out.println("Enter the amount:");
            int amount=sc.nextInt();

            Customer customer2=Bank.map.get(acc2);
            if(amount > customer.balance || customer.balance-amount<1000) return false;
            customer.balance-=amount;
            customer2.balance+=amount;
            System.out.println("Your Balance "+customer.balance);
            System.out.println("Your  friends Balance "+customer2.balance);
        }
        else {
            return false;
        }

     return true;
    }

}
