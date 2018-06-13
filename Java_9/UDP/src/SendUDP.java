import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendUDP {
    DatagramSocket socket =  new DatagramSocket();
    public SendUDP(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void sendMessages(String messages,int port) throws IOException {
        int length = messages.getBytes().length;
        DatagramPacket packet = new DatagramPacket(messages.getBytes(),length, InetAddress.getLocalHost(),port);
        socket.send(packet);
    }

    public static void main(String[] args) throws IOException {
        SendUDP  udp = new SendUDP(1414);
        udp.sendMessages("helloWorld",6666);
    }
}
