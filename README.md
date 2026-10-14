# Java TCP Client–Server Demo

A beginner-friendly TCP socket example using Java's `ServerSocket`, `Socket`, and text streams.

## Requirements

- JDK 17 or later

## Run locally

Open a terminal in the repository directory:

```bash
javac server.java client.java
```

Start the server first:

```bash
java server
```

In a second terminal, run:

```bash
java client
```

The server listens on TCP port 5000 and the client connects to `localhost:5000`.

## Request flow

1. Server binds to port 5000 and waits for one client.
2. Client opens a socket and sends a newline-terminated message.
3. Server reads one line and returns a greeting.
4. Both sides close their sockets.

## Limitations and next steps

This is a plain TCP teaching example, not an HTTP API or an authenticated service. It currently handles one client per server run. Improvements could add try-with-resources, configurable host/port, multiple-client handling, read timeouts, protocol validation, and tests. Use TLS and explicit authentication before exposing a real service to untrusted networks.
