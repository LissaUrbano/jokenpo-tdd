package jokenpo;

public class Jogada {
	
	private Jogador jogador1;
	private Jogador jogador2;
	
	public Jogada(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}
	
	public Jogador getJogador1() {
		return jogador1;
	}
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}
	public Jogador getJogador2() {
		return jogador2;
	}
	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public boolean isEmpate() {
		boolean isEmpate = jogador1.getElemento().equals(jogador2.getElemento());
		return isEmpate;
	}

	public Jogador apurarJogadorVencedor() throws Exception{
		Jogador vencedor = null;
		
		if (isEmpate()) {
			return null;
		}
		
		switch (jogador1.getElemento()){
			case PEDRA:
				vencedor = jogador2.getElemento().equals(ElementoDaJogada.TESOURA) ? jogador1 : jogador2;
				break;
			case PAPEL:
				vencedor = jogador2.getElemento().equals(ElementoDaJogada.PEDRA) ? jogador1 : jogador2;
				break;
			case TESOURA:
				vencedor = jogador2.getElemento().equals(ElementoDaJogada.PAPEL) ? jogador1 : jogador2;
				break;
			default : throw new Exception("Elemento não mapeado.");
		}
		return vencedor;
	}

}
