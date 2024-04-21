package sistema_bancario;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo;
    private final String cliente;
    private final Lock lock = new ReentrantLock();

    public Conta(String cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        lock.lock();
        try {
            saldo += valor;
        } finally {
            lock.unlock();
        }
    }

    public void debitar(double valor) {
        lock.lock();
        try {
            saldo -= valor;
        } finally {
            lock.unlock();
        }
    }
}
