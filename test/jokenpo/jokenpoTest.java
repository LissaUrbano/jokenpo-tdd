package jokenpo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class jokenpoTest {
	
	@Test
	public void instanciaJogadores() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PEDRA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PEDRA);
        assertAll("jogador1",
                () -> assertEquals("João", jogador1.getNome()),
                () -> assertEquals(ElementoDaJogada.PEDRA, jogador1.getElemento())
            );
        assertAll("jogador2",
                () -> assertEquals("Ana", jogador2.getNome()),
                () -> assertEquals(ElementoDaJogada.PEDRA, jogador2.getElemento())
            );
	}
	
	@Test
	public void instanciaJogada() throws Exception {
		Jogador jogador1 = new Jogador("Bruna", ElementoDaJogada.TESOURA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PEDRA);
		Jogada jogada = new Jogada(jogador1, jogador2);
        assertAll("jogada",
                () -> assertEquals("Bruna", jogada.getJogador1().getNome()),
                () -> assertEquals("Ana", jogada.getJogador2().getNome())
            );
	}
	
	@Test
	void JogoEmpataParaElementoPedra() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PEDRA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PEDRA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		assertTrue(jogada.isEmpate());
	}
	
	@Test
	void JogoEmpataParaElementoTesoura() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.TESOURA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.TESOURA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		assertTrue(jogada.isEmpate());
	}
	
	@Test
	void JogoEmpataParaElementoPapel() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PAPEL);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PAPEL);
		Jogada jogada = new Jogada(jogador1, jogador2);
		assertTrue(jogada.isEmpate());
	}
	
	@Test
	void elementoPedraGanha() throws Exception {
		Jogador jogador1 = new Jogador("Lucia", ElementoDaJogada.PEDRA);
		Jogador jogador2 = new Jogador("Luciano", ElementoDaJogada.TESOURA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador1, vencedor);
	}
	
	@Test
	void elementoPapelGanha() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PAPEL);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PEDRA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador1, vencedor);
	}
	
	@Test
	void elementoTesouraGanha() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PAPEL);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.TESOURA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador2, vencedor);
	}
	
	@Test
	void empatePeloMetodoApuracao() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.PAPEL);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PAPEL);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertNull(vencedor);
	}
	
	@Test
	void elementoPedraPerde() throws Exception {
		Jogador jogador1 = new Jogador("Lucia", ElementoDaJogada.PEDRA);
		Jogador jogador2 = new Jogador("Luciano", ElementoDaJogada.PAPEL);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador2, vencedor);
	}
	
	@Test
	void elementoPapelPerde() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.TESOURA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PAPEL);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador1, vencedor);
	}
	
	@Test
	void elementoTesouraPerde() throws Exception {
		Jogador jogador1 = new Jogador("João", ElementoDaJogada.TESOURA);
		Jogador jogador2 = new Jogador("Ana", ElementoDaJogada.PEDRA);
		Jogada jogada = new Jogada(jogador1, jogador2);
		Jogador vencedor = jogada.apurarJogadorVencedor();
		assertEquals(jogador2, vencedor);
	}
	
}
