//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportsManager = new ReportManager();

        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                reportsManager.readAllReportsMonth();
            }else if (command == 2){
                reportsManager.readAllReportsYear();
            } else if (command == 3) {
                if(reportsManager.checkMonth(command) && reportsManager.checkYear(command)){
                    reportsManager.sums();
                }else{
                    System.out.println("You don't read files");
                }
            } else if (command == 4) {
                reportsManager.printMonthReports();
            } else if (command == 5){
                reportsManager.printYearReport();
            } else if (command == 6){
                break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию обо всех месячных отчетах");
        System.out.println("5 - Вывести информацию о новогоднем отчете");
        System.out.println("6 - Adios");

    }

}