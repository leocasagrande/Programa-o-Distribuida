package Exercicios;

public class Subtracao extends Thread{

	private float a;
	private float b;
	
	public Subtracao(float a, float b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		float subtracao = a - b;
		
		System.out.println("Subtração: " + subtracao);
	}
	
}
