package server;

import util.SocketUtil;

public class ServerReaderThread implements Runnable{
    Thread t ;
    SocketUtil socketUtil;
    public ServerReaderThread(SocketUtil socketUtil){
        this.socketUtil = socketUtil;
        this.t = new Thread(this);
        this.t.start();
    }


    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Client: "+this.socketUtil.readSocket());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
