package sistema_bancario;

public class Conta {

	public String conta;
	public Double saldo = 0.0;
	
	
	public Conta(String conta) {
		this.conta = conta;
		this.saldo = 0.0;
	}
	
	public Conta(String conta, Double saldo) {
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
	
	public synchronized void adicionarValor(Double valor) {
		saldo += valor;
	}
	
	public synchronized void tirarValor(Double valor) {
		saldo -= valor;
	}
}
