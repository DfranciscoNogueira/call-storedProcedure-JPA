package br.com.estudo.dto;

public class PessoaDTO {

    private int recebeId;

    private String recebeNome;

    private int recebeIdade;

    private String recebeGeneroSexual;

    public PessoaDTO() {
    }

    public PessoaDTO(int recebeId, String recebeNome, int recebeIdade, String recebeGeneroSexual) {
        this.recebeId = recebeId;
        this.recebeNome = recebeNome;
        this.recebeIdade = recebeIdade;
        this.recebeGeneroSexual = recebeGeneroSexual;
    }

    public int getRecebeId() {
        return recebeId;
    }

    public void setRecebeId(int recebeId) {
        this.recebeId = recebeId;
    }

    public String getRecebeNome() {
        return recebeNome;
    }

    public void setRecebeNome(String recebeNome) {
        this.recebeNome = recebeNome;
    }

    public int getRecebeIdade() {
        return recebeIdade;
    }

    public void setRecebeIdade(int recebeIdade) {
        this.recebeIdade = recebeIdade;
    }

    public String getRecebeGeneroSexual() {
        return recebeGeneroSexual;
    }

    public void setRecebeGeneroSexual(String recebeGeneroSexual) {
        this.recebeGeneroSexual = recebeGeneroSexual;
    }

}
