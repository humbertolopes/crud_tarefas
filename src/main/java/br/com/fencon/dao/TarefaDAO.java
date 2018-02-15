package br.com.fencon.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.fencon.exception.NegocioException;
import br.com.fencon.model.Tarefa;

@ApplicationScoped
public class TarefaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Tarefa> listaTarefas = new ArrayList<>();
	
	
	public Tarefa salvar(Tarefa tarefa){
		try {
			if(tarefa.isInclusao()){
				tarefa.setCriacao(new Date());
				tarefa.setId((long) listaTarefas.size());
				listaTarefas.add(tarefa);
			}
			else {
				tarefa.setEdicao(new Date());
			}
			
		} catch (Exception e) {
			throw new NegocioException("Não foi possível salvar a tarefa");
		}
		
		return null;
	}
	
	public void excluir(Tarefa tarefa){
		try {
			listaTarefas.remove(tarefa);
		} catch (Exception e) {
			throw new NegocioException("Tarefa não pode ser excluí­da");
		}
	}

	public Tarefa porId(Long id) {
		for(Tarefa tarefa: listaTarefas){
			if(tarefa.getId() == id) {
				return tarefa;
			}
		}
		return null;
	}
	
	public List<Tarefa> listAll(){
		return this.listaTarefas;
		
	}

}
