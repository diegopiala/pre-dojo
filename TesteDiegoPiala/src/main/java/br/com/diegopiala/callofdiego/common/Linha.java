package br.com.diegopiala.callofdiego.common;

public enum Linha {

	NOVA_PARTIDA("(23/04/2013 15:34:22) (-) (New match) ([0-9]{5,20}) (has started)"),
	ASSASSINATO("(23/04/2013 15:36:04)\\s(-)\\s([\\w]+)\\s(killed)\\s([\\w]+)\\s(using)\\s([\\w]+)"),
	ASSASSINATO_MUNDO("(23/04/2013 15:36:33) (-) (<WORLD>) (killed) ([\\w]+) (by) ([\\w]+)"),
	FINAL_PARTIDA("(23/04/2013 15:39:22) (-) (Match) (11348965) (has ended)");
	
	private  String tipoLinha = "";

	private Linha(String tipoLinha) {
		this.tipoLinha = tipoLinha;
	}

	public String GetTipoLinha() {
		return this.tipoLinha;
	}
}
