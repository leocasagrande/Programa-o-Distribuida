package sistema_bancario;

import sistema_bancario.*;

public class Loja {
    private final Conta conta;
    private final Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios) {
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public Conta getConta() {
        return conta;
    }

    public void pagarSalarios() {
        double salarioTotal = 0;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal += funcionario.getSalario();
        }
        if (conta.getSaldo() >= salarioTotal) {
            for (Funcionario funcionario : funcionarios) {
                funcionario.receberSalario();
                conta.debitar(funcionario.getSalario());
            }
            System.out.println("Salários pagos para os funcionários da loja");
        } else {
            System.out.println("Saldo insuficiente para pagar os salários dos funcionários da loja");
        }
    }
}