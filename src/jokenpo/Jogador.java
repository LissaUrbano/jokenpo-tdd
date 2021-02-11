package jokenpo;

public class Jogador {

	private String nome;
	private ElementoDaJogada elemento;
	
	public Jogador(String nome, ElementoDaJogada elemento) {
		this.nome = nome;
		this.elemento = elemento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ElementoDaJogada getElemento() {
		return elemento;
	}
	public void setElemento(ElementoDaJogada elemento) {
		this.elemento = elemento;
	}
	
}
