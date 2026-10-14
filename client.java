import java.io.*;
import java.net.*;

public class client {
    private static final String HOST =
            System.getenv().getOrDefault("SERVER_HOST", "localhost");
    private static final int PORT = Integer.parseInt(
            System.getenv().getOrDefault("SERVER_PORT", "5000"));

    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(HOST, PORT), 5_000);
            socket.setSoTimeout(5_000);

            try (BufferedReader input = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(
                         socket.getOutputStream(), true)) {
                System.out.println("Connected to " + HOST + ":" + PORT);
                output.println("Hello Server");

                String response = input.readLine();
                if (response == null) {
                    System.err.println("Server closed the connection without a response.");
                    return;
                }
                System.out.println("Server says: " + response);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Client failed: " + e.getMessage());
        }
    }
}
