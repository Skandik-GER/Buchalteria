import java.util.ArrayList;

public class YearlyReport {
    ArrayList <TransactionYear> transactionsYear = new ArrayList<>();

    void printReportsYear() {
        for (TransactionYear transaction: transactionsYear ){
            transaction.print();
        }
    }

    double sumYear(int month,boolean isExpense){
        for(TransactionYear transactionYear:transactionsYear){
            if(transactionYear.isExpenseYear == isExpense && transactionYear.month == month){
                return transactionYear.amount;
            }
        }
        return  0;
    }
}
