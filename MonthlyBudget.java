package newpackage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MonthlyBudget {
    private double monthlyIncome;
    private double allocatedBudget;

    public MonthlyBudget(double monthlyIncome, double allocatedBudget) {
        this.monthlyIncome = monthlyIncome;
        this.allocatedBudget = allocatedBudget;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getAllocatedBudget() {
        return allocatedBudget;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setAllocatedBudget(double allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }
}

class CuteCharacters {
    public static void cheerOnSavings() {
        System.out.println("🌟 Keep up the good work! Your savings are growing! 🌈");
    }
}

class FinanceManager {
    private List<Transaction> transactions;
    private MonthlyBudget monthlyBudget;
    private Map<String, Double> categoryTotals;
    private double totalIncome;
    private List<String> loans;

    public FinanceManager() {
        this.transactions = new ArrayList<>();
        this.categoryTotals = new HashMap<>();
        this.totalIncome = 0.0;
        this.loans = new ArrayList<>();
    }

    public void setMonthlyBudget(MonthlyBudget monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public void recordDailyExpense(String description, double amount, String category) {
        Transaction transaction = new Transaction(description, amount, category);
        transactions.add(transaction);
        updateCategoryTotals(category, amount);
        CuteCharacters.cheerOnSavings();
    }

    private void updateCategoryTotals(String category, double amount) {
        categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);
    }

    public double calculateBalance() {
        double balance = monthlyBudget.getMonthlyIncome();

        for (Transaction transaction : transactions) {
            balance -= transaction.getAmount();
        }

        return balance;
    }

    public void displayTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void categorizeTransactions() {
        System.out.println("\nCategory-wise Expense Summary:");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println(entry.getKey() + ": Rs " + entry.getValue());
        }
    }

    public void displayExpenseGraph() {
        System.out.println("\nExpense Graph:");

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();
            int stars = (int) (amount / 10); // Adjust for better visualization

            System.out.print(category + ": ");
            for (int i = 0; i < stars; i++) {
                System.out.print("⭐");
            }
            System.out.println();
        }
    }

    public void addIncome(String source, double amount) {
        totalIncome += amount;
        System.out.println("Income source '" + source + "' recorded.");
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void recordLoan(String name, double amount, String reason) {
        loans.add("Name: " + name + " | Amount: Rs" + amount + " | Reason: " + reason + " | Date: " + new Date());
        System.out.println("Loan recorded successfully.");
    }

    public void displayLoans() {
        if (loans.isEmpty()) {
            System.out.println("No loans recorded.");
        } else {
            System.out.println("\nLoans:");
            for (String loan : loans) {
                System.out.println(loan);
            }
        }
    }
}

    
