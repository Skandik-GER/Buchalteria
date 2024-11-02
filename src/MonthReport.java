import java.util.ArrayList;

public class MonthReport {
    ArrayList <Transaction> transactions = new ArrayList<>();


    void printReports() {
        // Yellow
        // Неудачное название для переменной итерирования по транзакциям
        // Это же одна транзакция, соотвественно, можно просто Transaction transaction : ...
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
