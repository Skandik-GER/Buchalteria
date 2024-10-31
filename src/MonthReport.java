import java.util.ArrayList;

public class MonthReport {
    ArrayList <Transaction> transactions = new ArrayList<>();


    void printReports() {
        for (Transaction transactions1: transactions ){
            transactions1.print();
        }
    }
    double sumMonth(boolean isExpense){
        double sum = 0;
        for (Transaction transaction: transactions ){
            if (transaction.isExpense == isExpense){
                sum += transaction.quantity * transaction.unitPrice;
            }
        }
        return sum;
    }
}
