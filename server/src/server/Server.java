/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package server;

import java.io.*;

/**
 *
 * @author joao
 */

public class Server {

    /**
     * main() do servidor, está constantemente á espera de novos clentes <br>
     * cria uma nova clientSocket para cada novo cliente <br>
     * cria uma nova thread ClientThreads para tratar de todas a s necessidades de cada cliente <br>
     * @see ClientThreads
     * @param args the command line arguments
     * @throws java.io.IOException para o jre
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        SocketServer sock = null;
        ClientThreads threads = null;
        PlayersLogedIn playersLogedIn = new PlayersLogedIn();
        ReadInputs readInputs = new ReadInputs(playersLogedIn);
        readInputs.start();
        
        try{
            while(true){
                sock = new SocketServer();
                threads = new ClientThreads(sock, playersLogedIn);
                threads.start();
            }
        }catch(IOException e){
        }
    }
}
