package model;

public class Payment {
    private int paymentId;
    private String paymentName;
    private double balance;

    public Payment(int paymentId, String paymentName, double balance) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentName='" + paymentName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
