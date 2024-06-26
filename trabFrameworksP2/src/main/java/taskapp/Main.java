package taskapp;

import controllers.PessoaController;
import controllers.TarefaController;

import java.util.Scanner;

public class Main {
    private static final PessoaController pessoaController = new PessoaController();
    private static final TarefaController tarefaController = new TarefaController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Deletar Pessoa");
            System.out.println("4. Atualizar Pessoa");
            System.out.println("5. Inserir Tarefa");
            System.out.println("6. Listar Tarefas");
            System.out.println("7. Deletar Tarefa");
            System.out.println("8. Atualizar Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    pessoaController.inserirPessoa();
                    break;
                case 2:
                    pessoaController.listarPessoas();
                    break;
                case 3:
                    pessoaController.deletarPessoa();
                    break;
                case 4:
                    pessoaController.atualizarPessoa();
                    break;
                case 5:
                    tarefaController.inserirTarefa();
                    break;
                case 6:
                    tarefaController.listarTarefas();
                    break;
                case 7:
                    tarefaController.deletarTarefa();
                    break;
                case 8:
                    tarefaController.atualizarTarefa();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
