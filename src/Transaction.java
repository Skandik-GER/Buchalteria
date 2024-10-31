public class Transaction {
    String name;
    boolean isExpense;
    int quantity;
    double unitPrice;


    Transaction(String name,boolean isExpense, int quantity,double unitPrice){
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    void print(){
        System.out.println("Name item - " + name);
        System.out.println("Quantity - " + quantity);
        System.out.println("Price - " + unitPrice);
        System.out.println("Buy or sell - " + isExpense);
    }
}
