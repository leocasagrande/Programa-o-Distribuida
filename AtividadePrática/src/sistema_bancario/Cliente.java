package sistema_bancario;

public class Cliente extends Thread{

	private String nome;
	private Conta conta;
	
	public Cliente(String nome) {
		this.conta = new Conta(1000.0);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void Compra() {
		
	}
	
}
