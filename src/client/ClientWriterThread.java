package client;

import util.SocketUtil;

import java.util.Scanner;

public class ClientWriterThread implements Runnable{
    Thread t;
    SocketUtil socketUtil;
    public ClientWriterThread(SocketUtil socketUtil){
        this.socketUtil = socketUtil;
        this.t = new Thread(this);
        this.t.start();
    }

    public  void run(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            try {
                this.socketUtil.writeSocket(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
