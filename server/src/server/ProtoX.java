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
 *class usada para estabelecer o protocolo de comunicação entre cliente e servidor
 * @author joao
 * 
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
    public String handler(String str){
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
    public void confirmation(){
        sock.toClient("##Accepted##");
    }
    /**
    * envia para o cliente uma mensagem de erro 
    */
    public void denied(){
        sock.toClient("##Denied##");
    }
    
    /**
     * metodo usado para enviar tiro para o destinatário
     * @param position posiçao do tiro
     * @param i se i maior que -1 entao o tiro acertou num barco, a mensagem é enviada de acordo
     * @see SocketServer
     */
    public void sendShot(String position, int i){
        if(i >= 0){
            sock.toClient("##Shot##" + position + "##Red##");
            System.out.println("sendShot-> ##Shot##" + position + "##Red##");
        }else{
            sock.toClient("##Shot##" + position + "##Blue##");
            System.out.println("sendShot-> ##Shot##" + position + "##Blue##");
        }
        
    }
    
    /**
     * responde a quem enviou o tiro, para saber se acertou ou nao.
     * @param i se i maior que -1 então acertou, mensagem enviada de acordo
     * @param death barco que morreu, se algum morreu, caso contrario está vazia
     * @see SocketServer
     */
    public void sendResponse(int i, String death){
        if(i >= 0){
            sock.toClient("##ResponseToShot##" + death + "##Red##");
            System.out.println("##ResponseToShot##" + death + "##Red##");
        }else{
            sock.toClient("##ResponseToShot##" + death + "##Blue##");
            System.out.println("##ResponseToShot##" + death + "##Blue##");
        }
        
    }
    
    /**
     * envia mensagem pela socket de game over quando todos os barcos de um dos jogadores morreram
     * @see SocketServer
     */
    public void gameOver(){
        sock.toClient("##GameOver##");
    }
    
    /**
     * envia mensagem para a socket de que o jogo está vivo
     * @see SocketServer
     */
    public void gameIsAlive(){
        sock.toClient("##GameIsAlive##");
    }
    
    /**
     * Envia mensagem a confirmar que foi aceite para um novo jogo atravez da socket
     * @param order ordemde jogo, 1 se for jogador 1, 2 se for jogador 2
     * @see SocketServer
     */
    public void confirmationNewGame(String order){
        sock.toClient("##Accepted" + order + "##");
    }
    
    /**
     * envia para a socket confirmação de login, com os pontos, vitorias e derrotas.
     * @param wins vitorias do jogador
     * @param losses derrotas do jogador
     * @param points pontos do jogador
     * @see SocketServer
     */
    public void loginConfirmation(int wins, int losses, int points){
        sock.toClient("##Accepted##" + Integer.toString(wins) + "##" + Integer.toString(losses) + "##" + Integer.toString(points) + "##");
    }
    
    /**
     * envia para a socket o ranking ordenado por pontos
     * @param rank String com ranking ##Jogador1##Pontos##Vitorias##Derrotas##Jogador2##...
     * @see SocketServer
     */
    public void sendRanking(String rank){
        sock.toClient(rank);
    }
    
    /**
     * envia para a socket urls onde estão as imagens para a publicidade
     * @see SocketServer
     */
    public void sendPublicity(){
        String complete;
        int i;
        
        complete = "##";
        complete = complete + "https://s27.postimg.org/nirkevdib/mainr.jpg##"; 
        complete = complete + "https://s24.postimg.org/8oas5zyp1/pqueno1.jpg##";
        complete = complete + "https://s30.postimg.org/47g1e8fq9/pequeno2.jpg##";
        complete = complete + "https://s27.postimg.org/ovduui0bn/pqueno3.jpg##";
        complete = complete + "https://s23.postimg.org/lbckl6r57/pqueno4.png##";
        complete = complete + "https://s29.postimg.org/7by86r593/pequeno5.jpg##";
        complete = complete + "https://s24.postimg.org/mbil32l11/quick1.png##";
        complete = complete + "https://s30.postimg.org/etorfq5f5/quick2.jpg##";
        complete = complete + "https://s23.postimg.org/ia3pb4vu3/quick3.jpg##";
        
        
        
        
        /*Path file = Paths.get("UrlList.txt");

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
        }/**/
        sock.toClient(complete);
        System.out.println(complete);
    }    
}
