/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.util.List;
/**
 * class que gere um jogo entre dois jogadores, ao criar a class é passada informação relaiva ao jogador 1, posição dos barcos e sokect
 * @see WatingList
 * @author joao
 */
public class NewGame extends Thread{
    
    SocketServer sock1 = null;
    SocketServer sock2 = null;
    List<String> positionsList1 = null;
    List<String> positionsList2 = null;
    ProtoX proto1 = null; 
    ProtoX proto2 = null;
    String sClient1 = null;
    String sClient2 = null;
    int portaAvioes1 = 0;
    int navioDeGuerra1 = 0;
    int cruzador1 = 0;
    int submarino1 = 0;
    int destruidor1 = 0;
    int portaAvioes2 = 0;
    int navioDeGuerra2 = 0;
    int cruzador2 = 0;
    int submarino2 = 0;
    int destruidor2 = 0;
    
    NewGame(List<String> positionsList, SocketServer sock){
        this.sock1 = sock;
        this.positionsList1 = positionsList;
        proto1 = new ProtoX(sock);
    }
    
    /**
     * Metodo usado para guardar as informaçoes do jogador 2, guarda o que recebe em variaveis da class, Ainformação relativa ao primeiro jogador é passada no contrutor, este processo é gerido por WaitingList
     * @see WatingList
     * @param positionsList posicoes dos barcos
     * @param sock socket para comunicar
     */
    public void secondPlayer(List<String> positionsList, SocketServer sock){
        this.sock2 = sock;
        this.positionsList2 = positionsList;
        proto2 = new ProtoX(sock);
    }
    
    /**
     * verifica se o jogo ainda nao acabou, atraves do numero de tiros que cada barco levou
     * @return true se jogo ainda nao tiver acabado, false caso contrario
     */
    boolean gameIsAlive(){
        if((portaAvioes1 < 5 ||
            navioDeGuerra1 < 4 ||
            cruzador1 < 3 ||
            submarino1 < 3 ||
            destruidor1 < 2) &&
            (portaAvioes2 < 5 ||
            navioDeGuerra2 < 4 ||
            cruzador2 < 3 ||
            submarino2 < 3 ||
            destruidor2 < 2))
            return true;
        else
            return false;
    }
    
    
    /**
     * metodo run gere o jogo, recebe tiros intercalados de cada um dos jogadores, verifica se acertou em algum barco, envia uma resposta para quem enviou o tiro a dizer se acertou ou nao
     * e envia uma mensagem para quem o tiro é destinado com a posiçao e com a informaçao de que acertou ou na; Para alem disto envia tambem entre cada tiro uma mensagem a dizer se o jogo já acabou ou nao.
     * Para enviar as mensagens usa o ProtoX
     * @see ProtoX
     */
    @Override
    public void run (){
        int i;
        String returned1, returned2;
        proto1.confirmationNewGame(Integer.toString(1));
        proto2.confirmationNewGame(Integer.toString(2));
        
        while(gameIsAlive()){
            
            sClient1 = sock1.fromClient();
            returned1 = proto1.handler(sClient1);
            if(returned1.equals("Shot")){
                i = positionsList2.lastIndexOf(proto1.shot);
                if(i == -1){
                    proto2.sendShot(proto1.shot, i);
                    proto1.sendResponse(-1, "noHit");
                }else{
                    System.out.println(i);
                    if(i >= 0 && i <=4){
                        portaAvioes2++;
                        proto2.sendShot(proto1.shot, i);
                        if(portaAvioes2 == 5)
                            proto1.sendResponse(i, "portaAvioesDead");
                        else
                            proto1.sendResponse(i, "");
                    }else if(i >= 5 && i <=8){
                        navioDeGuerra2++;
                        proto2.sendShot(proto1.shot, i);
                        if(navioDeGuerra2 == 4)
                            proto1.sendResponse(i, "navioDeGuerraDead");
                        else
                            proto1.sendResponse(i, "");
                    }else if(i >= 9 && i <=11){
                        cruzador2++;
                        proto2.sendShot(proto1.shot, i);
                        if(cruzador2 == 3)
                            proto1.sendResponse(i, "cruzadorDead");
                        else
                            proto1.sendResponse(i, "");
                    }else if(i >= 12 && i <=14){
                        submarino2++;
                        proto2.sendShot(proto1.shot, i);
                        if(submarino2 == 3)
                            proto1.sendResponse(i, "submarinoDead");
                        else
                            proto1.sendResponse(i, "");
                    }else if(i >= 15 && i <=16){
                        destruidor2++;
                        proto2.sendShot(proto1.shot, i);
                        if(destruidor2 == 2)
                            proto1.sendResponse(i, "destruidorDead");
                        else
                            proto1.sendResponse(i, "");
                    }
                }
            }
            
            if(!gameIsAlive())
                break;
            
            proto1.gameIsAlive();
            proto2.gameIsAlive();


            sClient2 = sock2.fromClient();
            returned2 = proto2.handler(sClient2);
            if(returned2.equals("Shot")){
                i = positionsList1.lastIndexOf(proto2.shot);
                if(i == -1){
                    proto1.sendShot(proto2.shot, i);
                    proto2.sendResponse(-1, "noHit");
                }else{
                    if(i >= 0 && i <=4){
                        portaAvioes1++;
                        proto1.sendShot(proto2.shot, i);
                        if(portaAvioes1 == 5)
                            proto2.sendResponse(i, "portaAvioesDead");
                        else
                            proto2.sendResponse(i, "");
                    }else if(i >= 5 && i <=8){
                        navioDeGuerra1++;
                        proto1.sendShot(proto1.shot, i);
                        if(navioDeGuerra1 == 4)
                            proto2.sendResponse(i, "navioDeGuerraDead");
                        else
                            proto2.sendResponse(i, "");
                    }else if(i >= 9 && i <=11){
                        cruzador1++;
                        proto1.sendShot(proto1.shot, i);
                        if(cruzador1 == 3)
                            proto2.sendResponse(i, "cruzadorDead");
                        else
                            proto2.sendResponse(i, "");
                    }else if(i >= 12 && i <=14){
                        submarino1++;
                        proto1.sendShot(proto1.shot, i);
                        if(submarino1 == 3)
                            proto2.sendResponse(i, "submarinoDead");
                        else
                            proto2.sendResponse(i, "");
                    }else if(i >= 15 && i <=16){
                        destruidor1++;
                        proto1.sendShot(proto1.shot, i);
                        if(destruidor1 == 2)
                            proto2.sendResponse(i, "destruidorDead");
                        else
                            proto2.sendResponse(i, "");
                    }
                }
            }
            proto1.gameIsAlive();
            proto2.gameIsAlive();
        }
        proto1.gameOver();
        proto2.gameOver();
    }
}