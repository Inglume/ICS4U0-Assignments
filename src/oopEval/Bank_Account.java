package oopEval;

public class Bank_Account {

  private long acct_num;
  private double balance;
  private String type;
  private float interest_rate;

  public Bank_Account(long acct, double bal, String ty, float interest) {
    acct_num = acct;
    balance = bal;
    type = ty;
    interest_rate = interest;
  }

  public double getBalance() {
    return balance;
  }

  public String getType() {
    return type;
  }

  public void deposit(double amt) {
    if (amt >= 0) {
      balance += amt;
    }
  }

  public boolean withdrawal(double amt) {
    if (amt < 0) {
      return false;
    } else if (amt <= balance) {
      balance -= amt;
      return true;
    }
    return false;
  }

  public void applyInterest() {
    balance *= 1 + interest_rate;
  }
} // Bank_Acccount class
