package sistema_bancario;

import java.util.Random;

public class Cliente implements Runnable{

	private Banco banco;
	private Conta conta;
	private int id;
	public int contador = 1;
	
	public Cliente(Banco banco) {
		this.id = contador++;
		this.conta = new Conta("Cliente " + id, 1000.0);
		this.banco = banco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void run() {
		Random random = new Random();
		while(conta.getSaldo() > 0) {
			Double valor =  (random.nextDouble(2) + 1) * 100;
			synchronized (banco) {
				banco.transferencia(conta, banco.getLoja().get(random.nextInt(banco.getLoja().size())).getConta(), valor);
			}
		}
		
	}
	
	
}
