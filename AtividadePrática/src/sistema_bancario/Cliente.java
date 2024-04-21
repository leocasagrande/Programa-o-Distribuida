package sistema_bancario;

import java.util.List;
import java.util.Random;

public class Cliente extends Thread {
    private final Conta conta;

    public Cliente(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = Math.random() > 0.5 ? 100.0 : 200.0;
            conta.debitar(valorCompra);
            System.out.println("Cliente realizou compra de R$ " + valorCompra);
        }
    }
}
