import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Biblioteca {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();

    private int seqUsuario = 1;
    private int seqLivro = 1;


    public Biblioteca(){
        usuarios.add(new Usuario("admin", "000", "000", gerarCodigoUsuario(), "qadmin@email", "ADMIN", "123"));

        livros.add(new Livro(gerarCodigoLivro(), "Dom Casmurro", "Machado de Assis"));
        livros.add(new Livro(gerarCodigoLivro(), "Dom Quixote", "Miguel de Cervantes"));
    }

    public int gerarCodigoUsuario(){
        return seqUsuario++;
    }

    public int gerarCodigoLivro(){
        return seqLivro++;
    }

    public void cadastrarUsuario(Usuario user){
        usuarios.add(user);
    }

    public Usuario fazerLogin(String nome, String senha){
        for(Usuario user : usuarios){
            if(user.getNome().equals(nome) && user.getSenha().equals(senha)){
                return user;
            }
        }
        return null;
    }

    public void listarUsuarios(){
         if(usuarios.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
            return;
        }

        String lista = "=== USUÁRIOS ===\n";
        for(Usuario user : usuarios){
            lista += user.getCodigo() + " - " + user.getNome() + " (" + user.getTipo() + ")\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }

    public void listarAcervo(){
        if(livros.isEmpty()){
            JOptionPane.showMessageDialog(null, "Acervo vazio.");
            return;
        }

        String lista = "=== ACERVO ===\n";
        for(Livro livro : livros){
            lista += livro.getCodigo() + " - " + livro.getTitulo()
                   + " | " + livro.getAutor()
                   + " | " + (livro.isDisponivel() ? "Disponível" : "Emprestado")
                   + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    public void emprestarLivro(int codigo){
        for(Livro livro : livros){
            if(livro.getCodigo() == codigo){
                if(livro.isDisponivel()){
                    livro.emprestar();
                    JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Livro já está emprestado.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não encontrado.");
    }


    public void devolverLivro(int codigo){
       for(Livro livro : livros){
            if(livro.getCodigo() == codigo){
                if(!livro.isDisponivel()){
                    livro.devolver();
                    JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Livro já está disponível.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não encontrado.");
    }
}
