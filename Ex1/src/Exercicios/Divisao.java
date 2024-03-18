package Exercicios;

public class Divisao extends Thread{

	private float a;
	private float b;
	
	public Divisao(float a, float b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		float divisao = a / b;
	
		System.out.println("Divisão: " + divisao);
	}
	
}
