package sistema_bancario;

public class Funcionario extends Thread {
    private final Conta salarioConta;
    private final Conta investimentoConta;
    private final double salario;

    public Funcionario(Conta salarioConta, Conta investimentoConta, double salario) {
        this.salarioConta = salarioConta;
        this.investimentoConta = investimentoConta;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void receberSalario() {
        salarioConta.creditar(salario);
        double valorInvestimento = salario * 0.20;
        investimentoConta.creditar(valorInvestimento);
        System.out.println("Funcionário recebeu salário de R$ " + salario + " e investiu R$ " + valorInvestimento);
    }

    @Override
    public void run() {
        receberSalario();
    }
}
	
	
