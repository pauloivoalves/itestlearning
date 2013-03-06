package br.ufc.si.itest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="itest.administrador")
@PrimaryKeyJoinColumn(name="id_admin")
public class Administrador extends Usuario{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="admin")
	private List<Projeto> meusProjetos;

	public List<Projeto> getMeusProjetos() {
		return meusProjetos;
	}

	public void setMeusProjetos(List<Projeto> meusProjetos) {
		this.meusProjetos = meusProjetos;
	}
	
}
