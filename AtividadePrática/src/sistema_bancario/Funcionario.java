package sistema_bancario;

public class Funcionario implements Runnable{

	private final Conta contaSalario;
    private final Conta contaInvest;
    private final double salario = 1400;

    public Funcionario(Conta contaSalario, Conta contaInvest) {
        this.contaSalario = contaSalario;
        this.contaInvest = contaInvest;
    }

    @Override
    public void run() {
        while (contaSalario.getSaldo() > 0) {
            synchronized (contaSalario) {
                if (contaSalario.getSaldo() >= salario) {
                    double valorInvestimento = salario * 0.2;
                    contaSalario.debitar(salario);
                    contaInvest.creditar(valorInvestimento);
                    System.out.println("Funcionário recebeu salário de R$" + salario + " e investiu R$" + valorInvestimento);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
	
}
