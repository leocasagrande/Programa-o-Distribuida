package sistema_bancario;

import java.util.List;
import java.util.Random;

public class Cliente implements Runnable{

	private List<Loja> lojas;
	private Banco banco;
	private Conta conta;
	private int id;
	public int contador = 1;
	
	public Cliente(Banco banco, List<Loja> lojas) {
		this.id = contador++;
		this.conta = new Conta("Cliente " + id, 1000.0);
		this.banco = banco;
		this.lojas = lojas;
	}
	
	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
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
			int n =  (random.nextInt(2) + 1) * 100;
			Double valor = (double) n;
			synchronized (banco) {
				banco.transferencia(conta, lojas.get(random.nextInt(lojas.size())).getConta(), valor);
			}
		}
		
	}
	
	
}
