/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rashmil
 */
abstract class Query {

    static final String
    CREATE =
            (
            "CREATE TABLE IF NOT EXISTS accounts (" +
                    "accountnum INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT UNIQUE NOT NULL," +
                    "first_name varchar(30) NOT NULL, " +
                    "last_name varchar(30) NOT NULL, " +
                    "gender TEXT,"+
                    "nationality TEXT,"+
                    "mobile TEXT,"+
                    "dob DATE NOT NULL, " +
                    "pin INTEGER NOT NULL, " +
                    "balance INTEGER NOT NULL" +
                    ");"
            ),



    ADD =
            (
            "INSERT INTO accounts (username,first_name,last_name,gender,nationality,mobile,dob,pin,balance) VALUES " +
                    "(?,?, ?, ?, ?, ?, ?, ?, ?);"
            ),
            
    ADD1 =  
            (
            "INSERT INTO accounts VALUES" +
                "(1000,?,?,?,?,?,?,?,?,?)"
            ),

    DEL =
            (
            "DELETE FROM accounts WHERE accountnum = ? ;"
            ),

    COUNT =
            (
            "SELECT COUNT(*) FROM accounts;"
            ),
    COUNT_BY_USER = (
                    "SELECT COUNT(*) FROM accounts WHERE username = ? ;"
                    ),        
    EDIT =  (
            "UPDATE accounts " +
                "SET balance = ? " +
                "WHERE username = ? " +
                ";"
            ),
    
    GET =
            (
            "SELECT * FROM accounts WHERE username = ?;"
            );

}
