public class Usuario {

    private String código;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Usuario(String nome, String cpf, String telefone, String código, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.código = código;
        this.email = email;
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

}
