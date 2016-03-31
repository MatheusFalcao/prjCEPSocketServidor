package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Endereco;


public class ServidorCep {
	private ServerSocket sckServidor;

	public ServidorCep() throws IOException {
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
				saida.println("Requisição foi Aceita pelo Servidor e o resultado está sendo processado");
				saida.println(" ");
				saida.println(" ");
				saida.println(" ");
				
				while (true) {
					//recebe o numero do CEP enviado pela Aplicação Cliente
					String linhaDoPedido = entrada.readLine();
					if (linhaDoPedido == null || linhaDoPedido.length() == 0){
						saida.println("Por favor Informe o CEP !");
						break;
					}
					
					Endereco end = new Endereco();
					end.setCep(linhaDoPedido);
					end.consultaCep();					
					
					if(end.getRua() == null || end.getEstado() == null || end.getTipoLog() == null){
						saida.println("CEP NÃO ENCONTRADO !");
						break;
					} else {
					saida.println("------------------RESULTADO------------------");
					saida.println(" ");
					saida.println("Resultado para o CEP "+linhaDoPedido);
					saida.println("Tipo do Logradouro : " + end.getTipoLog());
					saida.println("Logradouro : " + end.getRua());
					saida.println("Estado : " + end.getEstado());
					saida.println(" ");
					break;
					}
				}
				requisicao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
