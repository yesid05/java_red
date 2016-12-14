package cliente.entidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    // ---------------------------------
    // Atributos
    // ---------------------------------
    
    /**
     * Punto para comunicar dos máquinas
     */
    private Socket cliente;
    
    /**
     * Atributo para escribir bytes 
     */
    private OutputStream opsServer;
    
    /**
     * Atributo para escribir datos primitivos 
     */
    private DataOutputStream opsDatos;
    
    /**
     * Atributo para leer bytes
     */
    private InputStream ipsServer;
    
    /**
     * Atributo para leer datos primitivos
     */
    private DataInputStream ipsDatos;

    public Cliente(String unNombre,int unPuerto) throws UnknownHostException, IOException{
	System.out.println("Conectado a: "+unNombre+" en el puerto: "+unPuerto);
	cliente = new Socket(unNombre, unPuerto);
	
	System.out.println("Ciente-soló conectado a: "+cliente.getRemoteSocketAddress());
	opsServer = cliente.getOutputStream();
	opsDatos = new DataOutputStream(opsServer);
	opsDatos.writeUTF("Cliente-hola desde: "+cliente.getLocalSocketAddress());
	
	ipsServer = cliente.getInputStream();
	ipsDatos = new DataInputStream(ipsServer);
	
	System.out.println("Cliente-servidor... "+ipsDatos.readUTF());
	cliente.close();
    }
}
