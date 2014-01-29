package br.ufc.si.itest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "itest.execucao_projeto")
public class ExecucaoProjeto {

	@Id
	@GeneratedValue
	@Column(name = "id_res")
	private int id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "resposta")
	private boolean resposta;

	@ManyToOne
	@JoinColumn(name = "id_caso", nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private CasoDeTeste casoDeTeste;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public CasoDeTeste getCasoDeTeste() {
		return casoDeTeste;
	}

	public void setCasoDeTeste(CasoDeTeste casoDeTeste) {
		this.casoDeTeste = casoDeTeste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
