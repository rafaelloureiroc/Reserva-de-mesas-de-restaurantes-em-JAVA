package br.edu.infnet.atfundjava2.model;

import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TMesaInterna")

public class MesaInterna extends Local {

	private boolean arCondicionado;
	private boolean velaRomantica;
	private String iluminacaoEspecial;

	public MesaInterna(int qntdLugares, boolean cadeiraEspecial, String qualidadeMesa)
			throws QualidadeMesaException, QntdLugaresException {
		super(qntdLugares, cadeiraEspecial, qualidadeMesa);
	}

	public MesaInterna() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(arCondicionado);
		sb.append(";");
		sb.append(velaRomantica);
		sb.append(";");
		sb.append(iluminacaoEspecial);
		sb.append(";");

		return sb.toString();
	}

	@Override
	public float calcularAdicionalPelaMesa() {
		float valorMesa =  (qntdLugares * 5f) + (cadeiraEspecial ? +50 : 0) + (velaRomantica ? +25 : 0);
		return valorMesa;
	} // 300 + 40 + 50 = 390 +25 = 415 }

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public boolean isVelaRomantica() {
		return velaRomantica;
	}

	public void setVelaRomantica(boolean velaRomantica) {
		this.velaRomantica = velaRomantica;
	}

	public String getIluminacaoEspecial() {
		return iluminacaoEspecial;
	}

	public void setIluminacaoEspecial(String iluminacaoEspecial) {
		this.iluminacaoEspecial = iluminacaoEspecial;
	}

}
