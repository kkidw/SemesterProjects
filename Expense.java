public record Expense(String date, String description, double amount) {

    @Override
    public String date() {
        String date1 = date;
        String date11 = date1;
        return date11;
    }

    @Override
    public String toString() {
        return "Expense(date=" + date + ", description=" + description + ", amount=" + amount;
    }
}
