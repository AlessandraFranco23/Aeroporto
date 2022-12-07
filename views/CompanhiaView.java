package views;

import java.util.Objects;
import java.util.Scanner;

import core.View;
import models.Companhia;

public class CompanhiaView implements View<Companhia> {

    private final Scanner scanner;

    public CompanhiaView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() throws Exception {
        System.out.println("Cadastrar Companhia");
        System.out.println("Informe o nome da companhia:");
        String nome = scanner.next();

        System.out.println("Informe o CNPJ da companhia:");
        String cnpj = scanner.next();

        new Companhia(nome, cnpj);
    }

    @Override
    public void alterar() throws Exception {
        System.out.println("Atualizar Companhia");

        System.out.println("Informe o id da companhia:");
        Integer id = scanner.nextInt();

        Companhia companhia = new Companhia().getById(id);
        if (Objects.isNull(companhia))
            throw new Exception("Companhia não encontrada");

        System.out.println("Informe o nome da companhia:");
        String nome = scanner.next();

        System.out.println("Informe o CNPJ da companhia:");
        String cnpj = scanner.next();

        companhia.setNome(nome);
        companhia.setCnpj(cnpj);

        companhia.update();

    }

    @Override
    public void excluir() throws Exception {
        System.out.println("Deletar  Companhia");

        System.out.println("Informe o id da companhia:");
        Integer id = scanner.nextInt();

        Companhia companhia = new Companhia().getById(id);
        if (Objects.isNull(companhia))
            throw new Exception("Companhia não encontrada");
        companhia.delete();
    }

    @Override
    public void listar() throws Exception {
        System.out.println("Listar Companhia");

        System.out.println("Como deseja listar? ([T] Todos; [I] Por Id)");
        String listaPor = scanner.next();
        
        if ("T".equals(listaPor)) {
            for (Companhia companhia : new Companhia().getAll()) {
                System.out.println(companhia.getNome() + " - " + companhia.getCnpj());
            }
        }
        if ("I".equals(listaPor)) {
            System.out.println("Informe o id");
            Integer id = scanner.nextInt();

            Companhia companhia = new Companhia().getById(id);
            if (Objects.isNull(companhia))
                throw new Exception("Companhia não encontrada");
            System.out.println(companhia);
        }

    }

}
