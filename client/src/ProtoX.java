
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class usada para comunicação
 * @author joao
 */
public class ProtoX {
    
    SocketClient sock = null;
    private User user = null;
    public String position;
    public List<String> ranking = new ArrayList<>();
    
    /**
     * Cria uma nova socket para comunicar com o servidor e guarda o objecto numa variável da class;
     */
    ProtoX(){
        try{
            sock = new SocketClient();
        }catch(IOException e){
            System.out.println("exceção sock");
        }
    }
    
    
    /**
     * usado para enviar a informação de login de forma a que o servidor a consiga interpretar;<br>
     * recebe uma resposta da socket, interpreta-a e retorna de acordo com o recebido;<br>
     * @param username username
     * @param password password
     * @return (integer), 0 em caso de sucesso, 1 caso contrário;
     */
    public int login(String username, String password){
        
        String returned, sWins, sLosses, sPoints;
        MessageDigest m=null;
        try{
            m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(),0,password.length());
        }catch(NoSuchAlgorithmException e){
            
        }  
        
        sock.toServer("##Login##" + username + "##" + new BigInteger(1,m.digest()).toString(16) + "##");
        returned=sock.fromServer();
        System.out.println(returned);
        
        if(returned.indexOf("##Accepted##")==0){
            returned = returned.replaceFirst("##Accepted##", "");
            
            sWins = returned.substring(0, returned.indexOf("##"));
            returned = returned.replaceFirst(sWins + "##", "");
            int wins = Integer.parseInt(sWins);
            
            sLosses = returned.substring(0, returned.indexOf("##"));
            returned = returned.replaceFirst(sLosses + "##", "");
            int losses = Integer.parseInt(sLosses);
            
            sPoints = returned.substring(0, returned.indexOf("##"));
            int points = Integer.parseInt(sPoints);
            
            this.user = new User(wins, username, "", points, wins, losses);

            return 0;
        }else if(returned.equals("##Denied##")){
            return 1;
        }
        return -1;
    }
    
    
    /**
     * usado para enviar um pedido de registo para o servidor;<br>
     * recebe e interpreta a resposta do servidor. (Registo pode não ser aceite caso username já exista);<br>
     * @param username username
     * @param password password
     * @return (integer), 0 em caso de sucesso, 1 caso contrário; 
     */
    public int register(String username, String password){
        
        String returned;
        MessageDigest m=null;
        try{
            m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(),0,password.length());
        }catch(NoSuchAlgorithmException e){
            
        }  
        sock.toServer("##Register##" + username + "##" + new BigInteger(1,m.digest()).toString(16) + "##");
        returned=sock.fromServer();
        
        switch (returned) {
            case "##Accepted##":
                return 0;
            case "##Denied##":
                return 1;
            default:
                break;
        }       
        return -2;
    }
    
    public String sendShot(String position){
        String returned;
        sock.toServer("##Shot##" + position + "##");
        returned = sock.fromServer();
        if(returned.contains("##noHit##")){
            return "blue";
        }else if(returned.contains("####")){
            return "red";
        }else{
            returned = returned.replaceFirst("##ResponseToShot##", "");
            return returned.substring(0, returned.indexOf("##"));
        }
    }
    
    public String receiveShot(){
        String returned;
        returned = sock.fromServer();
        if(returned.contains("Blue")){
            returned = returned.replaceFirst("##Shot##", "");
            position = returned.substring(0, returned.indexOf("##"));
            return "blue";
        }else{
            returned = returned.replaceFirst("##Shot##", "");
            position = returned.substring(0, returned.indexOf("##"));
            return "red";
        }
    }
    
    public String gameState(){
        return sock.fromServer();
    }
    
    public User getUser() {
        return this.user;
    }
    
    public String newGame(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q){
        String returned;
        sock.toServer("##NewGame##" + a + "##" + b + "##" + c + "##" + d + "##" + e + "##" + f + "##" + g + "##" + h + "##" + i + "##" + j + "##" + k + "##" + l + "##" + m + "##" + n + "##" + o + "##" + p + "##" + q + "##");
        returned = sock.fromServer();
        System.out.println(returned);
        return returned;
    }
    
    public int getRanking(){
        String returned;
        String stringAux;
        int i, a;
        sock.toServer("##Ranking##");
        returned = sock.fromServer();
        System.out.println(returned);
        returned = returned.replaceFirst("##Ranking##", "");
        i = Integer.parseInt(returned.substring(0, returned.indexOf("##")));
        returned = returned.replaceFirst(Integer.toString(i) + "##", "");
        
        for(a=0; a<(i*4); a++){
            stringAux = returned.substring(0, returned.indexOf("##"));
            ranking.add(stringAux);
            returned = returned.replaceFirst(stringAux + "##", "");
            System.out.println(stringAux);
        }

        return i;
    }
    
    /**
     * função usada para receber do servidor conjunto de urls
     * @return lista de urls
     */
    public List<URL> getImagesUrl(){
        String returned, aux;
        int i;
        List<URL> urls = new ArrayList<>();
        
        sock.toServer("##Publicity##");
        returned = sock.fromServer();
        
        returned = returned.replaceFirst("##", "");
        
        for(i = 0; i < 9; i++){
            aux = returned.substring(0, returned.indexOf("##"));
            try{
                urls.add(new URL(aux));
            }catch(MalformedURLException e){
                System.out.println("url mal formado");
            }
            returned = returned.replaceFirst( aux + "##", "");
            System.out.println(aux);
        }
        
        return urls;
    }
    
}