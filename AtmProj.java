import java.util.*;
import java.sql.*;
import allaboutatmproject2.*;
class BankAdo {
    Scanner scan = new Scanner(System.in);
    boolean flag = false;
    boolean q=false;
    Connection con;
    String name,password;
    boolean mainVerf() {
        try {
            System.out.println("enter name:");
            name=scan.nextLine();
            System.out.println("enter password:");
            password=scan.nextLine();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", name, password);
            return true; // You should return true here if the connection is successful
        } catch (ClassNotFoundException e) {
            System.out.println("Make proper connection");
            return false;
        } catch (SQLException e) {
            System.out.println("No user found!");
            return false;
        }
    }

    boolean a() {
        try{
            while(true){
                int a = 34;
        int b = a * new Random().nextInt(100);
        if( b>999 && b<9999){
        String s = Integer.toString(b);
        System.out.println("Your OTP: " + s);
        System.out.println("Enter OTP:");
        String val=scan.nextLine();
        if (s.equals(val)) {
            flag = true;
            return true;
        }
        break;
        }
            }
        }
        catch(InputMismatchException e){
            System.out.println("enter valid data");
        }
        return false;
    }

    boolean b() {
        while (true) {
            boolean c = a();
            if (c) {
                q=true;
                return true;
            } else {
                try{
                System.out.println("invalid otp Resend OTP ?:\n1. Yes\n2. No");
                String n = scan.nextLine();
                String v="1";
                if (n.equals(v)) {
                    continue;
                } else {
                    q=false;
                    return false;
                }
                }
                catch(InputMismatchException e){
                    System.out.println("select valid choice!");
                    return false;
                }
            }
        }
    }

    boolean OtpVerf() {
        boolean b = mainVerf();
        if (b) {
            System.out.println("you are connected..");
            return b();
        } else {
            System.out.println("connection falid");
            return false;
        }
    }
    void vrf() {
        try{
        PreparedStatement pst;
     if(q){
       System.out.println("otp is vallid");
       while(true){
       System.out.println("\nchoice any one of below");
       System.out.println("\n1.checkbal\n2.add amount\n3.withdrawt\4.print statement\n5.exit");
       int ch=scan.nextInt();
       switch(ch){
        case 1:
            System.out.println("---------status:checking balance--------");
            pst=con.prepareStatement("select sal from account");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
        System.out.println("\t "+rs.getString("sal")+"\t|");
       }
            break;
       case 2:
        System.out.println("----------status:add amount-----------");
        pst=con.prepareStatement("insert into account(sal) values(?)");
        ResultSet f=pst.executeQuery();
        int a=scan.nextInt();
        int b=(int)f.getInt("sal")+a;
        pst.setInt(1,b);
        int r=pst.executeUpdate();
        break;
        case 3:
            
       case 5:
        System.out.println("visit again ");
        System.exit(0);
        break;
       }
     }
     }
     else{
        System.out.println("no");
     }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        }
}
class AtmProj {
    public static void main(String ar[]) {
        BankAdo v = new BankAdo();
        boolean result = v.OtpVerf();
        if(result){
            v.vrf();
        }
        else{
            System.out.println("Thank-Q welcome again...");
        }
        
    }
}
