/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author joao
 * class usada para estabelecer o protocolo de comunicação entre cliente e servidor
 */
public class ProtoX {
    
    public String string_1, string_2, shot;
    public List<String> positionsList = new ArrayList<>();
    SocketServer sock;
    /**
     * Class usada para estabelecer o protocolo de comunicação entre cliente e servidor <br>
     * Guarda numa variavel da class o objeto da socket com a qual vai comunicar <br>
     * @param sock 
     */
    ProtoX(SocketServer sock){
        this.sock = sock;
    }
    
    
    /**
     * 
     * @param str - String recebida pela socket do client
     * @return (String), "Login" caso a string recebida da socket contenha informação de login, "Register" caso a string contenha informação de registo,
     * "NewGame" caso a string contenha a informação para novo jogo.
     */
    String handler(String str){
        int i;
        
        if(str.indexOf("##Login##")==0){
            str = str.replaceFirst("##Login##", "");
            string_1 = str.substring(0, str.indexOf("##"));
            str = str.replaceFirst(string_1 + "##", "");
            string_2 = str.substring(0, str.indexOf("##"));
            return "Login";
        }else if(str.indexOf("##Register##")==0){
            str = str.replaceFirst("##Register##", "");
            string_1 = str.substring(0, str.indexOf("##"));
            str = str.replaceFirst(string_1 + "##", "");
            string_2 = str.substring(0, str.indexOf("##"));
            return "Register";
        }else if(str.indexOf("##Ranking##")==0){
            return "Ranking";
        }else if(str.indexOf("##Publicity##")==0){
            return "Publicity";
        }else if(str.indexOf("##NewGame##")==0){
            positionsList.clear();
            str = str.replaceFirst("##NewGame##", "");
            for(i=0; i<17; i++){
                positionsList.add(str.substring(0, str.indexOf("##")));
                str = str.replaceFirst(positionsList.get(i) + "##", "");
            }
            return "NewGame";
        }else if(str.indexOf("##Shot##")==0){
            str = str.replaceFirst("##Shot##", "");
            shot = str.substring(0, str.indexOf("##"));
            //System.out.println("ProtoX-> " + shot);
            return "Shot";
        }
        return null;
    }
    
    /**
     * envia para o clinte uma mensagem de Confirmação, usada quando um confirmação é suficiente
     */
    void confirmation(){
        sock.toClient("##Accepted##");
    }
    /**
    * envia para o cliente uma mensagem de erro 
    */
    void denied(){
        sock.toClient("##Denied##");
    }
    
    void sendShot(String position, int i){
        if(i >= 0){
            sock.toClient("##Shot##" + position + "##Red##");
            System.out.println("sendShot-> ##Shot##" + position + "##Red##");
        }else{
            sock.toClient("##Shot##" + position + "##Blue##");
            System.out.println("sendShot-> ##Shot##" + position + "##Blue##");
        }
        
    }
    
    void sendResponse(int i, String death){
        if(i >= 0){
            sock.toClient("##ResponseToShot##" + death + "##Red##");
            System.out.println("##ResponseToShot##" + death + "##Red##");
        }else{
            sock.toClient("##ResponseToShot##" + death + "##Blue##");
            System.out.println("##ResponseToShot##" + death + "##Blue##");
        }
        
    }
    
    void gameOver(){
        sock.toClient("##GameOver##");
    }
    
    void gameIsAlive(){
        sock.toClient("##GameIsAlive##");
    }
    
    void confirmationNewGame(String order){
        sock.toClient("##Accepted" + order + "##");
    }
    
    void loginConfirmation(int wins, int losses, int points){
        sock.toClient("##Accepted##" + Integer.toString(wins) + "##" + Integer.toString(losses) + "##" + Integer.toString(points) + "##");
    }
    
    void sendRanking(String rank){
        sock.toClient(rank);
    }
    
    void sendPublicity(){
        String complete;
        int i;
        
        complete = "##";
        
        Path file = Paths.get("UrlList.txt");

        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader =
              new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                complete = complete + line + "##";
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        sock.toClient(complete);
        System.out.println(complete);
    }    
}
