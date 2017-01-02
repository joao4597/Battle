/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import database.LoginDB;
import database.RankingDB;
import database.RegisterDB;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *cada uma destas classes trata de todos os pedidos de um determinado cliente
 * @author joao
 * 
 */

public class ClientThreads extends Thread{
    
    SocketServer sock = null;
    PlayersLogedIn playersLogedIn = null;
    String username = null;
    /**
     * 
     * @param sock -objeto da socket para comunicar com o cliente
     * gurada o objeto numa variável global
     */
    ClientThreads(SocketServer sock, PlayersLogedIn playersLogedIn){
        this.sock = sock;
        this.playersLogedIn = playersLogedIn;
    }
    /**
     * Thread dedicada exclusivamente a um cliente; <br>
     * está constantemente a ler da socket, quando esta recebe alguma coisa
     * usa a class ProtoX para interpretar o pedido;<br>
     * caso seja um pedido de login usa a Class LoginDB para o concretizar;<br>
     * caso seja um pedido de registo usa a class RegisterDB para o concretizar;<br>
     * mediante o resultado das ações usa a class ProtoX para devolver a resposta
     * ao cliente;
     * @see LoginDB
     * @see RegisterDB
     */
    @Override
    public void run (){
        
        String returned;
        boolean retrunedB;
        String usernameUlt = "wer";
        ProtoX proto = new ProtoX(sock);
        
        try{
        String str;
        while((str=sock.fromClient())!=null){      
            returned = proto.handler(str);
            if(returned.equals("Login")){
                LoginDB loginDB = new LoginDB();
                if(loginDB.confirmeLogin(proto.string_1, proto.string_2)){
                    if(playersLogedIn.addPlayer(proto.string_1)){
                        proto.loginConfirmation(loginDB.wins, loginDB.losses, loginDB.points);
                        this.username = proto.string_1;
                        usernameUlt = proto.string_1;
                        System.out.println("Guardei username:" + this.username + proto.string_1);
                    }else
                        proto.denied();
                }else{
                    proto.denied();
                }
            }else if(returned.equals("Register")){
                RegisterDB registerDB = new RegisterDB();
                if(registerDB.register(proto.string_1, proto.string_2)){
                    proto.confirmation();
                }else{
                    proto.denied();
                }
            }else if(returned.equals("Ranking")){
                RankingDB rankingDB = new RankingDB();
                returned = rankingDB.getRanking();
                proto.sendRanking(returned);
            }else if(returned.equals("Publicity")){
                proto.sendPublicity();
            }else if(returned.equals("NewGame")){
                WatingList watingList = new WatingList(proto.positionsList, sock, usernameUlt);
                System.out.println("Chamou WaitingList com username:" + this.username);
                NewGame newGame = watingList.returnThread();
                if(watingList.returnOrder() == 1){
                    while(newGame.isAlive() == false);
                    try {
                        System.out.println("Jogador 1 á espera do join");
                        newGame.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClientThreads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        System.out.println("Jogador 2 á espera do join");
                        newGame.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClientThreads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Jogo Terminado");
            }
        }
        sock.close();
        playersLogedIn.removePlayer(username);
        }catch(IOException e){
            System.out.printf("Excepção com sockets");
        }
    }    
}
