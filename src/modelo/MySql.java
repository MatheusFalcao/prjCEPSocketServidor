package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql {
	
	private Connection c = null;
	java.sql.Statement stmt = null;
	
	public boolean conecta(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.c = DriverManager.getConnection("jdbc:mysql://localhost/cep" , "root", "mayatavolcomstone22");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return true;
    //System.out.println("Opened database successfully");
   }
	
	public String[] exec(String cep){
		ResultSet rs = null;
		String[] dados = new String[4];
		try {
			conecta();
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * from log_logradouro where cep = "+cep);
			while(rs.next()){
				dados[0] = rs.getString("cep");
				dados[1] = rs.getString("log_nome");
				dados[2] = rs.getString("ufe_sg");
				dados[3] = rs.getString("log_tipo_logradouro");
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return dados;
	}
 }
