public class Livro {
    private int código;
    private String título;
    private String autor;
    private boolean disponível;

    public Livro(int código, String título, String autor, boolean disponível) {
        this.código = código;
        this.autor = autor;
        this.título = título;
        this.disponível = true;
    }

    public int getCódigo(){
        return código;
    }

    public String getTítulo(){
        return título;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isDisponível(){
        return disponível;
    }

    public void emprestar(){
        disponível = false;
    }

      public void devolver(){
        disponível = true;
    }


}
