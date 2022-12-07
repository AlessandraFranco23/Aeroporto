package views;

import java.util.Objects;
import java.util.Scanner;

import core.View;
import models.Aviao;
import models.Hangar;

public class HangarView implements View<Hangar> {

    private final Scanner scanner;

    public HangarView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() throws Exception {
        System.out.println("Cadastrar Hangar");
        
        System.out.println("Informe o local do Hangar:");
        String local = scanner.next();

        System.out.println("Informe o id do Avião");
        Integer idAviao = scanner.nextInt();
        
        Aviao aviao = new Aviao().getById(idAviao);
        if (Objects.isNull(aviao)) throw new Exception("Aviao não encontrado");

        new Hangar(local, idAviao);
    }

    @Override
    public void alterar() throws Exception {
        System.out.println("Alterar Hangar");

        System.out.println("Informe o id do Hangar:");
        Integer idHangar = scanner.nextInt();

        System.out.println("Informe o local do Hangar:");
        String local = scanner.next();

        Hangar hangar = new Hangar().getById(idHangar);
        hangar.setLocal(local);
    }

    @Override
    public void excluir() throws Exception {
        System.out.println("Excluir Hangar");

        System.out.println("Informe o id do Hangar:");
        Integer idHangar = scanner.nextInt();
        
        Hangar hangar = new Hangar().getById(idHangar);
        if (Objects.isNull(hangar)) throw new Exception("Hangar não encontrado");

        hangar.delete();
    }

    @Override
    public void listar() throws Exception {
        System.out.println("Listar Hangar");

        System.out.println("Como deseja listar? ([T] Todos; [I] Por Id)");
        String listaPor = scanner.next();

        if ("T".equals(listaPor)) {
            for (Hangar hangar : new Hangar().getAll()) {
                System.out.println(hangar);
            }
        }
        if ("I".equals(listaPor)) {
            System.out.println("Informe o id");
            Integer id = scanner.nextInt();

            Hangar hangar = new Hangar().getById(id);
            if (Objects.isNull(hangar))
                throw new Exception("Hangar não encontrada");
            System.out.println(hangar);
        }

    }
    
}
