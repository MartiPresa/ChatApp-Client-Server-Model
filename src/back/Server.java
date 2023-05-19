package back;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import UI.IVistaChat;

public class Server extends Thread{
	
	private ServerSocket serverSocket;
	private int puerto = 1234;
	private DataInputStream dis;
    private DataOutputStream dos;
	//hasmap de nickname con socket
    //final Socket s;
	private HashMap<String,Socket> clientes = new HashMap<>();
	private HashMap<String,String> chats = new HashMap<>();
	private ArrayList<Conexion> lista = new ArrayList<Conexion>(); 
	
    private boolean terminar = false;		// creo que el servidor no tiene que cortar
    
    
	public Server() {
		super();
		try {
			this.serverSocket = new ServerSocket(this.puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();
	}
	
	public void Conectar() throws IOException {
		
		 	//this.serverSocket = new ServerSocket(puerto);

	            Socket s = null;
	            String nickname;
	            String nicknameReceptor;
	            try 
	            {
	                s = serverSocket.accept();
	                
	               // System.out.println(s.isConnected());
	                 
	                DataInputStream dis = new DataInputStream(s.getInputStream());
	                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	                
	                nickname = dis.readUTF();
	                this.clientes.put(nickname,s);
	                
	                this.lista.add(new Conexion(s,nickname));
	                
	                System.out.println(this.clientes);
	                //nicknameReceptor = dis.readUTF();
	                //this.chats.put(nickname, dis.readUTF());
	                
	                
	                //System.out.println(nickname);
	                
	                //dis.readUTF();
	                //this.socket = s;
//	                this.messageManager = new MessageManager(s, dis, dos,this.vistaChat);
//	                this.conectionHandler = new ConectionHandler(s, dis, dos,this.vistaChat);
	                
	                //this.conectionHandler.start();
	                  
	            }
	            catch (Exception e){
	                s.close();
	                serverSocket.close();
	                e.printStackTrace();
	            }
	       
	    }
    
	//nickname del usuario con el que se va a conectar
	public void creaChat(String nickname,String nicknameReceptor) {
		
		if(this.clientes.containsKey(nicknameReceptor))
			this.chats.put(nickname, nicknameReceptor);
		else {
			// no se pudo crear el chat porque el nickname no esta registrado
		}
	}
	

	public void run() {

		String recibido;
		super.run();
		String mensaje = "Socket closed";
		int i;
		Socket socket;
		DataInputStream dis;
        DataOutputStream dos;
        
		//while(this.terminar == false && this.s.isClosed() != true) {
		while(this.terminar == false) {
			
//			i=0;
//			while(i < this.lista.size()) {
//				socket = this.lista.get(i).getSocket();
//				try {
//					dis = new DataInputStream(socket.getInputStream());
//					dos = new DataOutputStream(socket.getOutputStream());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
			
//			try {
//				recibido = dis.readUTF();
//				// enviar al cliente
//				
//			} 
//			catch (EOFException e) {
//				//e.printStackTrace();
//				this.terminarRecibirMensajes();
//			}
//			catch (SocketException e1) {
//				this.terminarRecibirMensajes();
//				//e1.printStackTrace();
//			}
//			catch (IOException e2) {
//				e2.printStackTrace();
//			}
	}
	}
	
	
//	public void terminarRecibirMensajes() {
//		//String mensaje = "El otro usuario se desconecto.\n";
//		this.terminar = true;
//		
//		//this.vista.getTextArea().setText(this.vista.getTextArea().getText()+"\n"+mensaje);
//		try {
//			this.dis.close();
//			this.dos.close();
//			this.s.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	

	
}