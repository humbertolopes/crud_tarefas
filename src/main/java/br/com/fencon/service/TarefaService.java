package br.com.fencon.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fencon.dao.TarefaDAO;
import br.com.fencon.model.Tarefa;

public class TarefaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaDAO tarefaDAO;
	
	
	public void salvar(Tarefa tarefa){
		 tarefaDAO.salvar(tarefa);
	}
	
	public void excluir(Tarefa tarefa){
		tarefaDAO.excluir(tarefa);
	}
	
	public List<Tarefa> listAll(){
		return tarefaDAO.listAll();
	}
	
	public Tarefa porId( Long id){
		return tarefaDAO.porId(id);
	}
	
}
