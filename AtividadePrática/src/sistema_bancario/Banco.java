package sistema_bancario;

import sistema_bancario.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Lock lock = new ReentrantLock();

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.debitar(valor);
                destino.creditar(valor);
                System.out.println("Transferência de R$" + valor + " realizada de " + origem.getNome() + " para " + destino.getNome());
            } else {
                System.out.println("Saldo insuficiente em " + origem.getNome() + " para transferência de R$" + valor);
            }
        } finally {
            lock.unlock();
        }
    }
}