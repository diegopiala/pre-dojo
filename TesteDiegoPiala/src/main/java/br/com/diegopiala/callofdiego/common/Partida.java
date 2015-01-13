package br.com.diegopiala.callofdiego.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partida {

	private String codigoPartida;
	private int killsTotal;
	private boolean statusPartida;
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public Partida() {

	}

	public boolean adicionaAssassino(Jogador jog, Arma armaAtual) {

		for (Jogador jogador : jogadores) {
			if (jogador.equals(jog)) {
				jogador.setQtdAssassinatos(jogador.getQtdAssassinatos() + 1);
				jogador.adicionaArma(armaAtual);
				return false;
			}
		}
		jog.setQtdAssassinatos(jog.getQtdAssassinatos() + 1);
		jog.adicionaArma(armaAtual);
		return jogadores.add(jog);
	}

	public boolean adicionaMorto(Jogador jog) {

		for (Jogador jogador : jogadores) {
			if (jogador.equals(jog)) {
				jogador.setQtdMortes(jogador.getQtdMortes() + 1);
				return false;
			}
		}
		jog.setQtdMortes(jog.getQtdMortes() + 1);
		return jogadores.add(jog);
	}

	public String getCodigoPartida() {
		return codigoPartida;
	}

	public boolean isStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(boolean statusPartida) {
		this.statusPartida = statusPartida;
	}

	public void setCodigoPartida(String codigoPartida) {
		this.codigoPartida = codigoPartida;
	}

	public int getKills() {
		return killsTotal;
	}

	public void setKills(int kills) {
		this.killsTotal = kills;
	}

	public List<Jogador> getJogadores() {
		Collections.sort(jogadores);
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
