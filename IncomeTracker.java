import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


import static java.lang.System.in;
import static java.lang.System.out;

public class IncomeTracker {
    private static String date;

    public static void main(String[] args) {
        ArrayList<Income> incomes = new ArrayList<>();//array to hold income list
        InputStream in2 = in;
        Scanner scanner = new Scanner(in2);

        while (true) { //switch statement to allow user to select from menu
            System.out.println("\nBudget Tracker Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. View Income Amounts");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) { //switch statement for more options after first selection from menu
                case 1 -> {
                    System.out.print("Please enter the date (MM/DD/YYYY): ");
                    String date = scanner.next();
                    scanner.nextLine();
                    out.print("Please enter the description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Please enter the amount: ");
                    double amount = scanner.nextDouble();
                    incomes.add(new Income(date, desc, amount));
                    IncomeStorage.saveIncomes(incomes);
                }
                case 2 -> {
                    for (Income e : incomes) {
                        System.out.println(e);
                    }
                }

                default -> throw new IllegalStateException("Unexpected value: " + choice);// error message if user selects option not on menu
            }
        }
    }
}


