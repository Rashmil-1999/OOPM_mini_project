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
    private  final String name,last_name,DoB;
    final int pinNum;
    int Balance;
    
   //constructor that initializes the default parameters on an account with initial balance as 0 
   public AccountModel(String name,String last_name,String DoB,int pin){
       this.name = name;
       this.last_name = last_name;
       this.DoB = DoB;
       this.pinNum = pin;
       this.Balance = 0;
   }
   
   //mehtods deposit withdraw and transfer
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
       if(this.ValidTransaction(amt)){
           this.Balance -= amt;
           target.Balance += amt;
       }
       else{
           //raise custom exception
       }
   }
   
   
    
}
