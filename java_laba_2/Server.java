
package java_laba_2;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private ServerSocket ssocket;
    Socket s;
    public Surface surface;
    Server(Surface sf, String ip, int port)
    {
        surface = sf;

        try {
            ssocket = new ServerSocket(port,0,InetAddress.getByName(ip));
            Log.ln("### SERVER STARTED: " + ssocket.getInetAddress().toString() + ':' + ssocket.getLocalPort());
        } catch (Exception e) { e.printStackTrace(); }
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        try {
            s = ssocket.accept();
        } catch (Exception e) { e.printStackTrace();}
    }
    @Override
    public void run()
    {
        while (true)
            try {
                if (!s.isClosed())
                {
                    Protocol.QueryData q = Protocol.ListenClient(s);

                    switch (q.code)
                    {
                        case (Protocol.CLEAR_LIST):
                        {
                            surface.objects.clear();
                            Log.ln("SERVER: list cleared");
                        } break;
                        case (Protocol.GET_OBJECT):
                        {
                            int  i = (Integer)q.data;
                            Protocol.SendObject(s, surface.objects.get(i),i);
                            Log.ln("SERVER: object " + i + " sended");
                        } break;
                        case (Protocol.GET_ALL_OBJECTS):
                        {
                            Protocol.SendAllObjects(s, surface.objects);
                            Log.ln("SERVER: all objects sended");
                        } break;
                        case(Protocol.GET_LIST_SIZE):
                        {
                            Protocol.SendListSize(s, surface.objects.size());
                            Log.ln("SERVER: objects count sended");
                        } break;
                        case(Protocol.CLOSE_CONNECTION) :
                        {
                            Protocol.CloseConnection(s);
                            Log.ln("SERVER: connection closed");
                        } break;
                        default: Log.ln("SERVER: unknown query code"); break;
                    }
                } else {ssocket.close(); break; }
            }
            catch (Exception e) { }

        Log.ln("SERVER: stop running");
    }
}
