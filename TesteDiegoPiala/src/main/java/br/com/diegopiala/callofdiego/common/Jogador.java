package br.com.diegopiala.callofdiego.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Jogador implements Comparable<Jogador> {

	private String nomeJogador;
	private Integer qtdMortes = 0;
	private Integer qtdAssassinatos = 0;
	private HashMap<Arma, Integer> armasUtilizadas = new HashMap<Arma, Integer>();

	public Jogador() {

	}

	public Jogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;

	}

	public boolean adicionaArma(Arma armaAtual) {

		if (armasUtilizadas.containsKey(armaAtual)) {

			Integer contadorArmas = armasUtilizadas.get(armaAtual);
			armasUtilizadas.put(armaAtual, contadorArmas + 1);
			return true;
		} else {
			armasUtilizadas.put(armaAtual, 1);
			return true;
		}
	}

	public List<Arma> verificaArmaPreferida(HashMap<Arma, Integer> armasUtilizadas) {
		List<Arma> armasPreferidas = new ArrayList<Arma>();
		Integer armaPreferida = 0;

		for (Arma arma : armasUtilizadas.keySet()) {
			Integer armaAtual = armasUtilizadas.get(arma);
			if (armaAtual > armaPreferida) {
				armasPreferidas.clear();
				armasPreferidas.add(arma);
				armaPreferida = armaAtual;
			} else if (armaAtual == armaPreferida) {
				armasPreferidas.add(arma);
			}
		}
		return armasPreferidas;

	}

	public HashMap<Arma, Integer> getArmasUtilizadas() {
		return armasUtilizadas;
	}

	public void setArmasUtilizadas(HashMap<Arma, Integer> armasUtilizadas) {
		this.armasUtilizadas = armasUtilizadas;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public Integer getQtdMortes() {
		return qtdMortes;
	}

	public void setQtdMortes(Integer qtdMortes) {
		this.qtdMortes = qtdMortes;
	}

	public Integer getQtdAssassinatos() {
		return qtdAssassinatos;
	}

	public void setQtdAssassinatos(Integer qtdAssassinatos) {
		this.qtdAssassinatos = qtdAssassinatos;
	}

	@Override
	public String toString() {

		return "Jogador: " + nomeJogador;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeJogador == null) ? 0 : nomeJogador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (nomeJogador == null) {
			if (other.nomeJogador != null)
				return false;
		} else if (!nomeJogador.equals(other.nomeJogador))
			return false;
		return true;
	}

	@Override
	public int compareTo(Jogador jogador) {
		int val = this.getQtdAssassinatos().compareTo(jogador.getQtdAssassinatos()) * -1;

		if (val == 0) {
			return this.getQtdMortes().compareTo(jogador.getQtdMortes());
		}
		return val;
	}
}
