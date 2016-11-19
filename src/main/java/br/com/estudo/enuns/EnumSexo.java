package br.com.estudo.enuns;

public enum EnumSexo {

    M(1, "Masculino"), 
    F(2, "Feminino");

    private int valor;
    private String descricao;

    private EnumSexo(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
