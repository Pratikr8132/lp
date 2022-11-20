import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class echoserver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = "127.0.0.1";
        int port = 32000;
        try (Socket socket = new Socket(host,port)){
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while (!"exit".equalsIgnoreCase(line)){
                line = sc.nextLine();
                out.println(line);
                out.flush();
                System.out.println("Server Replied: "+in.readLine());

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
