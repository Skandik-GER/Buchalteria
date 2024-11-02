import java.util.ArrayList;

public class ReportManager {
    MonthReport[] monthReports = new MonthReport[3];
    YearlyReport yearlyReport = new YearlyReport();
    FileReader fileReader = new FileReader();
    ReportManager(){
        for (int i = 0; i < monthReports.length; i++){
            monthReports[i] = new MonthReport();
        }
    }



    void readAllReportsMonth() {
        readReportMonth(0, "m.202101.csv");
        readReportMonth(1, "m.202102.csv");
        readReportMonth(2, "m.202103.csv");

    }

    void readAllReportsYear(){
        readReportYear("y.2021.csv");
    }

    void printMonthReports(){
        // Yellow
        // Код жестко ограничен на эти три месяца,
        // что нехорошо может сказаться при масштабировании проекта
        int month = 1;
        for (MonthReport report : monthReports) {
            if (month == 1) {
                String months = "January";
                System.out.println(months);
                report.printReports();
            }
            System.out.println("-----------------------------------------------------------");
            month++;
            if (month == 2) {
                String months = "February";
                System.out.println(months);
                report.printReports();
            }
            if (month == 3) {
                String months = "March";
                System.out.println(months);
                report.printReports();
            }
        }
    }

    void printYearReport(){
        yearlyReport.printReportsYear();

    }

    void sums(){
        int monthNumber = -1;
        for(int i = 0;i < monthReports.length;i++){
            if(monthReports[i].sumMonth(true) != yearlyReport.sumYear(i + 1,true)){
                monthNumber = i;
            }
            if(monthReports[i].sumMonth(false) != yearlyReport.sumYear(i + 1,false)){
                monthNumber = i;
            }
            // RED
            // Некорректно происходит проверка данных после первого месяца
            // Получается, что если в первом все ок, то мы сразу печатаем успех и прерываем цикл
            // Остальные месяцы просто не проверяются
            if(monthNumber == -1){
                System.out.println("Check is successful");
                break;
            }else{
                System.out.println("Check failed " + "Month: " + (monthNumber + 1));
            }
            // RED
            // Мы до этого условия никогда не сможем дойти,
            // тк сверху при monthNumber == -1 делаем break
            if(monthNumber == -1){
                System.out.println("Check is successful");
            }

        }

    }


    void readReportMonth(int monthNumber, String fileName){
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        MonthReport monthReport = monthReports[monthNumber];
        for (int i = 1; i < lines.size(); i++){
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            String name = lineContents[0];
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            double unitPrice = Double.parseDouble(lineContents[3]);
            Transaction transaction = new Transaction(name,isExpense,quantity, unitPrice);
            monthReport.transactions.add(transaction);
        }

    }
    void readReportYear(String fileName){
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        for (int i = 1;i < lines.size();i++){
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            int month = Integer.parseInt(lineContents[0]);
            double amount = Integer.parseInt(lineContents[1]);
            boolean isExpenseYear = Boolean.parseBoolean(lineContents[2]);
            TransactionYear transactionYear = new TransactionYear(month,amount,isExpenseYear);
            yearlyReport.transactionsYear.add(transactionYear);
        }
    }
    boolean checkYear(int command) {
        return !yearlyReport.transactionsYear.isEmpty();
    }
    boolean checkMonth(int command){
        for(MonthReport monthReport: monthReports){
            if(monthReport.transactions.isEmpty()){
                return false;
            }
        }
        return true;
    }
}

