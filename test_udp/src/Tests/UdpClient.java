package Tests;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Date;

public class UdpClient implements Runnable{
    private String address;
    private int port;

    public UdpClient(String address, int port)
    {
        this.address = address;
        this.port = port;
    }

    @Override
    public void run() {

        InetAddress inetAddress = null;
        MulticastSocket gss = null;
        try
        {
            inetAddress = InetAddress.getByName(address);

            gss = new MulticastSocket(port);

            gss.joinGroup(inetAddress);

            byte[] buffer = new byte[8192];
            System.out.println("接收数据包启动！(启动时间: "+new Date()+")");
            while(true)
            {
                //建立一个指定缓冲区大小的数据包
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                gss.receive(dp);

                //解码组播数据包
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println(s);
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try
            {
                if (gss != null)
                {
                    gss.leaveGroup(inetAddress);
                    gss.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
