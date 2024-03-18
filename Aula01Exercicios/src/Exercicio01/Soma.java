package Exercicio01;

public class Soma extends Thread{
	
	private float a;
	private float b;
	
	public Soma(float a, float b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		float adicao = a + b;
		
		System.out.println("Soma: " + adicao);
		
	}

}
