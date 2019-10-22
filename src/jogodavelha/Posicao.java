/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author Guilherme
 */
public class Posicao {
    private int indice;
    private int linha;
    private int coluna;
    private Jogador jogador;

    public Posicao(int indice, int linha, int coluna) {
        this.indice = indice;
        this.linha = linha;
        this.coluna = coluna;
        this.jogador = null;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String toString() {
        if(jogador == null){
            return " ";
        }
        return String.valueOf(jogador.getCaracter());        
    }
    
    public boolean equals(char valor) {
        if (this.jogador.getCaracter() == valor) {
            return true;
        }
        if (this.jogador.getCaracter() != valor) {
            return false;
        }
        return false;
    }
}
