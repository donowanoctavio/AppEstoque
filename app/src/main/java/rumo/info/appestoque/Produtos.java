package rumo.info.appestoque;

import android.util.Log;

public class Produtos {

    private int imagem;
    private int cod;
    private int qtd;
    private String desc;
    private String nome;

    public Produtos(int imagem, int cod, String nome, int qtd, String desc) {

        this.imagem = imagem;
        this.cod = cod;
        this.qtd = qtd;
        this.desc = desc;
        this.nome = nome;

        Log.i("Teste","criando Objeto Produto");
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
