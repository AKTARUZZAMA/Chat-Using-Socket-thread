package client;

import util.SocketUtil;
import util.config;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(config.host, config.port);
        System.out.println("#Connected...");


        SocketUtil socketUtil = new SocketUtil(socket);
        new ClientWriterThread(socketUtil);
        new ClientReader(socketUtil);

    }
}
