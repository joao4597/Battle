package interfacejogo;


import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ProtoX {
    
    SocketClient sock = null;
    private String position;
    
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
     * @param username
     * @param password
     * @return (integer), 0 em caso de sucesso, 1 caso contrário;
     */
    public int login(String username, String password){
        
        String returned;
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
            return 0;
        }else if(returned.equals("##Denied##")){
            return 1;
        }
        return -1;
    }
    
    
    /**
     * usado para enviar um pedido de registo para o servidor;<br>
     * recebe e interpreta a resposta do servidor. (Registo pode não ser aceite caso username já exista);<br>
     * @param username
     * @param password
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
            System.out.println("receivedShot-> Blue " + position);
            return "blue";
        }else{
            returned = returned.replaceFirst("##Shot##", "");
            position = returned.substring(0, returned.indexOf("##"));
            System.out.println("receivedShot-> Red " + position);
            return "red";
        }
    }
    
    public String gameState(){
        return sock.fromServer();
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public String newGame(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q){
        String returned;
        sock.toServer("##NewGame##" + a + "##" + b + "##" + c + "##" + d + "##" + e + "##" + f + "##" + g + "##" + h + "##" + i + "##" + j + "##" + k + "##" + l + "##" + m + "##" + n + "##" + o + "##" + p + "##" + q + "##");
        returned = sock.fromServer();
        System.out.println(returned);
        return returned;
        /*if(returned.equals("##Accepted1##")){
            for(i=1; i<30 && true; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProtoX.class.getName()).log(Level.SEVERE, null, ex);
                }
            sock.toServer("##shot##A" + Integer.toString(i) + "##");
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            if(returned.equals("##GameOver##")){
                System.out.println("Entrou no break!!-> " + returned);
                break;
            }else{
                System.out.println("Nao Entrou no break!!-> " + returned);
            }
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            if(returned.equals("##GameOver##"))
                break;
            try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProtoX.class.getName()).log(Level.SEVERE, null, ex);
                }
            sock.toServer("##shot##B" + Integer.toString(i) + "##");
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            if(returned.equals("##GameOver##")){
                System.out.println("Entrou no break!!-> " + returned);
                break;
            }else{
                System.out.println("Nao Entrou no break!!-> " + returned);
            }
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            if(returned.equals("##GameOver##"))
                break;
            }
            
        }else{
            for(i=1; i<=30 && true; i++){
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            if(returned.equals("##GameOver##"))
                break;
            sock.toServer("##shot##A" + Integer.toString(i) + "##");
            returned = sock.fromServer();
            System.out.println(returned);
            returned = sock.fromServer();
            System.out.println(returned);
            try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProtoX.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(returned.equals("##GameOver##"))
                break;
            }
        }*/
    }
    
}