package sistema_bancario;

public class Conta {

	public String conta;
	public Double saldo;
	
	
	public Conta(String conta) {
		this.conta = conta;
		this.saldo = 1000.0;
	}
	
	public Conta(String conta, Double saldo) {
		super();
		this.conta = conta;
		this.saldo = saldo;
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public void adicionar(Double valor) {
		saldo += valor;
	}
	
	public void tirar(Double valor) {
		saldo -= valor;
	}
}
