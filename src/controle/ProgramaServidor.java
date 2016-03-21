package controle;

import java.io.IOException;

import modelo.SqliteJDBC;

public class ProgramaServidor {
	public static void main(String[] args) throws IOException {
		//new ServidorCalculadora();
		
		SqliteJDBC bd = new SqliteJDBC();
		if(bd.conecta()){
			System.out.println("SUCESSO!");
		}
	}

}
