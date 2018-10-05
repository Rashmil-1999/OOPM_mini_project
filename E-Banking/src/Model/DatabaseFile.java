package Model;

import java.sql.*;

/**
 *
 * @author Rashmil
 */
public class DatabaseFile {
    //preparedstatements
    private PreparedStatement 
            create_stm,
            add_stm,
            add1st_stm,
            del_stm,
            get_stm,
            count_byUsername,
            update_stm,
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
            count_byUsername = conn.prepareStatement(Query.COUNT_BY_USER);
            update_stm = conn.prepareStatement(Query.EDIT);
            
        }catch ( SQLException e ) {
            e.printStackTrace();
            System.exit(0);
        }
    }
     /**
     *
     * @param username
     * @param name
     * @param last_name
     * @param gender
     * @param nationality
     * @param mobile
     * @param dob
     * @param pin
     * @param balance
     */
    public void add(String username,String name,String last_name,String gender,String nationality,String mobile,String dob,int pin,int balance){
           try{
               add_stm.setString(1,username);
               add_stm.setString(2,name);
               add_stm.setString(3,last_name);
               add_stm.setString(4,gender);
               add_stm.setString(5,nationality);
               add_stm.setString(6,mobile);
               add_stm.setString(7,dob);
               add_stm.setInt(8, pin);
               add_stm.setInt(9, balance);
               add_stm.executeUpdate();
           }catch(SQLException e){
               e.printStackTrace();
           }
    } 
    
    public void add1st(String username,String name,String last_name,String gender,String nationality,String mobile,String dob,int pin,int balance){
        try{
               add1st_stm.setString(1,username); 
               add1st_stm.setString(2,name);
               add1st_stm.setString(3,last_name);
               add1st_stm.setString(4, gender);
               add1st_stm.setString(5,nationality);
               add1st_stm.setString(6, mobile);
               add1st_stm.setString(7,dob);
               add1st_stm.setInt(8, pin);
               add1st_stm.setInt(9, balance);
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
    
    public AccountModel getAccount(String username){
        try{
            get_stm.setString(1, username);
            ResultSet rs = get_stm.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String nationality = rs.getString("nationality");
                String mobile = rs.getString("mobile");
                String dob = rs.getString("dob");
                int pin = rs.getInt("pin");
                int balance = rs.getInt("balance");
                int accountnum = rs.getInt("accountnum");
            
                return new AccountModel(username,name,last_name,gender,nationality,mobile,dob,pin,balance,accountnum);    
            }
            else{
                return new AccountModel("","","","","","","",-1,-1,-1);
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int count(){
        int cnt = 0;
        
        try{
            ResultSet rs = count_stm.executeQuery();
            cnt = rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return cnt;
    }
    public boolean validateInsert(String username){
        int cnt = 0;
        
        try{
            count_byUsername.setString(1,username);
            ResultSet rs = count_byUsername.executeQuery();
            cnt = rs.getInt(1);
            if(cnt == 0){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    public void updateBalance(int newbal,String username){
        try{
            update_stm.setInt(1, newbal);
            update_stm.setString(2,username);
            update_stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
}
