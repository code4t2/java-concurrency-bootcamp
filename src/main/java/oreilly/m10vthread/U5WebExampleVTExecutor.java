package oreilly.m10vthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class U5WebExampleVTExecutor {

    void serve(ServerSocket serverSocket)
        throws IOException, InterruptedException {
        try (final var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            while (true) {
                final var socket = serverSocket.accept();
                executor.submit(() -> handle(socket));
            }

        }
    }

    private void handle(Socket socket) {

    }
}
