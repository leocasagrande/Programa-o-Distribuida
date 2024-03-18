package Exercicio02;

import java.util.List;
import java.util.ArrayList;

public class MaiorValorThread extends Thread{

	private int maior;
	
	public void run() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(5);
		lista.add(10);
		lista.add(15);
		lista.add(20);
		
		for(int i = 0; i < lista.size(); i ++) {
			if(lista.get(i) > maior) {
				maior = lista.get(i);		
			}
		}
		System.out.println("Maior numero = " + maior);
		
	}
	
}
