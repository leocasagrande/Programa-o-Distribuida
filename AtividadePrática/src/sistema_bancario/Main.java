package sistema_bancario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import sistema_bancario.*;

public class Main {

	public static void main(String[] args) {
		//Criando os objetos de cada classe
        Conta contaBanco = new Conta("Banco", 0);
        Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);

        Conta contaInvestimento1 = new Conta("Investimento 1", 0);
        Conta contaInvestimento2 = new Conta("Investimento 2", 0);

        Funcionario[] funcionariosLoja1 = {
                new Funcionario(contaLoja1, contaInvestimento1, 1400),
                new Funcionario(contaLoja1, contaInvestimento1, 1400)
        };

        Funcionario[] funcionariosLoja2 = {
                new Funcionario(contaLoja2, contaInvestimento2, 1400),
                new Funcionario(contaLoja2, contaInvestimento2, 1400)
        };

        Loja loja1 = new Loja(contaLoja1, funcionariosLoja1);
        Loja loja2 = new Loja(contaLoja2, funcionariosLoja2);

        Cliente[] clientes = {
                new Cliente(new Conta("Cliente Marcos", 1000)),
                new Cliente(new Conta("Cliente Ana", 1000)),
                new Cliente(new Conta("Cliente Tulio", 1000)),
                new Cliente(new Conta("Cliente Gabriel", 1000)),
                new Cliente(new Conta("Cliente Julia", 1000))
        };

        Banco banco = new Banco();

        
        //Startando threads
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        for (Funcionario funcionario : funcionariosLoja1) {
            funcionario.start();
        }

        for (Funcionario funcionario : funcionariosLoja2) {
            funcionario.start();
        }

        for (Cliente cliente : clientes) {
            for (Loja loja : new Loja[]{loja1, loja2}) {
                banco.transferir(cliente.getConta(), loja.getConta(), 100);
            }
        }

        //Pagando salario dos funcionarios
        loja1.pagarSalarios();
        loja2.pagarSalarios();

        // Exibir saldo final das contas
        System.out.println("Saldo final da conta do Banco: " + contaBanco.getSaldo());
        System.out.println("Saldo final da conta da Loja 1: " + contaLoja1.getSaldo());
        System.out.println("Saldo final da conta da Loja 2: " + contaLoja2.getSaldo());
        int id = 1;
        for (Funcionario funcionario : funcionariosLoja1) {
        	System.out.println("Saldo final do salario do funcionario " + id + " da Loja 1: " + funcionario.getContaSalario().getSaldo());
        	System.out.println("Saldo final da conta investimento do funcionario " + id + " da Loja 1: " + funcionario.getContaInvest().getSaldo());
        	id++;
        }
        id = 1;
        for (Funcionario funcionario : funcionariosLoja2) {
        	System.out.println("Saldo final do salario do funcionario " + id + " da Loja 2: " + funcionario.getContaSalario().getSaldo());
        	System.out.println("Saldo final da conta investimento do funcionario " + id + " da Loja 2: " + funcionario.getContaInvest().getSaldo());
        	id++;
        }
        
        for (Cliente cliente : clientes) {
        	System.out.println("Saldo final do cliente " + cliente.getConta().getCliente() + ": "  + cliente.getConta().getSaldo());
        }
    }

}


