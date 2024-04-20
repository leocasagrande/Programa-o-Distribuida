package sistema_bancario;

public class Funcionario implements Runnable{

	private Banco banco;
	private Conta contaSalario;
	private Conta contaInvest;
	private int contador = 1;
	private int id;
	
	public Funcionario(Banco banco) {
		this.id = contador++;
		this.banco = banco;
		this.contaSalario = new Conta("Salário do funcionário " + id);
		this.contaInvest = new Conta("Investimento do funcionário " + id);
	}

	public Funcionario(Banco banco, Conta contaSalario, Conta contaInvest) {
		super();
		this.banco = banco;
		this.contaSalario = contaSalario;
		this.contaInvest = contaInvest;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Conta getContaSalario() {
		return contaSalario;
	}

	public void setContaSalario(Conta contaSalario) {
		this.contaSalario = contaSalario;
	}

	public Conta getContaInvest() {
		return contaInvest;
	}

	public void setContaInvest(Conta contaInvest) {
		this.contaInvest = contaInvest;
	}

	public void run() {
		int contador = 0;
		while(contador < 10 && contaSalario.getSaldo() > 0) {
		Double salario = 1400.0;
		synchronized(banco) {
			banco.transferencia(contaSalario, contaInvest, salario * 0.20);
		}
		contador++;
	}
}
	
	
}
