/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author manojleena
 */
public class DatabaseFile {
    //preparedstatements
    private PreparedStatement 
            create_stm,
            add_stm,
            add1st_stm,
            del_stm,
            get_stm,
            count_stm;
    public DatabaseFile(){
        Connection conn;
        try {
          
            conn = DriverManager.getConnection("jdbc:sqlite:account.db");
            
            create_stm = conn.prepareStatement(Query.CREATE);
            create_stm.executeUpdate();
            
            add_stm = conn.prepareStatement(Query.ADD);
            add1st_stm = conn.prepareStatement(Query.ADD1);
            del_stm = conn.prepareStatement(Query.DEL);
            get_stm = conn.prepareStatement(Query.GET);
            count_stm = conn.prepareStatement(Query.COUNT);
            
        }catch ( SQLException e ) {
            e.printStackTrace();
            System.exit(0);
        }
    }
     /**
     *
     * @param name
     * @param last_name
     * @param dob
     * @param pin
     * @param balance
     */
    public void add(String name,String last_name,String dob,int pin,int balance){
           try{
               add_stm.setString(1,name);
               add_stm.setString(2,last_name);
               add_stm.setString(3,dob);
               add_stm.setInt(4, pin);
               add_stm.setInt(5, balance);
               add_stm.executeUpdate();
           }catch(SQLException e){
               e.printStackTrace();
           }
    } 
    
    public void add1st(String name,String last_name,String dob,int pin,int balance){
        try{
               add1st_stm.setString(1,name);
               add1st_stm.setString(2,last_name);
               add1st_stm.setString(3,dob);
               add1st_stm.setInt(4, pin);
               add1st_stm.setInt(5, balance);
               add1st_stm.executeUpdate();
        }catch(SQLException e){
               e.printStackTrace();
        }
    }
    
    public void delete(int acc_num){
        try{
            del_stm.setInt(1, acc_num);
            del_stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public AccountModel getAccount(int acc_num){
        try{
            get_stm.setInt(1, acc_num);
            ResultSet rs = get_stm.executeQuery();
            
            String name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String dob = rs.getString("dob");
            int pin = rs.getInt("pin");
            int balance = rs.getInt("balance");
            int accountnum = rs.getInt("accountnum");
            
            return new AccountModel(name,last_name,dob,pin,balance,accountnum);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public int count(){
        int cnt = 0;
        
        try(ResultSet rs = count_stm.executeQuery()){
            cnt = rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return cnt;
    }
}
