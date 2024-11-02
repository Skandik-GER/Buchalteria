// RED+
// Лишние комментарии необходимо удалить
import java.util.Scanner;
// RED+
// Неиспользуемые импорты необходимо удалить

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportsManager = new ReportManager();

        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                reportsManager.readAllReportsMonth();
                System.out.println("Files was read");
            }else if (command == 2){
                reportsManager.readAllReportsYear();
                System.out.println("Files was read");
            } else if (command == 3) {
                if(reportsManager.checkMonth(command) && reportsManager.checkYear(command)){
                    reportsManager.sums();
                }else{
                    System.out.println("You don't read files,old ass");
                }
            } else if (command == 4) {
                // RED+1
                // Пользователь может вызвать 4 команду до того, как отчеты считаны
                if(reportsManager.checkMonth(command)){
                    reportsManager.printMonthReports();
                }else{
                    System.out.println("You don't read files,dumb ass");
                }
            } else if (command == 5){
                // RED+
                // Пользователь может вызвать 5 команду до того, как отчеты считаны
                if(reportsManager.checkYear(command)){
                    reportsManager.printYearReport();
                }else{
                    System.out.println("You don't read files,dumb ass");
                }
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
        System.out.println("6 - Ciao,Adios,Poka,Bye,Exit");

    }

}