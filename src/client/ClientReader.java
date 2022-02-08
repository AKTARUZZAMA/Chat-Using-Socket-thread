package client;

import util.SocketUtil;

public class ClientReader implements Runnable {
    Thread t;
    SocketUtil socketUtil;

    public ClientReader(SocketUtil socketUtil) {
        this.socketUtil = socketUtil;
        this.t = new Thread(this);
        this.t.start();
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Server: "+socketUtil.readSocket());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
