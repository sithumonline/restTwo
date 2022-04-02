package com.example.resttwo;

import com.example.resttwo.controller.CategoryController;
import jakarta.ws.rs.core.UriBuilder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {

    public static final String BASE_URI = "http://localhost/";
    public static final int PORT = System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 4080;
    public static final String BASE_SERVICE_URI = System.getenv("BASE_SERVICE_URI") != null ? System.getenv("BASE_SERVICE_URI") : "http://localhost:3080/api/v1";

    public static Server startServer() {

        // scan packages
        // final ResourceConfig config = new ResourceConfig().packages("com.mkyong");

        final ResourceConfig config = new ResourceConfig()
                .registerInstances(new CategoryController(BASE_SERVICE_URI))
                .register(CORSResponseFilter.class);

        return JettyHttpContainerFactory.createServer(UriBuilder.fromUri(BASE_URI).port(PORT).build(), config);

    }

    public static void main(String[] args) {

        try {

            final Server server = startServer();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");
                    server.stop();
                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.printf("Application started.%nStop the application using CTRL+C%n");

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

            // alternative
            // Thread.sleep(Long.MAX_VALUE);       // sleep forever...
            // Thread.sleep(Integer.MAX_VALUE);    // sleep around 60+ years

        } catch (InterruptedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
