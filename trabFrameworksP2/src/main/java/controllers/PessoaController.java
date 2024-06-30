package controllers;

import models.Pessoa;
import dao.PessoaDAO;

import java.util.List;

public class PessoaController {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void create(Pessoa pessoa) {
        pessoaDAO.insert(pessoa);
    }

    public Pessoa searchById(int id) {
        return pessoaDAO.get(id);
    }

    public List<Pessoa> searchByName(String name) {
        return pessoaDAO.list(10, 0);  // Implementação correta deve filtrar por nome
    }

    public void editById(Pessoa pessoa) {
        pessoaDAO.update(pessoa);
    }

    public void deleteById(int id) {
        pessoaDAO.delete(id);
    }
}
