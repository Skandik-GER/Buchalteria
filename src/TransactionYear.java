public class TransactionYear {
    int month;
    double amount;
    boolean isExpenseYear;
    TransactionYear(int month, double amount, boolean isExpenseYear){
        this.month = month;
        this.amount = amount;
        this.isExpenseYear = isExpenseYear;
    }

    void print() {
        System.out.println("Month - " + month);
        System.out.println("Amount - " + amount);
        System.out.println("Buy or Sell - " + isExpenseYear);
    }

}
