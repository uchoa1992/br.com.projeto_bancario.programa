package br.com.projeto_bancario.Programa;

public class Pessoa {

    private static int counter = 1;//contagem da quantidade de clientes no banco
    //static ele pertence à classe e não ao objeto, exemplo, a variável que for static é unica para todos os objetos criados
    //o primeiro cliente vai começar com o numero 1 e vai implementando, ele servirá como um ID

    private String nome; // declarando as variáveis privadas
    private String cpf;
    private String email;

    //criando o construtor passando com parâmetro as variáveis nome, cpf e e-mail

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        counter+=1; //toda ver que for criado um novo cliente será implementado em um no contador
    }

    // criando os métodos get e set de cada variável com exceção de counter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
