package oopex2;

/**
 * The Account represents a bank account which can make withdrawals, deposits, and calculate
 * interest.
 * 
 * @author Nicholas Glenn
 */
public class Account {

  private long account;
  private String type;
  private double balance;
  private float interestRate;

  /**
   * Default constructor for the {@link Account}.
   * 
   * @param acct The account number to create.
   * @param typ The account type to create.
   * @param bal The starting balance of the account.
   */
  public Account(long acct, String typ, double bal) {
    account = acct;
    type = typ;
    balance = bal;
    interestRate = 0.0f;
  }

  /**
   * Updates the balance by adding the interest accrued from the previous balance.
   */
  public void calcInterest() {
    balance = (1 + interestRate) * balance;
  }

  /**
   * Makes a withdrawal from this {@link Account}.
   * 
   * @param amt The amount to withdraw.
   * @return boolean - If the withdrawal was successful or not.
   */
  public boolean withdraw(double amt) {
    if (amt < 0) {
      return false;
    } else if (amt <= balance) {
      balance -= amt;
      return true;
    }
    return false;
  }

  /**
   * Makes a deposit into this {@link Account}.
   * 
   * @param amt The amount to deposit.
   */
  public void deposit(double amt) {
    if (amt >= 0) {
      balance += amt;
    }
  }

  /**
   * Gets the balance.
   * 
   * @return double - The balance.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Get the account number.
   * 
   * @return long - Gets the account number.
   */
  public long getAccount() {
    return account;
  }

  /**
   * Get the account type.
   * 
   * @return String - The account type.
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the interest rate for the account.
   * 
   * @param i The interest rate.
   */
  public void setInterestRate(float i) {
    interestRate = i;
  }
}
