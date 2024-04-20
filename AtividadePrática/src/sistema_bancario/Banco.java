package sistema_bancario;

import sistema_bancario.*;

public class Banco {

	public synchronized void transferencia(Conta origem, Conta destino, Double valor) {
        if (origem.getSaldo() >= valor) {
            origem.tirarValor(valor);
            destino.adicionarValor(valor);
            System.out.println("Transferência de R$" + valor + " da conta " + origem.getConta() + " para a conta " + destino.getConta() + " realizada com sucesso!");
        } else {
            System.out.println("Transferência de R$" + valor + " da conta " + origem.getConta() + " para a conta " + destino.getConta() + " falhou: saldo insuficiente em " + origem.getConta());
        }
    }

}