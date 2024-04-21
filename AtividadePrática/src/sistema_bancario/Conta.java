package sistema_bancario;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {

	private final String nome;
    private double saldo;
    private final Lock lock = new ReentrantLock();

    public Conta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

    public void creditar(double valor) {
        lock.lock();
        try {
            System.out.println("Creditando R$" + valor + " na conta " + nome + " -------- " + "Novo saldo da conta " + nome + ": R$" + saldo);
            System.out.println("SALDO: " + saldo);
            saldo = saldo + valor;
            System.out.println("SALDO ATUALIZADO: " + saldo);
        } finally {
            lock.unlock();
        }
    }

    public void debitar(double valor) {
        lock.lock();
        try {
            System.out.println("Debitando R$" + valor + " da conta " + nome + " -------- " + "Novo saldo da conta " + nome + ": R$" + saldo);
            saldo = saldo - valor;
        } finally {
            lock.unlock();
        }
    }
}
