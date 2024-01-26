import java.io.*;
import java.util.ArrayList;

public class ExpenseStorage {
    private static final String FILENAME = "expenses.txt";

    public static void saveExpenses(ArrayList<Expense> expenses) { //array to hold expense entries
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Expense e : expenses) {
                writer.println(e.date() + "," + e.description() + "," + e.amount());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public static ArrayList<Expense> loadExpenses() { //array to display expense entries
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                boolean add = expenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expenses;
    }
}
