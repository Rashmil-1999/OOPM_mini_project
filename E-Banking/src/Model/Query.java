/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author manojleena
 */
abstract class Query {

    static final String
    CREATE =
            (
            "CREATE TABLE IF NOT EXISTS accounts (" +
                    "accountnum INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "first_name varchar(30) NOT NULL, " +
                    "last_name varchar(30) NOT NULL, " +
                    "dob DATE NOT NULL, " +
                    "pin INTEGER NOT NULL, " +
                    "balance INTEGER NOT NULL" +
                    ");"
            ),



    ADD =
            (
            "INSERT INTO accounts (first_name,last_name,dob,pin,balance) VALUES " +
                    "(?, ?, ?, ?, ?);"
            ),
            
    ADD1 =  
            (
            "INSERT INTO accounts VALUES" +
                    "(1000,?,?,?,?,?)"
            ),

    DEL =
            (
            "DELETE FROM accounts WHERE accountnum = ? ;"
            ),

    COUNT =
            (
            "SELECT COUNT(*) FROM accounts;"
            ),

    GET =
            (
            "SELECT * FROM accounts WHERE accountnum = ?;"
            );

}
