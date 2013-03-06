package br.ufc.si.itest.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.ejb.criteria.expression.ConcatExpression;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.CasoDeTeste;
import br.ufc.si.itest.model.CasoDeUso;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.Turma;
import br.ufc.si.itest.model.Usuario;



public class CriarTabelas {

	public static void exportarEsquema(List<Class<? extends Object>> classes)
	{
		AnnotationConfiguration annotConfig = adicionaClassesConfiguracao(classes);
		
		SchemaExport se = new SchemaExport(annotConfig);
		se.create(true, true);
	}
	
	private static AnnotationConfiguration adicionaClassesConfiguracao(List<Class<? extends Object>> classes) {
		AnnotationConfiguration annotConfig = new AnnotationConfiguration();
		
		for (Class<?> classe : classes) {
			annotConfig.addAnnotatedClass(classe);
		}
		
		return annotConfig;
  }
	
	public static org.hibernate.Session prepararSessao() {
		
		AnnotationConfiguration annotConfig = adicionaClassesConfiguracao(initialize());
		SessionFactory sf = annotConfig.buildSessionFactory();
		org.hibernate.Session session = sf.openSession();
		return session;
	}

	public static void reiniciaBanco() {
		
		exportarEsquema(initialize());
	}
	
	 private static List<Class<? extends Object>> initialize(){
		 
			List<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();
			
			classes.add(Aluno.class);
			classes.add(Administrador.class);
			classes.add(Professor.class);
			classes.add(Turma.class);
			
			classes.add(Jogo.class);
			return classes;
		}
}
