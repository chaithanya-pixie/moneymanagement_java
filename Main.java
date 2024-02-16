package newpackage;


import java.util.*;
public class Transaction {
    private String description;
    private double amount;
    private String category;

    public Transaction(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Transaction: " + description + " | Amount: Rs " + amount + " | Category: " + category;
    }
}
