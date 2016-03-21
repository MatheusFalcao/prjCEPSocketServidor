package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteJDBC {
	
	private Connection c = null;
	java.sql.Statement stmt = null;
	
	public boolean conecta(){
    try {
      Class.forName("org.sqlite.JDBC");
      this.c = DriverManager.getConnection("jdbc:sqlite:cep.db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return true;
    //System.out.println("Opened database successfully");
   }
	
	public boolean exec(String query){
		
		try {
			stmt = c.createStatement();
			stmt.executeQuery(query);
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return true;
	}
 }
