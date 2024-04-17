package sistema_bancario;

public class Funcionario extends Thread{

	private String nome;
	private Conta contaSalario;
	private Conta contaInvest;
	
	public Funcionario(String nome) {
		this.nome = nome;
		this.contaSalario = new Conta(0.0);
		this.contaInvest = new Conta(0.0);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void investimento(Double salario) {
		
		Double porcentInvest;
		Double resto;
		
		porcentInvest = salario * 0.20;
		resto = salario - porcentInvest;
		
		contaSalario.setSaldo(resto);
		contaInvest.setSaldo(porcentInvest);
		
	}
	
	
}
