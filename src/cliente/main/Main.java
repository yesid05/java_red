package cliente.main;

import java.io.IOException;
import java.net.UnknownHostException;

import cliente.entidad.Cliente;

public class Main {

    public static void main(String[] args) {
	String unNombre = "yesid";
	int unPuerto = 5555;
	    try {
		Cliente cliente = new Cliente(unNombre, unPuerto);
	    } catch (UnknownHostException e) {
		System.err.println("Error en el host: "+e.getMessage());
		e.printStackTrace();
	    } catch (IOException e) {
		System.err.println("Error: "+e.getMessage());
		e.printStackTrace();
	    }
	
    }

}
