package org.example.saltfish;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Serverdemo {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9000);
        //接收数据包
        byte[] bytes = new byte[1024];

        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

        socket.receive(packet);


        System.out.println(new String(packet.getData()));
        socket.close();
    }
}
