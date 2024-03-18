package Exercicio03;

import java.util.ArrayList;
import java.util.List;

	public class ThreadPrimos extends Thread{

		private int soma;
		
		public void run() {
			
			List<Integer> lista = new ArrayList();
			
			
			for(int i = 2; i <= 100;  i ++) {			
				if (Primo(i)) {
	                soma += i;
	            }
			}
			
			System.out.println("A soma dos números primos de 0 a 100 é: " + soma);
			
		}
		
		private static boolean Primo(int valor) {
	        if (valor <= 1) {
	            return false;
	        }

	        for (int i = 2; i <= Math.sqrt(valor); i++) {
	            if (valor % i == 0) {
	                return false;
	            }
	        }

	        return true;
	    }
}