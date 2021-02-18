/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_multi_thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author russo.salvatore
 */
public class server_rino implements Runnable{
private Socket clientsocket;

    public server_rino(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }

    @Override
    public void run() {
    try {
        //clientsocket.getInetAddress();
        System.out.println("serverino partito");
        OutputStream versoilclient = clientsocket.getOutputStream();
        InputStream dalClient = clientsocket.getInputStream();
        BufferedWriter scrittore=new BufferedWriter(new OutputStreamWriter(versoilclient));
        BufferedReader lettore = new BufferedReader(new InputStreamReader(dalClient));
        String risposta=lettore.readLine();
        System.out.println("iii");
        System.out.println(risposta);
        scrittore.write(risposta);
        scrittore.close();
        lettore.close();
         versoilclient.close();
         System.out.println("chiusura server effetuata");
    } catch (IOException ex) {
        Logger.getLogger(server_rino.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    }
    
}
