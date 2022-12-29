public class Paciente {
    
    private int matricula;
    private String nome;
    private String cpf;
    private int idade;
    private String endereco;
    private String telefone;
    private String laudo;
    
    public Paciente(String nome, String cpf, int idade, String endereco, String telefone, String laudo) {
        this.matricula = (int)(Math.random() * 1000); // Gerador de matriculas aleatoria
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.laudo = laudo;
    }

    public int getMatricula() {
        return matricula;
    }
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getLaudo() {
        return laudo;
    }
    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", endereco=" + endereco + ", idade=" + idade + ", laudo=" + laudo
                + ", matricula=" + matricula + ", nome=" + nome + ", telefone=" + telefone + "]";
    }

}
