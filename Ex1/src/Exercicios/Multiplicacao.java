package Exercicios;

public class Multiplicacao extends Thread {
	
	private float a;
	private float b;
	
	public Multiplicacao(float a, float b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		float multiplicacao = a * b;
	
		System.out.println("Multiplicação: " + multiplicacao);
	}
	
	
	
}
