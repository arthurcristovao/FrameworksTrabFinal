package controllers;

import dao.PessoaDAO;
import models.Pessoa;

import java.util.List;
import java.util.Scanner;

public class PessoaController {
    private final PessoaDAO pessoaDao = new PessoaDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void inserirPessoa() {
        System.out.print("Nome da pessoa: ");
        String nome = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome);
        pessoaDao.insert(pessoa);
        System.out.println("Pessoa inserida com sucesso.");
    }

    public void listarPessoas() {
        List<Pessoa> pessoas = pessoaDao.list(10, 0);
        pessoas.forEach(p -> System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome()));
    }

    public void deletarPessoa() {
        System.out.print("ID da pessoa: ");
        int id = scanner.nextInt();
        pessoaDao.delete(id);
        System.out.println("Pessoa deletada com sucesso.");
    }

    public void atualizarPessoa() {
        System.out.print("ID da pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Pessoa pessoa = pessoaDao.get(id);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }
        System.out.print("Novo nome da pessoa: ");
        String nome = scanner.nextLine();
        pessoa.setNome(nome);
        pessoaDao.update(pessoa);
        System.out.println("Pessoa atualizada com sucesso.");
    }
}
