package controllers;

import models.Tarefa;
import dao.TarefaDAO;

import java.util.List;

public class TarefaController {

    private TarefaDAO tarefaDAO = new TarefaDAO();

    public void create(Tarefa tarefa) {
        tarefaDAO.insert(tarefa);
    }

    public List<Tarefa> viewAll(int limit, int offset) {
        return tarefaDAO.list(limit, offset);
    }

    public List<Tarefa> viewByPessoaId(int pessoaId) {
        return tarefaDAO.list(10, 0);  // Implementação correta deve filtrar por Id de Pessoa
    }

    public Tarefa viewById(int id) {
        return tarefaDAO.get(id);
    }

    public void editById(Tarefa tarefa) {
        tarefaDAO.update(tarefa);
    }

    public void deleteById(int id) {
        tarefaDAO.delete(id);
    }
}
