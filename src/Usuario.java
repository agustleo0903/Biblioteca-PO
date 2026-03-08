public class Usuario {

    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String tipo;
    private String senha;

    public Usuario(String nome, String cpf, String telefone, int codigo, String email, String tipo, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codigo = codigo;
        this.email = email;
        this.tipo = tipo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSenha() {
        return senha;
    }



}
