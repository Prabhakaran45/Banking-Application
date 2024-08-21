import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {
    List<Customer> list=new ArrayList<>();
    private static final String fileName="src\\bank_db.txt";
    public void initializer() throws IOException {
        File file=new File(fileName);
        BufferedReader bf=new BufferedReader(new FileReader(file));
        String customerInfo=bf.readLine();
        int position=0;

        do {
            list.add(castStringToCustomer(customerInfo));
            customerInfo= bf.readLine();
        }
        while(customerInfo !=null);
        Bank.list=list;
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
