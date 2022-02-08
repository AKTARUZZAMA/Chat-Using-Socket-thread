package server;

import util.SocketUtil;
import util.config;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(config.port);
        System.out.println("#Server started at: "+ config.port);

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("#Client Connected.");
            SocketUtil socketUtil = new SocketUtil(socket);

            new ServerWriteThread(socketUtil);
            new ServerReaderThread(socketUtil);


        }
    }
}
