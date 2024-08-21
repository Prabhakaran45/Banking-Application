import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {

   public  static List<Customer> list=new ArrayList<>();
   public static HashMap<Integer,Customer> map=new HashMap<>();
   public static int refCustomerId;
   public static long refCustomerAccount;
   public static final double INITIAL_BALANCE=1000;
}
