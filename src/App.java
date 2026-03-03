import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);        

    System.out.print("=======================================");
    System.out.print("= Bem vindo - Biblioteca =");
    System.out.print("=======================================");

    boolean rodando = true;
    while (true){
        System.out.println("=================================");
        System.out.println("= MENU");
        System.out.println("= 1. Listar acervo");
        System.out.println("= 0. Sair");
        System.out.println("=================================");

        System.out.println("Escolha uma opçao");
        String opçao = scanner.nextLine().trim();

        switch (opçao) {
            case "1":
                System.out.println("Acervo");
                break;
            case "0":
            rodando = false;
            System.out.println("Até a próxima");
                break;
                default:
                    System.out.println("Opçao invalida");
                    break;
        }
    }
    }
}
