import java.io.*;
import java.net.*;

public class server {
    private static final int PORT = Integer.parseInt(
            System.getenv().getOrDefault("SERVER_PORT", "5000"));

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);
            System.out.println("Waiting for one client...");

            try (Socket socket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(
                         socket.getOutputStream(), true)) {

                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                String message = input.readLine();

                if (message == null) {
                    System.out.println("Client disconnected before sending a message.");
                    return;
                }

                System.out.println("Client says: " + message);
                output.println("Hello Client");
            }

            System.out.println("Connection closed.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Server failed: " + e.getMessage());
        }
    }
}
