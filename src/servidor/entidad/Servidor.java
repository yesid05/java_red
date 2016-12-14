package servidor.entidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Servidor extends Thread {
    //-------------------------
    //Atributos
  //-------------------------
    /**
     * Atributo para crear un socket para poder comunicarse
     */
    private ServerSocket servidor;

    /**
     * Atributo para leer datos primitivos
     */
    private DataInputStream ipsDatos;
    
    /**
     * Atributo para escribir datos primitivos
     */
    private DataOutputStream opsDatos;

    public Servidor(int unPuerto) throws IOException {
	servidor = new ServerSocket(unPuerto);
	servidor.setSoTimeout(10000);
    }

    @Override
    public void run() {
	while (true) {
	    try {
		System.out.println("Servidor-esperando al cliente en el puerto " + servidor.getLocalPort() + "...");
		Socket unServidor = servidor.accept();

		System.out.println("Servidor-soló conectado a: " + unServidor.getRemoteSocketAddress());
		ipsDatos = new DataInputStream(unServidor.getInputStream());
		System.out.println(ipsDatos.readUTF());

		opsDatos = new DataOutputStream(unServidor.getOutputStream());
		opsDatos.writeUTF("Servidor-gracias porla conexón a " + unServidor.getLocalSocketAddress() + "\nChao...");
		unServidor.close();

	    } catch (SocketTimeoutException s) {
		System.out.println("Error: " + s.getMessage());
		break;
		
	    } catch (IOException e) {
		System.err.println("Error " + e.getMessage());
		break;
	    }
	}
    }

}
