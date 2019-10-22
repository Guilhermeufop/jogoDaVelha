/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.Random;

/**
 *
 * @author Guilherme
 */
public class Jogo {
    private Posicao matriz[][] = new Posicao[3][3];
    private Jogador jogadores[] = new Jogador[2];
    private boolean status = false;
    private Jogador vencedor = null;
    private Jogador turno = null;
    
   public Jogo() {
        this.iniciarMatriz();
        this.jogadores[0] = null;
        this.jogadores[1] = null;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public Jogador getTurno() {
        return turno;
    }

    public void setTurno(Jogador turno) {
        this.turno = turno;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String toString() {
        String matriz = "\n";
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                String valor = " ";
                if(this.matriz[i][j].getJogador() != null){
                    if(this.matriz[i][j].getJogador().getCaracter() == 'X'){
                        valor = " X ";
                    }
                    else if(this.matriz[i][j].getJogador().getCaracter() == 'O') {
                        valor = " O ";
                    }
                }
                else{
                    valor = " " + String.valueOf(this.matriz[i][j].getIndice()) + " ";
                }
                if(j == 0 || j == 1){
                    matriz += valor + "|";
                }
                else{
                    matriz += valor + "\n";
                }
                if(i != 2 && j == 2){
                    matriz += "------------\n";
                }
            }
        }
        if(vencedor != null){
            if(vencedor.getTipo() == 0){
                matriz += "\nTurno: HUMANO ( " + vencedor.getCaracter() + " )\n";
            }
            else{
                matriz += "\nTurno: MÁQUINA ( " + vencedor.getCaracter() + " )\n";
            }
        }
        else if(turno != null){
            if(turno.getTipo() == 0){
                matriz += "\nTurno: HUMANO ( " + turno.getCaracter() + " )\n";
            }
            else{
                matriz += "\nTurno: MÁQUINA ( " + turno.getCaracter() + " )\n";
            }
        }
        return matriz;
    }
    
    private void iniciarMatriz() {
        int indice = 1;
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                matriz[i][j] = new Posicao(indice, i, j);
                indice++;
            }
        }       
    }
    
    public void addJogador(char caracter, int tipo){
        Jogador j = new Jogador(caracter, tipo);
        if(jogadores[0] == null){
            this.jogadores[0] = j;
        }
        else{
            this.jogadores[1] = j;
        }
        
    }
    
    public void definirTurno(){
        Random gerador = new Random();
        int indice = gerador.nextInt(1);
        this.setTurno(jogadores[indice]);
        System.out.println("Indice: " + indice);
        System.out.println(turno.getTipo() + " " + turno.getCaracter());
    }
    
    public boolean posicaoValida(int posicao){
        switch(posicao){
            case 0:
                 if(matriz[0][0].getJogador() == null){
                     return true;
                 }
                 break;
            case 1:
                 if(matriz[0][1].getJogador() == null){
                     return true;
                 }
                 break;
            case 2:
                 if(matriz[0][2].getJogador() == null){
                     return true;
                 }
                 break;
            case 3:
                 if(matriz[1][0].getJogador() == null){
                     return true;
                 }
                 break;
            case 4:
                 if(matriz[1][1].getJogador() == null){
                     return true;
                 }
                 break;
            case 5:
                 if(matriz[1][2].getJogador() == null){
                     return true;
                 }
                 break;
            case 6:
                 if(matriz[2][0].getJogador() == null){
                     return true;
                 }
                 break;
            case 7:
                 if(matriz[2][1].getJogador() == null){
                     return true;
                 }
                 break;
            case 8:
                 if(matriz[2][2].getJogador() == null){
                     return true;
                 }
                 break;
        }
        return false;
    }
    
    public void jogar(int posicao){
        if(this.status == true){
            return;
        }
        switch(posicao){
            case 0:
                matriz[0][0].setJogador(turno);
                break;
            case 1:
                matriz[0][1].setJogador(turno);
                break;
            case 2:
                matriz[0][2].setJogador(turno);
                break;
            case 3:
                matriz[1][0].setJogador(turno);
                break;
            case 4:
                matriz[1][1].setJogador(turno);
                break;
            case 5:
                matriz[1][2].setJogador(turno);
                break;
            case 6:
                matriz[2][0].setJogador(turno);
                break;
            case 7:
                matriz[2][1].setJogador(turno);
                break;
            case 8:
                matriz[2][2].setJogador(turno);
                break;
        }
        Jogador ganhador = this.verificarGanhador();
        if(ganhador == null){
            int cont = 9;
            boolean stop = false;
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    if(matriz[i][j].getJogador() == null){
                        stop = true;
                        break;
                    }
                    cont--;
                }
                if(stop == true){
                    break;
                }
            }
            if(cont == 0){
                this.setStatus(true);                
            }  
        }        
    }
    
    public int isVencedor(){
        int pontuacao1[] = new int[8];
        int pontuacao2[] = new int[8];
        for(int i = 0; i < 8; ++i){
            pontuacao1[i] = 0;
            pontuacao2[i] = 0;
        }
        
        /*
        pontuacao1 = 'X'
        pontuacao2 = 'Y'
        
        pontuacao 0: Linha 0
        pontuacao 1 = Linha 1
        pontuacao 2 = Linha 2
        pontuacao 3: Coluna 0
        pontuacao 4 = Coluna 1
        pontuacao 5 = Coluna 2
        pontuacao 6 = Diagonal 1
        pontuacao 7 = Diagonal 2
        */
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(matriz[i][j].getJogador() != null){
                    if(matriz[i][j].getJogador().getCaracter() == 'X'){
                        pontuacao1[i]++;
                        pontuacao1[j+3]++;
                        if(i == j){
                            pontuacao1[6]++;
                        }
                        if(i+j == 2){
                            pontuacao1[7]++;
                        }
                    }
                    if(matriz[i][j].getJogador().getCaracter() == 'O'){
                        pontuacao2[i]++;
                        pontuacao2[j+3]++;
                        if(i == j){
                            pontuacao2[6]++;
                        }
                        if(i+j == 2){
                            pontuacao2[7]++;
                        }
                    }    
                }
            }
        }
        for(int i = 0; i < 8; ++i){
            if(pontuacao1[i] == 3 || pontuacao2[i] == 3){
                return i;
            }
        }
        return -1;
    }
    
    public Jogador verificarGanhador(){
        if(this.isVencedor() != -1){
            this.setVencedor(turno);
            this.setStatus(true);
            return turno;
        }
        return null;
    }

    void alternarTurno() {
        if(this.status == false && turno.getTipo() == jogadores[0].getTipo()){
            turno = jogadores[1];
        }
        else if(this.status == false && turno.getTipo() == jogadores[1].getTipo()){
            turno = jogadores[0];
        }          
    }
}
