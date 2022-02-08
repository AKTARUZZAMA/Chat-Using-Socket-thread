package server;

import util.SocketUtil;

import java.util.Scanner;

public class ServerWriteThread implements  Runnable{
    Thread t ;
    SocketUtil socketUtil;
    public ServerWriteThread(SocketUtil socketUtil){
        this.socketUtil = socketUtil;
        this.t = new Thread(this);
        this.t.start();
    }
    @Override
    public void run() {
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
