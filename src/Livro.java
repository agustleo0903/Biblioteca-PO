public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void emprestar(){
        disponivel = false;
    }

      public void devolver(){
        disponivel = true;
    }


}
