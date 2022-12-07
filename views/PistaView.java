package views;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import core.View;
import models.Pista;

public class PistaView implements View<Pista> {

    private final Scanner scanner;

    public PistaView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() throws Exception {
        System.out.println("Cadastar Pista");

        System.out.println("Informe o numero da pista");
        String numero = scanner.next();

        new Pista(numero);
    }

    @Override
    public void alterar() throws Exception {
        System.out.println("Atualizar Pista");

        System.out.println("Informe o id da pista");
        Integer id = scanner.nextInt();

        Pista pista = new Pista().getById(id);
        if (Objects.isNull(pista)) throw new Exception("Pista não encontrada");

        System.out.println("Informe o numero da pista");
        String numero = scanner.next();

        pista.setNumero(numero);
        pista.update();
    }

    @Override
    public void excluir() throws Exception {
        System.out.println("Excluir Pista");

        System.out.println("Informe o id da pista");
        Integer id = scanner.nextInt();

        Pista pista = new Pista().getById(id);
        if (Objects.isNull(pista))
            throw new Exception("Pista não encontrada");
        
        pista.delete();
    }

    @Override
    public void listar() throws Exception {
        System.out.println("Listar Hangar");

        System.out.println("Como deseja listar? ([T] Todos; [I] Por Id)");
        String listaPor = scanner.next();

        if ("T".equals(listaPor)) {
            List<Pista> pistas = new Pista().getAll();
            for (Pista pista : pistas) {
                System.out.println(pista);
            }
        }
        if ("I".equals(listaPor)) {
            Integer id = scanner.nextInt();

            Pista pista = new Pista().getById(id);
            if (Objects.isNull(pista))
                throw new Exception("Pista não encontrada");

            System.out.println(pista);
        }
    }
    
}
