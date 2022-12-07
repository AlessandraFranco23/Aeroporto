import java.util.Scanner;

import core.View;
import views.AeronaveView;
import views.CompanhiaView;
import views.HangarView;
import views.PistaView;
import views.VooView;

public class App {
    public static void main(String[] args) throws Exception {

        int menu = 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Qual menu deseja:");
            System.out.println("[1] Voo\n[2] Aeronave\n[3] Companhia\n[4]Hangar\n[5]Pista");
            menu = scanner.nextInt();

            View view = null;


            switch (menu) {
                case 1:
                    view=new VooView(scanner);
                    break;
                case 2:
                    view = new AeronaveView(scanner);
                    break;
                case 3:
                    view = new CompanhiaView(scanner);
                    break;
                case 4:
                    view = new HangarView(scanner);
                    break;
                case 5:
                    view = new PistaView(scanner);
                    break;
            }

            System.out.println("O que deseja fazer?");
            System.out.println("[1] Cadastrar\n" +
                    "[2] Listar \n" +
                    "[3] Atualizar\n" +
                    "[4] Remover\n");

            String opcao = scanner.next();
            switch (opcao) {
                case "1":
                    view.cadastrar();
                    break;
                case "2":
                    view.listar();
                    break;
                case "3":
                    view.alterar();
                    break;
                case "4":
                    view.excluir();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        } while (menu != 1);

        scanner.close();
    }
}