package controllers;

import dao.TarefaDAO;
import dao.PessoaDAO;
import models.Tarefa;
import models.Pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TarefaController {
    private final TarefaDAO tarefaDao = new TarefaDAO();
    private final PessoaDAO pessoaDao = new PessoaDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void inserirTarefa() {
        System.out.print("ID da pessoa: ");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();
        Pessoa pessoa = pessoaDao.get(idPessoa);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }
        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Data e hora (yyyy-MM-dd): ");
        String dataHora = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataHora);
        Tarefa tarefa = new Tarefa(titulo, descricao, data);
        pessoa.addTarefa(tarefa);
        tarefaDao.insert(tarefa);
        System.out.println("Tarefa inserida com sucesso.");
    }

    public void listarTarefas() {
        List<Tarefa> tarefas = tarefaDao.list(10, 0);
        tarefas.forEach(t -> System.out.println("ID: " + t.getId() + ", Título: " + t.getTitulo() +
                ", Descrição: " + t.getDescricao() + ", Data: " + t.getDataHora() +
                ", Pessoa ID: " + t.getPessoa().getId()));
    }

    public void deletarTarefa() {
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        tarefaDao.delete(id);
        System.out.println("Tarefa deletada com sucesso.");
    }

    public void atualizarTarefa() {
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Tarefa tarefa = tarefaDao.get(id);
        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }
        System.out.print("Novo título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Nova descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Nova data e hora (yyyy-MM-dd): ");
        String dataHora = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataHora);
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDataHora(data);
        tarefaDao.update(tarefa);
        System.out.println("Tarefa atualizada com sucesso.");
    }
}
