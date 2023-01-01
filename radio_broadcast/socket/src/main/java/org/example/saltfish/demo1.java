package org.example.saltfish;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//客户端
public class demo1 {
    public static void main(String[] args) throws Exception {


        DatagramSocket socket = new DatagramSocket();


        String mes = "hello server";

        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9000;
        DatagramPacket packet = new DatagramPacket(mes.getBytes(), 0, mes.getBytes().length, localhost, port);

        socket.send(packet);

        socket.close();
    }
}
