package br.edu.infnet.atfundjava2.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;
import br.edu.infnet.atfundjava2.model.tipo.EnumBody;

@Entity
@Table(name = "TLocal")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected int qntdLugares;
	protected boolean cadeiraEspecial;
	protected String qualidadeMesa;
	protected String descricao;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;
	protected EnumBody tipo;

	@ManyToMany(mappedBy = "locais")
	private List<Restaurante> restaurantes;

	private LocalDateTime data = LocalDateTime.now();

	public Local() {

	}

	public Local(int qntdLugares, boolean cadeiraEspecial, String qualidadeMesa)
			throws QualidadeMesaException, QntdLugaresException {

		
		if (qntdLugares <= 0) {
			throw new QntdLugaresException("Quantidade de lugares invalida, impossivel prosseguir");
		}

		this.qntdLugares = qntdLugares;
		this.cadeiraEspecial = cadeiraEspecial;
		this.data = LocalDateTime.now();
		this.qualidadeMesa = qualidadeMesa;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public abstract float calcularAdicionalPelaMesa();

	@Override

	public String toString() {
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		;

		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(" ; ");
		sb.append(qntdLugares);
		sb.append(" ; ");
		sb.append(cadeiraEspecial);
		sb.append(" ; ");
		sb.append(qualidadeMesa);

		sb.append("  ;  ");
		sb.append(data.format(formatacao));
		sb.append("  ;  ");
		sb.append(this.calcularAdicionalPelaMesa());

		return sb.toString();

	}

	public int getQntdLugares() {
		return qntdLugares;
	}

	public boolean isCadeiraEspecial() {
		return cadeiraEspecial;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getQualidadeMesa() {
		return qualidadeMesa;
	}

	public void setQualidadeMesa(String qualidadeMesa) {
		this.qualidadeMesa = qualidadeMesa;
	}

	public void setQntdLugares(int qntdLugares) {
		this.qntdLugares = qntdLugares;
	}

	public void setCadeiraEspecial(boolean cadeiraEspecial) {
		this.cadeiraEspecial = cadeiraEspecial;
	}

	public EnumBody getTipo() {
		return tipo;
	}

	public void setTipo(EnumBody tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}