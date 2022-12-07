package views;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import core.View;
import models.Aeronave;
import models.Aviao;
import models.Companhia;
import models.Helicoptero;
import models.Jato;

public class AeronaveView implements View<Aeronave> {

    private final Scanner scanner;

    public AeronaveView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() throws Exception {
        System.out.println("Cadastrar aeronave");
        System.out.println("Informe qual tipo de aeronave é: ([A] Avião; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next().toUpperCase();

        if ("A".equals(tipo)) {
            System.out.println("Informe a marca ");
            String marca = scanner.next();

            System.out.println("Informe o modelo");
            String modelo = scanner.next();

            System.out.println("Informe o id da companhia");
            Integer idCompanhia = scanner.nextInt();
            Companhia companhia = new Companhia().getById(idCompanhia);
            if (Objects.isNull(companhia)) {
                throw new Exception("Companhia não encontrada");
            }

            System.out.println("Informe a capacidade");
            Integer capacidade = scanner.nextInt();

            System.out.println("Informe o prefixo");
            String prefixo = scanner.next();

            new Aviao(marca, modelo, companhia.getId(), companhia, capacidade, prefixo);
        }
        if ("H".equals(tipo)) {

            System.out.println("Informe a marca ");
            String marca = scanner.next();

            System.out.println("Informe o modelo");
            String modelo = scanner.next();

            System.out.println("Informe o cor");
            String cor = scanner.next();

            System.out.println("Informe a capacidade");
            Integer capacidade = scanner.nextInt();

            new Helicoptero(marca, modelo, cor, capacidade);
        }

        if ("J".equals(tipo)) {

            System.out.println("Informe a marca ");
            String marca = scanner.next();

            System.out.println("Informe o modelo");
            String modelo = scanner.next();

            System.out.println("Informe o cor");
            String cor = scanner.next();

            System.out.println("Informe a velocidade");
            Integer velocidade = scanner.nextInt();

            new Jato(marca, modelo, velocidade, cor);
        }
    }

    @Override
    public void alterar() throws Exception {
        System.out.println("Excluir aeronave");
        System.out.println("Informe qual tipo de aeronave é: ([A] Avião; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next().toUpperCase();

        System.out.println("Informe o id");
        Integer id = scanner.nextInt();

        if ("A".equals(tipo)) {
            Aviao aviao = new Aviao().getById(id);
            
            System.out.println("Informe a marca ");
            aviao.setMarca(scanner.next());

            System.out.println("Informe o modelo");
            aviao.setModelo(scanner.next());

            if (!Objects.isNull(aviao.getcompanhia())) {
                System.out.println("Informe o id da companhia");
                Integer idCompanhia = scanner.nextInt();
                Companhia companhia = new Companhia().getById(idCompanhia);
                if (Objects.isNull(companhia)) {
                    throw new Exception("Companhia não encontrada");
                }
                aviao.setcompanhia(companhia);
                aviao.setidCompanhia(idCompanhia);
            }


            System.out.println("Informe a capacidade");
            aviao.setCapacidade(scanner.nextInt());

            System.out.println("Informe o prefixo");
            aviao.setPrefixo(scanner.next());

            aviao.update();
        }
        if ("H".equals(tipo)) {
            Helicoptero helicoptero = new Helicoptero().getById(id);

            System.out.println("Informe a marca ");
            helicoptero.setMarca(scanner.next());

            System.out.println("Informe o modelo");
            helicoptero.setModelo(scanner.next());

            System.out.println("Informe o cor");
            helicoptero.setCor(scanner.next());

            System.out.println("Informe a capacidade");
            helicoptero.setCapacidade(scanner.nextInt());

            helicoptero.update();
        }
        if ("J".equals(tipo)) {
            Jato jato = new Jato().getById(id);

            System.out.println("Informe a marca ");
            jato.setMarca(scanner.next());

            System.out.println("Informe o modelo");
            jato.setModelo(scanner.next());

            System.out.println("Informe o cor");
            jato.setCor(scanner.next());

            System.out.println("Informe a velocidade");
            jato.setVelocidade( scanner.nextInt());

            jato.update();
        }
    }

    @Override
    public void excluir() throws Exception {

        System.out.println("Excluir aeronave");
        System.out.println("Informe qual tipo de aeronave é: ([A] Avião; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next().toUpperCase();
        
        System.out.println("Informe o id");
        Integer id = scanner.nextInt();

        if ("A".equals(tipo)) {
            new Aviao().getById(id).delete();
        }
        if ("H".equals(tipo)) {
            new Helicoptero().getById(id).delete();
        }
        if ("J".equals(tipo)) {
            new Jato().getById(id).delete();
        }

    }

    @Override
    public void listar() throws Exception {
        System.out.println("Listar aeronave");
        System.out.println("Informe qual tipo de aeronave é: ([A] Avião; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next().toUpperCase();

        System.out.println("Como deseja listar? ([T] Todos; [I] Por Id)");
        String listaPor = scanner.next();

        if ("A".equals(tipo)) {
            if ("T".equals(listaPor)) {
                List<Aviao> avioes = new Aviao().getAll();
                for (Aviao aviao : avioes) {
                    System.out.println(aviao.toString());
                }
            }
            if ("I".equals(listaPor)) {
                System.out.println("Informe o id");
                Integer id = scanner.nextInt();

                Aviao aviao = new Aviao().getById(id);
                System.out.println(aviao);
            }
        }
        if ("H".equals(tipo)) {
            if ("T".equals(listaPor)) {
                List<Helicoptero> helicopteros = new Helicoptero().getAll();
                for (Helicoptero helicoptero : helicopteros) {
                    System.out.println(helicoptero);
                }
            }
            if ("I".equals(listaPor)) {
                System.out.println("Informe o id");
                Integer id = scanner.nextInt();

                Helicoptero helicoptero = new Helicoptero().getById(id);
                System.out.println(helicoptero);
            }
        }
        if ("J".equals(tipo)) {
            if ("T".equals(listaPor)) {
                List<Jato> jatos = new Jato().getAll();
                for (Jato jato : jatos) {
                    System.out.println(jato);
                }

            }
            if ("I".equals(listaPor)) {
                System.out.println("Informe o id");
                Integer id = scanner.nextInt();

                Jato jato = new Jato().getById(id);
                System.out.println(jato);
            }
        }
    }

}
