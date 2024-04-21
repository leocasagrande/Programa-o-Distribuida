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
                System.out.println("Transferência de R$ " + valor + " de " + origem.getCliente() + " para " + destino.getCliente());
            } else {
                System.out.println("Saldo insuficiente para transferência de " + origem.getCliente());
            }
        } finally {
            lock.unlock();
        }
    }
}