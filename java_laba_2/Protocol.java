package java_laba_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Protocol {

    final static public int UNKNOWN = -1;

    // CLIENT
    final static public int CLOSE_CONNECTION = 0;
    final static public int CLEAR_LIST = 1;
    final static public int GET_LIST_SIZE = 2;
    final static public int GET_OBJECT = 3;
    final static public int GET_ALL_OBJECTS =4;

    // SERVER
    final static public int SEND_LIST_SIZE = 5;
    final static public int SEND_OBJECT = 6;
    final static public int SEND_ALL_OBJECTS = 7;

    static public class QueryData
    {
        public int code;
        public Object data;
    }

    static void CloseConnection(Socket s) throws IOException
    {
        s.getOutputStream().write(CLOSE_CONNECTION);
        s.getOutputStream().flush();
        s.close();
        Log.ln("CLIENT: connection closed");
    }
    static void ClearList(Socket s) throws IOException
    {
        s.getOutputStream().write(CLEAR_LIST);
        s.getOutputStream().flush();
        Log.ln("CLIENT: clear list requested");
    }

    static void QueryListSize(Socket s) throws IOException
    {
        s.getOutputStream().write(GET_LIST_SIZE);
        s.getOutputStream().flush();
        Log.ln("CLIENT: objects count requested");

    }
    static void QueryObject(Socket s, int index) throws IOException
    {
        s.getOutputStream().write(GET_OBJECT);
        s.getOutputStream().write(index);
        s.getOutputStream().flush();
        Log.ln("CLIENT: object " + index + " requested");

    }
    static void QueryObjects(Socket s) throws IOException
    {
        s.getOutputStream().write(GET_ALL_OBJECTS);
        s.getOutputStream().flush();
        Log.ln("CLIENT: all objects requested");

    }

    static void SendListSize(Socket s, int size) throws IOException
    {
        s.getOutputStream().write(SEND_LIST_SIZE);
        s.getOutputStream().write(size);
        s.getOutputStream().flush();
    }


    static void SendObject(Socket s, Drawable o, int index) throws IOException
    {
        OutputStream os = s.getOutputStream();
        os.write(SEND_OBJECT);
        os.write(index);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(o);
        os.flush();
    }

    static void SendAllObjects(Socket s, ArrayList<Drawable> list) throws IOException
    {
        OutputStream os = s.getOutputStream();
        os.write(SEND_ALL_OBJECTS);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(list);
        os.flush();
    }

    static QueryData ListenServer(Socket s) throws IOException, ClassNotFoundException
    {
        InputStream is = s.getInputStream();

        Log.ln("CLIENT: InputStream size = " + is.available());
        int code = is.read();
        QueryData qd = new QueryData();
        qd.code = code;
        switch (code)
        {
            case(SEND_LIST_SIZE):
                qd.data = is.read();
                break;
            case(SEND_OBJECT):
            {
                QueryData obj = new QueryData();
                // object index
                obj.code = is.read();

                ObjectInputStream ois = new ObjectInputStream(is);
                obj.data = (Drawable)ois.readObject();
                qd.data = obj;
            }
            break;
            case(SEND_ALL_OBJECTS):
            {
                ObjectInputStream ois = new ObjectInputStream(is);
                qd.data = (ArrayList<Drawable>)ois.readObject();
            }
            break;
            default: { qd.code = UNKNOWN; qd.data = null; } break;
        }
        return qd;
    }

    static QueryData ListenClient(Socket s) throws IOException, ClassNotFoundException
    {
        InputStream is = s.getInputStream();
        int code = is.read();
        QueryData q = new QueryData();

        q.code = code;

        switch(code){
            case(GET_LIST_SIZE): q.data = is.read(); break;
            case(GET_OBJECT) :  q.data = is.read(); break;
            case(CLOSE_CONNECTION):
            case(CLEAR_LIST):
            case(GET_ALL_OBJECTS): break;
            default: { q.code = UNKNOWN; q.data = null; }
        }
        return q;
    }
}
