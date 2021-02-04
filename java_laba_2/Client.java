package java_laba_2;

import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client extends Thread {

    public DatagramSocket socket;
    private boolean stoped = false;
    public Surface surface;
    private int portIn, portOut;

    private void Stop() {
        stoped = true;
    }

    Client(Surface s, String ip, int port_out, int port_in) {
        surface = s;
        portIn = port_in;
        portOut = port_out;
        try {
            socket = new DatagramSocket(port_in, InetAddress.getByName(ip));
            socket.setSoTimeout(10000);
            System.out.println("### CLIENT: started - " + ip + ':' + port_in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDaemon(true);
        setPriority(NORM_PRIORITY);
    }

    @Override
    public void run() {
        while (stoped != true) {
            try {
                Thread.sleep(100);
                byte data[] = new byte[4096];
                DatagramPacket pac = new DatagramPacket(data, data.length);

                socket.receive(pac);

                ByteArrayInputStream bis = new ByteArrayInputStream(data);
                ObjectInput in;

                in = new ObjectInputStream(bis);
                surface.objects = ( CopyOnWriteArrayList<Drawable>) in.readObject();
                bis.close();
                in.close();

            } catch (SocketTimeoutException ste) {
                Log.ln("CLIENT : timeout");
                break;
            } catch (Exception e) {
                e.printStackTrace();
                Stop();
            }
        }
        Log.ln("CLIENT: stop running");
    }
}
