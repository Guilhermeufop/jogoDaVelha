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
public class Jogador {
    private char caracter;
    private int tipo;

    public Jogador(char caracter, int tipo) {
        this.caracter = caracter;
        this.tipo = tipo;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        if(tipo == 0){
            return "HUMANO (" + caracter + ")\n";
        }
        return "MÁQUINA (" + caracter + ")\n";
    }
       
}
