import Tests.UdpClient;
import Tests.UdpServer;

public class Application {
    public static void main(String[] args) {
        args = new String[]{"1", "255.255.255.255", "8888"};
        System.out.println("1是服务端2是客户端");
        System.out.println(args[0]+"  "+args[1]+"  "+args[2]);
        if (args[0] == "1"){
            new Thread(new UdpServer(args[1],Integer.valueOf(args[2]))).start();
        }else {
            new Thread(new UdpClient(args[1],Integer.valueOf(args[2]))).start();
        }
    }
}
