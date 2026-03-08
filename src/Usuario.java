public class Usuario {

    private int código;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String tipo;
    private String senha;

    public Usuario(String nome, String cpf, String telefone, int código, String email, String tipo, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.código = código;
        this.email = email;
        this.tipo = tipo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTell() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCódigo() {
        return código;
    }

    public String getSenha() {
        return senha;
    }

    
    public String getEmail() {
        return email;
    }




}
