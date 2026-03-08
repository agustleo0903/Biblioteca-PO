import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();        

    System.out.println("=== LOGIN ===");
    System.out.print("Usuário: ");
    String nome = scanner.nextLine();

    System.err.print("Senha: ");
    String senha = scanner.nextLine();

    Usuario logado = biblioteca.fazerLogin(nome, senha);

    if (logado == null){
        System.out.println("Login Inválido");
        return;
    }

    System.out.println("Bem vindo," + logado.getNome());

    boolean rodando = true;
    while (rodando){
        System.out.println("\n==== MENU ====" );
        
        if(logado.getTipo().equals("ADMIN")){
            System.out.println("1. Listar Usuários");
            System.out.println("2. Listar Acervo");
            System.out.println("3. Cadastrar Livro");
            System.err.println("4. Cadastrar Usuário");
            System.err.println("0. Sair");
        } else{
            System.out.println("1. Listar Acervo");
            System.err.println("2. Emprestar Livro");
            System.out.println("3. Devolver Livro");
            System.out.println("0. Sair");
        }

        System.out.println("Escolha uma opçao: ");
        String opçao = scanner.nextLine().trim();

        switch (opçao) {
            case "1":
                if (logado.getTipo().equals("ADMIN"))
                    biblioteca.listarUsuarios();
                else
                    biblioteca.listarAcervo();
                break;
            case "2":
                if (logado.getTipo().equals("ADMIN"))
                    biblioteca.listarAcervo();
                 else
                    biblioteca.em();

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
