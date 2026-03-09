
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) throws Exception {
    Biblioteca biblioteca = new Biblioteca();
    Usuario logado = null;        

    while(logado == null){

            String[] opcoes = {"🔐 Login", "📝 Cadastrar-se", "❌ Sair"};

            int escolha = JOptionPane.showOptionDialog(
                null,
                " 📚 Bem-vindo ao Sistema da Biblioteca",
                "Biblioteca",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if(escolha == 0){
                String nome = JOptionPane.showInputDialog("👤 Usuário:");
                String senha = JOptionPane.showInputDialog("🔒 Senha:");

                logado = biblioteca.fazerLogin(nome, senha);

                if(logado == null){
                    JOptionPane.showMessageDialog(null, "Login inválido");
                }
            }

            else if(escolha == 1){
                int cod = biblioteca.gerarCodigoUsuario();
                String nome = JOptionPane.showInputDialog("👤 Nome: ");
                String cpf = JOptionPane.showInputDialog("🆔 CPF: "); 
                String tell = JOptionPane.showInputDialog("📞 Telefone: ");
                String email = JOptionPane.showInputDialog("📧 Email: ");
                String senha = JOptionPane.showInputDialog("🔒 Senha: ");
                 Usuario novo = new Usuario(nome, cpf, tell, cod, email, "COMUM", senha);
                biblioteca.cadastrarUsuario(novo);

                JOptionPane.showMessageDialog(null, "Cadastro realizado! Faça login.");
            }
            else {
                System.exit(0);
            }
        }

        JOptionPane.showMessageDialog(
            null,
            "Bem-vindo, " + logado.getNome() + " (" + logado.getTipo() + ")"
        );

    boolean rodando = true;

    while (rodando){
        String menu;

            if(logado.getTipo().equals("ADMIN")){
                menu =
                    "👥 1 - Listar Usuários\n" +
                    "📚 2 - Listar Acervo\n" +
                    "➕  3 - Cadastrar Livro\n" +
                    "🧑 4 - Cadastrar Usuário\n" +
                    "🛡 5 - Cadastrar Admin\n" +
                    "🚪 0 - Sair";
            } else {
                menu =
                    "📚 1 - Listar Acervo\n" +
                    "📤2 - Emprestar Livro\n" +
                    "📤3 - Devolver Livro\n" +
                    "🚪0 - Sair";
            }

        String opçao = JOptionPane.showInputDialog(menu);
        if(opçao == null) break;

        switch (opçao) {
            case "1":
                    if(logado.getTipo().equals("ADMIN"))
                        biblioteca.listarUsuarios();
                    else
                        biblioteca.listarAcervo();
                    break;

                case "2":
                    if(logado.getTipo().equals("ADMIN")){
                        biblioteca.listarAcervo();
                    } else {
                        int cod = Integer.parseInt(
                            JOptionPane.showInputDialog("Código do livro: ")
                        );
                        biblioteca.emprestarLivro(cod);
                    }
                    break;

                case "3":
                    if(logado.getTipo().equals("ADMIN")){
                        String titulo = JOptionPane.showInputDialog("Título: ");
                        String autor = JOptionPane.showInputDialog("Autor: ");
                        int cod = biblioteca.gerarCodigoLivro();
                        biblioteca.cadastrarLivro(new Livro(cod, titulo, autor));
                        JOptionPane.showMessageDialog(null, "Livro cadastrado!");
                    } else {
                        int cod = Integer.parseInt(
                            JOptionPane.showInputDialog("Código do livro: ")
                        );
                        biblioteca.devolverLivro(cod);
                    }
                    break;

                case "4":
                    if(logado.getTipo().equals("ADMIN")){
                        int codUser = biblioteca.gerarCodigoUsuario();
                        String nome = JOptionPane.showInputDialog("👤 Nome:");
                        String cpf = JOptionPane.showInputDialog("🆔 CPF:");
                        String tell = JOptionPane.showInputDialog("📞 Telefone:");
                        String email = JOptionPane.showInputDialog("📧 Email:");
                        String senha = JOptionPane.showInputDialog("🔒 Senha:");

                        biblioteca.cadastrarUsuario(
                            new Usuario(nome, cpf, tell, codUser, email, "COMUM", senha)
                        );
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                    }
                    break;
                case "5":
                    if(logado.getTipo().equals("ADMIN")){
                       int codUser = biblioteca.gerarCodigoUsuario();
                        String nome = JOptionPane.showInputDialog("👤 Nome do admin:");
                        String cpf = JOptionPane.showInputDialog("🆔 CPF:");
                        String tel = JOptionPane.showInputDialog("📞 Telefone:");
                        String email = JOptionPane.showInputDialog("📧 Email:");
                        String senha = JOptionPane.showInputDialog("🔒 Senha:");

                        biblioteca.cadastrarUsuario(
                            new Usuario(nome, cpf, tel, codUser, email, "ADMIN", senha)
                        );
                        JOptionPane.showMessageDialog(null, "Admin cadastrado!");
                    }
                    break;

                case "0":
                    rodando = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }

        JOptionPane.showMessageDialog(null, "Até a próxima!");
    }
}

