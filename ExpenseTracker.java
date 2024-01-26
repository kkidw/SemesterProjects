import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;



public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in); //allow user input
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses(); //array to hold expense entries
        ArrayList<Income> incomes = IncomeStorage.loadIncome(); //array to hold income entries

        while (true) { //switch statement to allow user to select options from menu
            out.println("\nBudget Tracker Menu:");
            out.println("1. Add Expense");
            out.println("2. View Expenses");
            out.println("3. Exit");
            out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) { //switch statement for more options after first selection from menu
                case 1 -> {
                    out.print("Please enter the date (MM/DD/YYYY): ");
                    String date = scanner.next();
                    scanner.nextLine();
                    out.print("Please enter the description: ");
                    String desc = scanner.nextLine();
                    out.print("Please enter the amount: ");
                    double amount = scanner.nextDouble();
                    out.print("Is this a reoccurring expense?: ");
                    scanner.nextLine();
                    String reoccurring;
                    reoccurring = null;
                    expenses.add(new Expense(date, desc, amount));
                    ExpenseStorage.saveExpenses(expenses);

                }
                case 2 -> {
                    for (Expense e : expenses) {
                        out.println(e);
                    }
                }
                case 3 -> {
                    out.println("Goodbye!");
                    return;
                }



                default -> throw new IllegalStateException("Unexpected value: " + choice);// error message if user selects option not on menu
            }
    }
}

class IncomeTracker {
    public static void main(String[] args) {

    }


    }

    Scanner input = new Scanner(System.in);
}
