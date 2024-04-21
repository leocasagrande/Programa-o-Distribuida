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
	        Conta contaLojaA = new Conta("Casa do Pão de Queijo", 0);
	        Conta contaLojaB = new Conta("Biscoito Mineiro", 0);
	        
	        Conta[] contasFuncionarioA = {new Conta("Funcionário Jose", 0), new Conta("Investimento de Jose", 0)};
	        Conta[] contasFuncionarioB = {new Conta("Funcionário Leonardo", 0), new Conta("Investimento de Leonardo", 0)};
	        Conta[] contasFuncionarioC = {new Conta("Funcionário Arthur", 0), new Conta("Investimento de Arthur", 0)};
	        Conta[] contasFuncionarioD = {new Conta("Funcionário Maria", 0), new Conta("Investimento de Maria", 0)};
	        
	        for (int i = 0; i < 4; i++) {
	            Conta contaSalario = i < 2 ? contasFuncionarioA[0] : contasFuncionarioB[0];
	            Conta contaInvestimento = i < 2 ? contasFuncionarioA[1] : contasFuncionarioB[1];
	            new Thread(new Funcionario(contaSalario, contaInvestimento)).start();
	        }
	        
	        new Thread(new Loja(banco, contaLojaA, contasFuncionarioA)).start();
	        new Thread(new Loja(banco, contaLojaB, contasFuncionarioB)).start();
	        new Thread(new Loja(banco, contaLojaA, contasFuncionarioC)).start();
	        new Thread(new Loja(banco, contaLojaB, contasFuncionarioD)).start();

	        new Thread(new Cliente(banco, new Conta("Cliente Roberto", 1000))).start();
	        new Thread(new Cliente(banco, new Conta("Cliente Tulio", 1000))).start();
	        new Thread(new Cliente(banco, new Conta("Cliente Bernardo", 1000))).start();
	        new Thread(new Cliente(banco, new Conta("Cliente Julia", 1000))).start();
	        new Thread(new Cliente(banco, new Conta("Cliente Clara", 1000))).start();
	       
	    }	

}


