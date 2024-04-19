package sistema_bancario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import sistema_bancario.*;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        banco = new Banco();

        Loja loja = new Loja();
        Loja loja2 = new Loja();

        for (int i = 0; i < 4; i++) {
            Funcionario funcionario = new Funcionario(banco);
            funcionarios.add(funcionario);
        }

        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente(banco);
            clientes.add(cliente);
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(loja);
        executor.execute(loja2);
        
        for (Funcionario funcionario : funcionarios) {
            executor.execute(funcionario);
        }

        for (Cliente cliente : clientes) {
            executor.execute(cliente);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldos finais:");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente " + cliente.getId() + ": Saldo = R$" + cliente.getConta().getSaldo());
        }
        
        System.out.println("Saldo da Loja " + loja.getId() + ": R$" + loja.getConta().getSaldo());
        System.out.println("Saldo da Loja " + loja2.getId() + ": R$" + loja2.getConta().getSaldo());
    }
		

}

