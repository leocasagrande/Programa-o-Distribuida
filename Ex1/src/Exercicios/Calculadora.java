package Exercicios;

public class Calculadora {

	public static void main(String[] args) {

		Soma soma = new Soma(10, 2);
		Subtracao subtracao = new Subtracao(10, 2);
		Divisao divisao =  new Divisao(10, 2);
		Multiplicacao mult = new Multiplicacao(10, 2);
		
		soma.start();
		subtracao.start();
		divisao.start();
		mult.start();
		
	}

}
