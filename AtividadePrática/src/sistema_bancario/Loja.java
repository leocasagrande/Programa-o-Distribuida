package sistema_bancario;

import sistema_bancario.*;

public class Loja implements Runnable {

	private Conta conta;
	private Banco banco;
	private int contador = 1;
	private int id;
	
	public Loja(Banco banco) {
		this.id = contador++;
		this.conta = new Conta("Loja " + id);	
		this.banco = banco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public void run() {
        while (true) {
            if (conta.getSaldo() >= 1400) {
                conta.adicionarValor(1400.0);
                System.out.println("Pagamento feito pela loja " + id);
            }
        }
	}
}