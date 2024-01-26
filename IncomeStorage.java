import java.io.*;
import java.util.ArrayList;

public class IncomeStorage {

        private static final String FILENAME = "incomes.txt";

    public static ArrayList<Income> loadIncome() { //array to display income entries
            ArrayList<Income> incomes = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    incomes.add(new Income(parts[0], parts[1], Double.parseDouble(parts[2])));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return incomes;
        }

    public static void saveIncomes(ArrayList<Income> incomes) { //holds income entries
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
                for (Income e : incomes) {
                    writer.println(e.date() + "," + e.description() + "," + e.amount());
                }
            } catch (IOException e) {
                System.out.println("Error saving incomes: " + e.getMessage());
            }
        }
    }


