/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DeleteUsersDB;
import database.GetUsersDB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class extends Thread, lê inputs do teclado e gere os servidor
 * @author joao
 */
public class ReadInputs extends Thread{
    
    PlayersLogedIn playersLogIn = null;
    
    ReadInputs(PlayersLogedIn playersLogedIn){
        this.playersLogIn = playersLogedIn;
    }
    /**
     * está constantemente a ler do teclado, pode receber "Ban username", para eliminar jogador; "List Players", para ver todos os jogadores incritos; "List Online Players", para listar jogadores online
     */
    @Override
    public void run (){
        String aux;
        List<String> listUs = new ArrayList<>();
        int i;
        Scanner scan = new Scanner(System.in);
        while(true){
            aux = scan.nextLine();
            if(aux.equals("List Players")){
                GetUsersDB listUsers = new GetUsersDB();
                listUs = listUsers.getUsers();
                for(i=0; i<listUs.size(); i++){
                    System.out.println(listUs.get(i));
                }
            }else if(aux.equals("List Online Players")){
                for(i=0; i<playersLogIn.playersLogedIn.size(); i++){
                    System.out.println(playersLogIn.playersLogedIn.get(i));
                }
            }else if(aux.contains("Ban")){
                aux = aux.substring(4, aux.length());
                System.out.println(aux);
                DeleteUsersDB delete = new DeleteUsersDB();
                delete.deleteUser(aux);
            }
        }
    }  
    
}
