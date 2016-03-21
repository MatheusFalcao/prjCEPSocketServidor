package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.SqliteJDBC;


public class ServidorCalculadora {
	private ServerSocket sckServidor;

	public ServidorCalculadora() throws IOException {
		this.sckServidor = new ServerSocket(4000);
		for (;;) {
			Socket requisicao = this.sckServidor.accept();

			InputStream canalDeEntrada;
			OutputStream canalDeSaida;
			BufferedReader entrada;
			PrintWriter saida;
			
			

			try {
				canalDeEntrada = requisicao.getInputStream();
				canalDeSaida = requisicao.getOutputStream();
				entrada = new BufferedReader(new InputStreamReader(canalDeEntrada));
				saida = new PrintWriter(canalDeSaida, true);
				saida.println("Requisição Aceita pelo Servidor");
				while (true) {
					//recebe o numero do CEP enviado pela Aplicação Cliente
					String linhaDoPedido = entrada.readLine();
					if (linhaDoPedido == null || linhaDoPedido.length() == 0){
						break;
					}
					
					saida.println("Resultado da sua operação: ");
				}
				requisicao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
