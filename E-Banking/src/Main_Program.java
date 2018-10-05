import GUI.*;

/**
 *
 * @author Rashmil.
 */
public class Main_Program {
    public static void main(String[] args){
        //Run the first file i.e. the login page.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                USER_IDENTIFICATION login = new USER_IDENTIFICATION();
                login.setVisible(true);
            }
        });
    }
    
}
