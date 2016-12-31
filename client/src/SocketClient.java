
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class SocketClient{

    static Socket kkSocket = null;
    static PrintWriter out = null;
    static BufferedReader in = null;
    
    /**
     * cria socket para a porta 4415 para estabelecer comunicação com o servidor e guarda o objeto da comunicação numa variável da class <br>
     * cria streams de input e output e guarda os objetos em variáveis da class; <br>
     * @throws IOException 
     */
    public SocketClient() throws IOException {
        if(kkSocket==null){
            try {
                kkSocket = new Socket("localhost", 4415);
                System.out.println("Connected to server.");
                out = new PrintWriter(kkSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host: localhost.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to: localhost.");
                System.exit(1);
            }
        }
    }
 
    /**
     * lê string do servidor utilizando o stream de comunição e skocket previamente criados;
     * @return (String), string lida do servidor <br>
     */
    public String fromServer(){
        String s_FromServer = null;
        try{
            s_FromServer=in.readLine();
        }catch(IOException e){
            System.out.println("Erro ao ler da socket");
        }
        return s_FromServer;
    }
    /**
     * envia string para o servidor utilizando o stream de comunição e skocket previamente criados;
     * @param s string que se pretende enviar;
     */
    public void toServer(String s){
        out.println(s);
    }
    /**
     * faz close() da socket o streams creados pelo construtor da class;<br>
     * @throws IOException 
     */
    public void closeSocket() throws IOException{
        out.close();
        in.close();
        kkSocket.close();
    }
}

