/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_multi_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author russo.salvatore
 */
public class Server_multi_thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(5500);
               System.out.println("il server e attivo e in ascolto");  
            while(true){
                Socket client=server.accept();
                server_rino a=new server_rino (client);
                Thread funziona=new Thread(a);
                funziona.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server_multi_thread.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
