package servidor.main;

import java.io.IOException;
import servidor.entidad.Servidor;

public class Main {

    public static void main(String[] args) {
	
	
	try {
	    Thread servidor = new Servidor(5555);
	    servidor.start();
	} catch (IOException e) {
	    // TODO: handle exception
	}

    }

}
