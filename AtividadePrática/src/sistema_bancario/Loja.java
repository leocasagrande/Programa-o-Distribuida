package sistema_bancario;

import sistema_bancario.*;

public class Loja implements Runnable {

	private final Banco banco;
    private final Conta conta;
    private final double salarioFuncionario = 1400;
    private final Conta[] contasFuncionarios;
    
    public Loja(Banco banco, Conta conta, Conta[] contasFuncionarios) {
        this.banco = banco;
        this.conta = conta;
        this.contasFuncionarios = contasFuncionarios;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (conta) {
                if (conta.getSaldo() >= 1400) {
                    for (Conta funcionario : contasFuncionarios) {
                        banco.transferir(conta, funcionario, salarioFuncionario);
                        System.out.println("Salário pago para funcionário da loja " + conta.getNome() + ": R$" + salarioFuncionario);
                    }
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