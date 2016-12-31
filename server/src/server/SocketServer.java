/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author joao
 * class usada para estabelecer comunicação entre cliente e servidor
 */
class SocketServer {

  PrintWriter out;
  BufferedReader in;
  static ServerSocket serverSocket = null;
  Socket clientSocket = null;
/**
 * cria a serverSocket na porta 4415 caso não tenha sido criada anteriormente e gurada numa varivel static da class.<br>
 * cria uma clientSocket para o novo cliente <br>
 * cria input e output Streams;
 * @throws IOException 
 */
  SocketServer() throws IOException {
      if(serverSocket == null){
        try {
            serverSocket = new ServerSocket(4415);
            System.out.println("Waiting on 4415.");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4415.");
            System.exit(1);
        }
      }
 
      
      try {
         clientSocket = serverSocket.accept();
         System.out.println("Client connected!");
      } catch (IOException e) {
         System.err.println("Accept failed.");
         System.exit(1);
      }
 
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      System.out.println("Conction established!");
  }
 
      String inputLine, outputLine;
      
      /**
       * recebe string do client;
       * @return (String), recebida do cliente;
       * @throws IOException ;
       */
      
      public String fromClient(){
        String s = null;
        try{
            s = in.readLine();
            
            System.out.println("Acabei de ler: " + s);
        }catch(IOException e){
            System.out.println("Erro ao comunicar com a socket");
        }
        return s;
      }
      /**
       * envia String para o cliente;
       * @param s - String que se pretende enviar;
       */
      public void toClient(String s){
        System.out.println("Vou escrever: " + s);
        out.println(s);
        out.flush();
      }
      
      /**
       * faz close() dos input e output streams criados no construtor da class;<br>
       * faz close() da clientSocket;
       * @throws IOException 
       */
      public void close() throws IOException{
        out.close();
        in.close();
        clientSocket.close();
      }
}