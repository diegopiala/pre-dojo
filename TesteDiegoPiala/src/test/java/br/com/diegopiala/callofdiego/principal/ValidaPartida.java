package br.com.diegopiala.callofdiego.principal;

import br.com.diegopiala.callofdiego.util.PartidaLeitor;


public class ValidaPartida {

	public static void main(String[] args) {
		
		PartidaLeitor partida = new PartidaLeitor();
		partida.run("src/main/resources/test/jogo.log");
	}

}
