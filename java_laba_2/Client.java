
package java_laba_2;

import java.net.*;
import java.util.ArrayList;
import java_laba_2.Protocol.QueryData;

public class Client extends Thread {

    public Socket socket;
    private boolean stoped = false;
    public Surface surface;
    private void Stop() { stoped = true;}
    Client(Surface s,  String ip, int port)
    {
        surface = s;
        try {
            socket = new Socket(ip, port);
            System.out.println("### CLIENT: started - " + ip + ':' + port);
        }
        catch (Exception e) { e.printStackTrace(); }
        setDaemon(true);
        setPriority(NORM_PRIORITY);
    }

    @Override
    public void run()
    {
        while (stoped!=true)
            try {
                if (!socket.isClosed())
                {
                    QueryData q = Protocol.ListenServer(socket);

                    switch(q.code)
                    {
                        case(Protocol.SEND_LIST_SIZE):
                        {
                            Log.ln("CLIENT: got list size - " + (Integer)q.data);
                        } break;
                        case(Protocol.SEND_OBJECT):
                        {
                            int index = ((QueryData)q.data).code;
                            Drawable obj = (Drawable)((QueryData)q.data).data;
                            surface.objects.add(index, obj);
                            Log.ln("CLIENT: got object at " + index);
                        }
                        break;
                        case(Protocol.SEND_ALL_OBJECTS):
                        {
                            surface.objects = (ArrayList<Drawable>)q.data;
                            Log.ln("CLIENT: got all objects");
                        } break;
                        //default: Log.ln("CLIENT: unknown command"); break;
                    }
                } else break;
            } catch (Exception e) { Stop();}
        Log.ln("CLIENT: stop running");
    }
}

