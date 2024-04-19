package sistema_bancario;

import java.util.List;

import sistema_bancario.*;

public class Banco {

	private List<Loja> loja;

	public List<Loja> getLoja() {
		return loja;
	}

	public void setLoja(List<Loja> loja) {
		this.loja = loja;
	}

	public synchronized void transferencia(Conta origem, Conta destino, Double valor) {
        if (origem.getSaldo() >= valor) {
            origem.adicionar(valor);
            destino.tirar(valor);
            System.out.println("Transferência realizada!");
        } else {
            System.out.println("Transferência falhou, saldo insuficiente em " + origem.getConta());
        }
        return;
    }

}
