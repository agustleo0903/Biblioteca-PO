import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();

    public Biblioteca(){
        usuarios.add(new Usuario("admin","000", "000", 1, "admin@email", "ADMIN", "123"));
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
        for(Usuario user : usuarios){
            System.out.println(user.getCódigo() + "-" + user.getNome() + "(" + user.getTipo() + ")");
        }
    }

    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }

    public void listarAcervo(){
        for(Livro livro : livros){
            System.out.println(livro.getCódigo() + "-" + livro.getTítulo() + "|" + livro.getAutor() + (livro.isDisponível() ? "Disponível" : "Emprestado"));
        }
    }
}
