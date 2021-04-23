package br.com.model;

public class ChurrascoModel {
	private String tipoChurrasco;
	private double valorChurrasco;
	private int qtdeChurrasco, id_churrasco;

	public ChurrascoModel(String tipoChurrasco, double valorChurrasco, int qtdeChurrasco, int id_churrasco) {
		super();
		this.tipoChurrasco = tipoChurrasco;
		this.valorChurrasco = valorChurrasco;
		this.qtdeChurrasco = qtdeChurrasco;
		this.id_churrasco = id_churrasco;
	}

	public ChurrascoModel(String tipoChurrasco, double valorChurrasco, int qtdeChurrasco) {
		super();
		this.tipoChurrasco = tipoChurrasco;
		this.valorChurrasco = valorChurrasco;
		this.qtdeChurrasco = qtdeChurrasco;
	}

	public String getTipoChurrasco() {
		return tipoChurrasco;
	}

	public void setTipoChurrasco(String tipoChurrasco) {
		this.tipoChurrasco = tipoChurrasco;
	}

	public double getValorChurrasco() {
		return valorChurrasco;
	}

	public void setValorChurrasco(double valorChurrasco) {
		this.valorChurrasco = valorChurrasco;
	}

	public int getQtdeChurrasco() {
		return qtdeChurrasco;
	}

	public void setQtdeChurrasco(int qtdeChurrasco) {
		this.qtdeChurrasco = qtdeChurrasco;
	}
	
	public int getId_churrasco() {
		return id_churrasco;
	}

	public void setId_churrasco(int id_churrasco) {
		this.id_churrasco = id_churrasco;
	}
}
