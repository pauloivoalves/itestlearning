package br.ufc.si.itest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itest.fase_projeto_descricao")
public class FaseProjeto implements Serializable {

	private static final long serialVersionUID = 1L;

	// aqui esta o problema
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	//

	@EmbeddedId
	private FaseProjetoPK pk;

	@Column(name = "desc_fluxo_principal")
	private String desc_fluxo_principal;

	@Column(name = "desc_fluxo_secundario")
	private String desc_fluxo_secundario;

	@Column(name = "desc_fluxo_excecao")
	private String desc_fluxo_excecao;

	@Column(name = "desc_requisito")
	private String desc_requisito;

	@Column(name = "desc_nivel_requisito")
	private String desc_nivel_requisito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FaseProjetoPK getPk() {
		return pk;
	}

	public void setPk(FaseProjetoPK pk) {
		this.pk = pk;
	}

	public String getDesc_fluxo_principal() {
		return desc_fluxo_principal;
	}

	public void setDesc_fluxo_principal(String desc_fluxo_principal) {
		this.desc_fluxo_principal = desc_fluxo_principal;
	}

	public String getDesc_fluxo_secundario() {
		return desc_fluxo_secundario;
	}

	public void setDesc_fluxo_secundario(String desc_fluxo_secundario) {
		this.desc_fluxo_secundario = desc_fluxo_secundario;
	}

	public String getDesc_fluxo_excecao() {
		return desc_fluxo_excecao;
	}

	public void setDesc_fluxo_excecao(String desc_fluxo_excecao) {
		this.desc_fluxo_excecao = desc_fluxo_excecao;
	}

	public String getDesc_requisito() {
		return desc_requisito;
	}

	public void setDesc_requisito(String desc_requisito) {
		this.desc_requisito = desc_requisito;
	}

	public String getDesc_nivel_requisito() {
		return desc_nivel_requisito;
	}

	public void setDesc_nivel_requisito(String desc_nivel_requisito) {
		this.desc_nivel_requisito = desc_nivel_requisito;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof FaseProjeto)
			if (((FaseProjeto) other).getId().equals(this.id))
				return true;
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + this.id;
		return hash;
	}

	public static class FaseProjetoPK implements Serializable {

		private static final long serialVersionUID = 1L;

		@OneToOne
		@JoinColumn(name = "id_projeto_fk", nullable = false)
		private Projeto projeto;

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}

	}

}
