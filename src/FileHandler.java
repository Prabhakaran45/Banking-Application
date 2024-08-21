import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private static final String fileName="src\\bank_db.txt";

    public void initializer() throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader(fileName));
        String customerInfo=bf.readLine();
        while(customerInfo !=null) {
            Customer customerDetails=castStringToCustomer(customerInfo);
            Bank.list.add(customerDetails);
            Bank.map.put(customerDetails.accountId,customerDetails);
            customerInfo = bf.readLine();
        }
        int size=Bank.list.size();
        Bank.refCustomerId=Bank.list.get(size-1).accountId;
        Bank.refCustomerAccount=Bank.list.get(size-1).accountNumber;
       bf.close();

    }
    private Customer castStringToCustomer(String customerInfo){
        List<String> split= Arrays.asList(customerInfo.split(" "));
        Customer customer=new Customer(
           Integer.parseInt(split.get(0)),
           Long.parseLong(split.get(1)),
           split.get(2),
           Long.parseLong(split.get(3)),
           split.get(4)
        );
        return customer;
    }

}
