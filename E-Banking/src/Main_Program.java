/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI.*;

/**
 *
 * @author manojleena
 */
public class Main_Program {
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                USER_IDENTIFICATION login = new USER_IDENTIFICATION();
                login.setVisible(true);
            }
        });
    }
    
}
