package br.ufc.si.itest.testes;

import java.util.List;

import br.ufc.si.itest.dao.SimuladoDao;
import br.ufc.si.itest.dao.impl.SimuladoDaoImpl;
import br.ufc.si.itest.model.Simulado;

public class TestaSimulado {
	public static void main(String[] args) {
		SimuladoDao simDao = new SimuladoDaoImpl();
		
		
			List<Simulado> simulados = simDao.list(40);
			
			
				System.out.println(simulados == null);
			
		
	}
}
