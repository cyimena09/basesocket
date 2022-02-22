package be.cyimena;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("J'attends la connexion ...");
        Socket s = ss.accept(); // on accepte la connexion
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        System.out.println("J'attends que le client envoie une donnée ...");
        int nb = is.read();
        System.out.println("On a reçu un nombre : " + nb);
        int res = nb * 5;
        os.write(res);
        System.out.println("Après calcul, on retourne : " + res);
        s.close();
        System.out.println("On ferme la connexion.");
    }

}
