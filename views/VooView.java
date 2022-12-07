package views;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import core.ArquivoUtils;
import core.View;
import models.Aviao;
import models.Helicoptero;
import models.Jato;
import models.Pista;
import models.Voo;

public class VooView implements View<Voo> {

    private final Scanner scanner;

    public VooView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() throws Exception {
        System.out.println("Cadastar Voo");

        System.out.println("Informe o numero:");
        String numero = scanner.next();

        System.out.println("Informe a data:");
        String data = scanner.next();

        System.out.println("Informe a hora:");
        String hora = scanner.next();

        System.out.println("Informe a origem:");
        String origem = scanner.next();

        System.out.println("Informe o destino:");
        String destino = scanner.next();

        System.out.println("Informe o piloto:");
        String piloto = scanner.next();

        System.out.println("Informe o id do jato:");
        Integer idJato = scanner.nextInt();

        Jato jato = new Jato().getById(idJato);
        if (Objects.isNull(jato))
            throw new Exception("Jato não encontrado");

        System.out.println("Informe id do helicoptero:");
        Integer idHelicoptero = scanner.nextInt();

        Helicoptero helicoptero = new Helicoptero().getById(idHelicoptero);
        if (Objects.isNull(helicoptero))
            throw new Exception("Helicoptero não encontrado");

        System.out.println("Informe o id  do aviao:");
        Integer idAviao = scanner.nextInt();

        Aviao aviao = new Aviao().getById(idAviao);
        if (Objects.isNull(aviao))
            throw new Exception("Aviao não encontrado");

        System.out.println("Informe o id da pista:");
        Integer idPista = scanner.nextInt();

        Pista pista = new Pista().getById(idPista);
        if (Objects.isNull(pista))
            throw new Exception("Pista não encontrado");

        System.out.println("Informe a observação:");
        String observação = scanner.next();

        System.out.println("Informe o copiloto:");
        String copiloto = scanner.next();

        new Voo(numero, data, hora, origem, destino, piloto,
                copiloto, observação, idPista, pista, idAviao, aviao,
                idHelicoptero, helicoptero, idJato, jato);
    }

    @Override
    public void alterar() throws Exception {
        System.out.println("Atualizar Voo");

        System.out.println("Informe o id da voo");
        Integer id = scanner.nextInt();

        Voo voo = new Voo().getById(id);
        if (Objects.isNull(voo))
            throw new Exception("Voo não encontrada");

        System.out.println("Informe o numero:");
        String numero = scanner.next();

        System.out.println("Informe a data:");
        String data = scanner.next();

        System.out.println("Informe a hora:");
        String hora = scanner.next();

        System.out.println("Informe a origem:");
        String origem = scanner.next();

        System.out.println("Informe o destino:");
        String destino = scanner.next();

        System.out.println("Informe o piloto:");
        String piloto = scanner.next();

        System.out.println("Informe o id do jato:");
        Integer idJato = scanner.nextInt();

        Jato jato = new Jato().getById(idJato);
        if (Objects.isNull(jato))
            throw new Exception("Jato não encontrado");

        System.out.println("Informe id do helicoptero:");
        Integer idHelicoptero = scanner.nextInt();

        Helicoptero helicoptero = new Helicoptero().getById(idHelicoptero);
        if (Objects.isNull(helicoptero))
            throw new Exception("Helicoptero não encontrado");

        System.out.println("Informe o id  do aviao:");
        Integer idAviao = scanner.nextInt();

        Aviao aviao = new Aviao().getById(idAviao);
        if (Objects.isNull(aviao))
            throw new Exception("Aviao não encontrado");

        System.out.println("Informe o id da pista:");
        Integer idPista = scanner.nextInt();

        Pista pista = new Pista().getById(idPista);
        if (Objects.isNull(pista))
            throw new Exception("Pista não encontrado");

        System.out.println("Informe a observação:");
        String observação = scanner.next();

        System.out.println("Informe o copiloto:");
        String copiloto = scanner.next();

        voo.setNumero(numero);
        voo.setData(data);
        voo.setHora(hora);
        voo.setOrigem(origem);
        voo.setDestino(destino);
        voo.setPiloto(piloto);
        voo.setJato(jato);
        voo.setHelicoptero(helicoptero);
        voo.setAviao(aviao);
        voo.setPista(pista);
        voo.setObservação(observação);
        voo.setIdPista(idPista);
        voo.setIdHelicoptero(idHelicoptero);
        voo.setIdAviao(idAviao);
        voo.setIdJato(idJato);
        voo.setCopiloto(copiloto);
        voo.update();

    }

    @Override
    public void excluir() throws Exception {
        System.out.println("Excluir Voo");

        System.out.println("Informe o id da Voo");
        Integer id = scanner.nextInt();

        Voo voo = new Voo().getById(id);
        if (Objects.isNull(voo))
            throw new Exception("Voo não encontrada");

        voo.delete();
    }

    @Override
    public void listar() throws Exception {
        System.out.println("Listar Voo");

        System.out.println("Como deseja listar? ([T] Todos; [I] Por Id)");
        String listaPor = scanner.next();

        if ("T".equals(listaPor)) {
            List<Voo> voos = new Voo().getAll();
            for (Voo voo : voos) {
                System.out.println(voo);
            }
        }
        if ("I".equals(listaPor)) {
            Integer id = scanner.nextInt();

            Voo voo = new Voo().getById(id);
            if (Objects.isNull(voo))
                throw new Exception("Voo não encontrada");

            try (ArquivoUtils arquivo = new ArquivoUtils("./passagem_" + voo.getNumero())) {
                arquivo.escrever("----------- Passagem -----------");
                arquivo.escrever("Nº"+ voo.getNumero() +"Data:" + voo.getData()+" "+voo.getHora() +"  Pista Nº"+ voo.getPista());
                arquivo.escrever("Origem: " + voo.getOrigem() + " Destino: " + voo.getDestino());
                arquivo.escrever("Piloto: " + voo.getPiloto() ); 
                arquivo.escrever("Observação:" + voo.getObservação());
            }

            System.out.println(voo);
        }
    }

}
