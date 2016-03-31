package controle;

import java.io.IOException;

import modelo.MySql;

public class ProgramaServidor {
	public static void main(String[] args) throws IOException {
		System.out.println("Servidor Ativo e esperando por requisições");
		new ServidorCep();
		
	}

}
