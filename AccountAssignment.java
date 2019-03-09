public class AccountAssignment {
    public static void main(String[]args){
        //test class Account
        Account A1=new Account("James","Smith",5000);
        A1.DebitTransaction(645.15);
        System.out.println(A1);
        A1.CreditTransaction(1987.26);
        System.out.println(A1);
        //test class CheckingAccount
        CheckingAccount CA1=new CheckingAccount("Bill","Wilson",50);
        CA1.DebitTransaction(10.01);
        System.out.println(CA1);
        CA1.CreditTransaction(1000.66);
        System.out.println(CA1);


    }
}

class Account{
    //data members
    protected String FirstName;
    protected String LastName;
    double CurBalance;

    //constructor
    public Account(String FirstName,String LastName,double CurBalance){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.CurBalance=CurBalance;
    }

    public String getAcctType(){
        return this.getClass().getName();
    }

    public double DebitTransaction(double debitAmount){
        this.CurBalance-=debitAmount;
        return this.CurBalance;
    }

    public double CreditTransaction(double creditAmount){
        this.CurBalance+=creditAmount;
        return this.CurBalance;
    }

    public String toString(){
        return "Account Name: "+FirstName+" "+LastName+" ,Account Type: "+getAcctType()+
                String.format(", Balance: $ %.2f",CurBalance);
    }
}

class CheckingAccount extends Account{
    //pre-set minimum balance and pre-set penalty fee
    static double minBalance=100;
    static double penaltyFee=25;

    public CheckingAccount(String fname,String lname,double cb){
        super(fname,lname,cb);

    }

    public double DebitTransaction(double debitAmount){
        super.DebitTransaction(debitAmount);
        this.ChargeFee();
        return super.CurBalance;

    }

    public double CreditTransaction(double creditAmount){
        super.CreditTransaction(creditAmount);
        this.ChargeFee();
        return super.CurBalance;

    }

    private void ChargeFee(){
        if (this.CurBalance<=this.minBalance){
            this.CurBalance-=penaltyFee;
        }
    }
}