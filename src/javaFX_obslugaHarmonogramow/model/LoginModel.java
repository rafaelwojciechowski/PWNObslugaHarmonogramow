package javaFX_obslugaHarmonogramow.model;




import java.sql.Connection;
import java.sql.DriverManager;

    public class LoginModel {

        Connection conn=null;
        public static Connection ConnectDB() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://fk.edu.pl/fkedupl_pwngr", "fkedupl_pwn", "pWn20180527");
                System.out.println("Połączono");
                return conn;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

    }

