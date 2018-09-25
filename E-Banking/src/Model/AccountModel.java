/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ra-Pr-Ri
 */
public class AccountModel {
    private  final String first_name,last_name,DoB;
    final int pin,accountnum;
    int Balance;
    
   //constructor that initializes the default parameters on an account with initial balance as 0 
   public AccountModel(String name,String last_name,String DoB,int pin,int accountnum){
       this.first_name = name;
       this.last_name = last_name;
       this.DoB = DoB;
       this.pin = pin;
       this.accountnum = accountnum;
       this.Balance = 0;
   }
   
    /**
     *
     * @param name
     * @param last_name
     * @param DoB
     * @param pin
     * @param balance
     */
    public AccountModel(String name,String last_name,String DoB,int pin ,int balance ,int accountnum){
        this.pin = pin;
        this.Balance = balance;
        this.first_name = name;
        this.last_name = last_name;
        this.DoB = DoB;
        this.accountnum = accountnum ;
   }
   
   //getter functions
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
   
   //methods of deposit withdraw and transfer
   void deposit(int amt){
       this.Balance +=amt;
   }
   
   boolean ValidTransaction(int amt){
       if (this.Balance > amt){
           return true;
       }
       else{
           return false;
       }
   }
   void withdraw(int amt){
       this.Balance -= amt;
   }
   
   void transfer(AccountModel target,int amt){
           this.Balance -= amt;
           target.Balance += amt;
   }
   
   
    
}
