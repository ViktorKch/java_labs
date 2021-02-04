package java_laba_2;

import java.io.*;
import java.net.*;

public class Server extends Thread {

    DatagramSocket s;
    public Surface surface;
    private boolean stoped = false;
    private int portIn, portOut;
    private InetAddress addr;

    private void Stop() {
        stoped = true;
    }

    Server(Surface sf, String ip, int port_out, int port_in) {
        try {
            surface = sf;
            addr = InetAddress.getByName(ip);
            portIn = port_in;
            portOut = port_out;
            s = new DatagramSocket();
            Log.ln("### SERVER STARTED ");
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
                DatagramPacket pac;

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = null;
                try {
                    out = new ObjectOutputStream(bos);
                    out.writeObject(surface.objects);
                    byte[] blob = bos.toByteArray();
                    pac = new DatagramPacket(blob, blob.length, addr, portOut);
                    s.send(pac);
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        bos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        Log.ln("SERVER: stop running");
    }
}
