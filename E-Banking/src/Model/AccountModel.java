package Model;

/**
 *
 * @author Rashmil
 */
public class AccountModel {
    private  final String first_name,last_name,DoB,gender,nationality,mobile,username;
    final int pin,accountnum;
    int Balance;
  
    /**
     *
     * @param username
     * @param name
     * @param last_name
     * @param gender
     * @param nationality
     * @param mobile
     * @param DoB
     * @param pin
     * @param balance
     * @param accountnum
     */
    public AccountModel(String username,String name,String last_name,String gender,String nationality,String mobile,String DoB,int pin ,int balance ,int accountnum){
        this.username = username;
        this.pin = pin;
        this.Balance = balance;
        this.first_name = name;
        this.last_name = last_name;
        this.DoB = DoB;
        this.accountnum = accountnum ;
        this.gender = gender;
        this.mobile = mobile;
        this.nationality = nationality;
   }
   
   //getter functions
    public String getUsername(){
        return this.username;
    }
   public String getName(){
       return this.first_name;
   }
   public String getLastName(){
       return this.last_name;
   }
   public String getDoB(){
       return this.DoB;
   }
   public int getPIN(){
       return this.pin;
   }
   public int getAccNum(){
       return this.accountnum;
   }
   public int getBalance(){
       return this.Balance;
   }
   public String getGender(){
       return this.gender;
   }
   public String getNationality(){
       return this.nationality;
   }
   public String getMobile(){
       return this.mobile;
   }
   
   //methods of deposit withdraw and transfer
   public void deposit(int amt){
       this.Balance +=amt;
   }
   
   public boolean ValidTransaction(int amt){
       if (this.Balance > amt){
           return true;
       }
       else{
           return false;
       }
   }
   public void withdraw(int amt){
       this.Balance -= amt;
   }
}
