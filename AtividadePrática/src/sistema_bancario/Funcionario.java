package sistema_bancario;

public class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvest;
    private final double salario;

    public Funcionario(Conta contaSalario, Conta contaInvest, double salario) {
        this.contaSalario = contaSalario;
        this.contaInvest = contaInvest;
        this.salario = salario;
    }
    
    public Conta getContaInvest() {
    	return contaInvest;
    }
    
    public Conta getContaSalario() {
    	return contaSalario;
    }

    public double getSalario() {
        return salario;
    }

    public void receberSalario() {
        contaSalario.creditar(salario);
        double valorInvestimento = salario * 0.20;
        contaInvest.creditar(valorInvestimento);
        System.out.println("Funcionário recebeu salário de R$ " + salario + " e investiu R$ " + valorInvestimento);
    }

    @Override
    public void run() {
        receberSalario();
    }
}
	
	
