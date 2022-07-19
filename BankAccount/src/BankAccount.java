public class BankAccount {
    private double checking_balance = 0.0;
    private double saving_balance = 0.0;
    private static double totalAmount = 0.0;
    private static int numberOfAccounts = 0;


    public BankAccount(){
        numberOfAccounts ++;

    }

    public void setSaving_balance(double saving_balance) {
        this.saving_balance += saving_balance;
        this.totalAmount += saving_balance;
    }

    public double getSaving_balance() {
        return saving_balance;
    }

    public void setChecking_balance(double checking_balance) {
        this.checking_balance += checking_balance;
        this.totalAmount += checking_balance;
    }

    public double getChecking_balance() {
        return checking_balance;
    }

    public void depositCheck(int amount){
        setChecking_balance(amount);
    }

    public void depositSave(int amount){
        setSaving_balance(amount);
    }

    public void withdrawCheck(int amount){
        if(amount > totalAmount){
            setChecking_balance(-amount);
        } else {
            System.out.println("From Where");
        }
    }

    public double Check(){
        return totalAmount;
    }
}
