package Tests;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UdpServer implements Runnable{

    private String address;
    private int port;
    public UdpServer(String address, int port){
    this.address = address;
    this.port = port;
    }


    @Override
    public void run() {
        MulticastSocket gss = null;
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(address);

            gss = new MulticastSocket(port);

            gss.joinGroup(inetAddress);


            System.out.println("发送数据包启动！（启动时间"+new Date()+")");


            while(true)
            {
                String message = "测试消息 ----"+new Date();
                byte[] buffer = message.getBytes();

                DatagramPacket dp = new DatagramPacket(buffer, buffer.length,inetAddress,port);
                gss.send(dp);

                System.out.println("发送数据包给 "+inetAddress+":"+port);

                TimeUnit.SECONDS.sleep(3);
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
            if(gss!=null)
            {
                gss.leaveGroup(inetAddress);
                gss.close();
            }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
