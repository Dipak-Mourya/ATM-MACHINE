import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String args[]) {
        ATMop obj = new ATMop();
        obj.op();
    }
}

class Data {
    float balance;
}

class ATMop // to perform all operation
{
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();// pincode and object of class data

    ATMop() {
        System.out.println("*********************************************************************");
        System.out.println("Welcome to our ATM");
        op();
    }

    public void op() {
        System.out.println("*********************************************************************\n");
        System.out.println("Enter your PINCODE:");
        int pincode = sc.nextInt();
        if (map.containsKey(pincode) == true) {
            Data obj = map.get(pincode);
            menu(obj);
        } else {
            System.out.println("*********************************************************************");
            System.out.println("Please create Account First");
            System.out.println("set your pincode:");
            int pin = sc.nextInt();
            Data obj = new Data();
            map.put(pin, obj);
            menu(obj);
        }

    }

    public void menu(Data obj) {
        System.out.println("*********************************************************************");
        System.out.println("PLEASE ENTER VALID NUMBER");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Another Account");
        System.out.println("5. Exit");

        int x = sc.nextInt();

        if (x == 1) {
            check_balance(obj);
        } else if (x == 2) {
            Deposit(obj);
        } else if (x == 3) {
            withdraw(obj);
        } else if (x == 4) {
            op();
        } else if (x == 5) {
            System.out.println("Thank you !!");
        } else {
            System.out.println("Enter valid number");
            menu(obj);
        }
    }

    public void check_balance(Data obj) {
        System.out.println("Your Balance:" + obj.balance);
        System.out.println("*********************************************************************");
        menu(obj);
    }

    public void Deposit(Data obj) {
        System.out.println("Enter your amount you want to deposit");
        float a = sc.nextFloat();
        obj.balance = obj.balance + a;
        System.out.println("Amount Deposited Successfully");
        System.out.println("*********************************************************************");
        menu(obj);

    }

    public void withdraw(Data obj) {
        System.out.println("Enter the amount you want to withdraw:");
        float a = sc.nextFloat();
        if (obj.balance >= a) {
            obj.balance = obj.balance - a;
            System.out.println("Amount Withdarw Successfully");
        } else {
            System.out.println("Not sufficient Balance");
        }

        System.out.println("*********************************************************************");
        menu(obj);
    }
}