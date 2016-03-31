package modelo;

public class Endereco {
	private String cep;
	private String rua;
	private String estado;
	private String tipoLog;
	
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", bairro=" + estado + ", cidade=" + tipoLog + "]";
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(String cidade) {
		this.tipoLog = cidade;
	}
	
	//Methods
	public void consultaCep(){
		
		MySql db = new MySql();
		String[] dados = db.exec(this.getCep());
		
		this.setRua(dados[1]);
		this.setEstado(dados[2]);
		this.setTipoLog(dados[3]);			
	}

}
