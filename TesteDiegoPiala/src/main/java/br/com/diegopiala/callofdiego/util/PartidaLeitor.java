package br.com.diegopiala.callofdiego.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.diegopiala.callofdiego.common.Arma;
import br.com.diegopiala.callofdiego.common.Jogador;
import br.com.diegopiala.callofdiego.common.Linha;
import br.com.diegopiala.callofdiego.common.Partida;
import br.com.diegopiala.callofdiego.constants.Constantes;

public class PartidaLeitor {

	public void run(String arquivo){
		
		leitorArquivo(arquivo);
	} 

	private static void leitorArquivo(String file) {

		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String linha;

			Partida partidaAtual = new Partida();
			while (in.ready()) {
				linha = in.readLine();
				verificaLinhaPartida(linha, partidaAtual);

			}
			in.close();

			montaRanking(partidaAtual);

		} catch (IOException e) {
			
		}
	}

	private static void montaRanking(Partida partida) {

		System.out.println("Partida Nº: " + partida.getCodigoPartida());
		for (Jogador jogador : partida.getJogadores()) {
			System.out.println(jogador + " Matou: " + jogador.getQtdAssassinatos() + " | Morreu: " + jogador.getQtdMortes() + " | Armas Preferidas:" + jogador.verificaArmaPreferida(jogador.getArmasUtilizadas()));
		}
		System.out.println("Total de Mortes: " + partida.getKills());
	}

	private static void verificaLinhaPartida(String linha, Partida partidaAtual) {

		if (linha.matches(Linha.NOVA_PARTIDA.GetTipoLinha())) {

			Matcher matcher = Pattern.compile(Linha.NOVA_PARTIDA.GetTipoLinha()).matcher(linha);
			matcher.find();
			partidaAtual.setCodigoPartida(matcher.group(Constantes.PARTIDA));
			partidaAtual.setStatusPartida(true);

		} else if (linha.matches(Linha.ASSASSINATO.GetTipoLinha())) {
			Matcher matcher = Pattern.compile(Linha.ASSASSINATO.GetTipoLinha()).matcher(linha);
			matcher.find();

			partidaAtual.adicionaAssassino(new Jogador(matcher.group(Constantes.ASSASSINO)), new Arma(matcher.group(Constantes.ARMA)));
			partidaAtual.adicionaMorto(new Jogador(matcher.group(Constantes.MORTO)));
			partidaAtual.setKills(partidaAtual.getKills() + 1);

		} else if (linha.matches(Linha.ASSASSINATO_MUNDO.GetTipoLinha())) {
			Matcher matcher = Pattern.compile(Linha.ASSASSINATO_MUNDO.GetTipoLinha()).matcher(linha);
			matcher.find();

			partidaAtual.adicionaMorto(new Jogador(matcher.group(Constantes.MORTO)));

		} else if (linha.matches(Linha.FINAL_PARTIDA.GetTipoLinha())) {

			partidaAtual.setStatusPartida(false);

		}

	}

}
