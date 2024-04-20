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
        List<Loja> lojas = new ArrayList<>();
        
        banco = new Banco();

        for(int i = 0; i < 2; i++) {
        	Loja loja = new Loja(banco);
        	lojas.add(loja);
        }

        for (int i = 0; i < 4; i++) {
            Funcionario funcionario = new Funcionario(banco);
            funcionarios.add(funcionario);
        }

        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente(banco, lojas);
            cliente.getConta().setSaldo(1000.0);
            clientes.add(cliente);
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        

        for(Loja loja : lojas) {
        	executor.execute(loja);
        }
        
        for (Funcionario funcionario : funcionarios) {
            executor.execute(funcionario);
        }

        for (Cliente cliente : clientes) {
            executor.execute(cliente);
        }

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldos finais:");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente " + cliente.getId() + ": Saldo = R$" + cliente.getConta().getSaldo());
        }
        System.out.println("ACABOU");
        executor.shutdown();
    }
		

}


