/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Jogo;

/**
 * @author Virginia
 * 
 */
public interface JogoDao {

	public void save(Jogo jogo);

	public void remove(Jogo jogo);

	public void update(Jogo jogo);

	public List<Jogo> list();

	public List<Jogo> getJogoByProjeto(Integer projeto);

	public List<Jogo> getJogoByUsuario(Integer id_usuario);

	public List<Jogo> getJogoById(Integer id);

	public List<Jogo> getJogoByTurmaProjeto(Integer id_turma, Integer id_projeto);

	public List<Jogo> getJogoByUs�rioProjeto(Integer id_usuario,
			Integer id_projeto);
}// fim da interface
