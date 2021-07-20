
package ClassesDados;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;

public class ConexaoDB {
    static ResultSet resultado;
    static PreparedStatement comando;
    static CallableStatement cs;    
    static Connection con = null;
    static Statement stm = null;
    
    public ConexaoDB(){
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=thecloset;user=Administrador;password=admin";

        try{
            con = DriverManager.getConnection(connectionURL);
            stm = con.createStatement();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

