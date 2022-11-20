import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class multi {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(32000);
            server.setReuseAddress(true);
            while (true){
                Socket client = server.accept();
                System.out.println("New Client Connected: "+client.getInetAddress().getHostAddress());
                ClientHandler clientSocket = new ClientHandler(client);
                new Thread(clientSocket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(server!=null){
                try {
                    server.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static class ClientHandler implements Runnable{
        private final Socket clientSocket;
        public ClientHandler(Socket socket){
            this.clientSocket = socket;
        }
        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line = null;
                while ((line = in.readLine())!=null){
                    System.out.println("Sent From the Client: "+line);
                    out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if(out!=null){
                        out.close();
                    }
                    if(in!=null){
                        in.close();
                    }
                    clientSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
