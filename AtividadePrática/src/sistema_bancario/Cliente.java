package sistema_bancario;

import java.util.List;
import java.util.Random;

public class Cliente implements Runnable{

	private final Banco banco;
    private final Conta conta;
    private final String[] lojas = {"Casa do Pão de Queijo", "Biscoito Mineiro"};
    private final double[] valores = {100, 200};
    private int lojaAtual = 0;

    public Cliente(Banco banco, Conta conta) {
        this.banco = banco;
        this.conta = conta;
    }

    public void run() {
        while (true) {
            double valorCompra = valores[lojaAtual];
            synchronized (conta) {
                if (conta.getSaldo() >= valorCompra) {
                    banco.transferir(conta, new Conta(lojas[lojaAtual], valorCompra), valorCompra);
                    lojaAtual = (lojaAtual + 1) % 2;
                }
            }
        }
    }
	
}
