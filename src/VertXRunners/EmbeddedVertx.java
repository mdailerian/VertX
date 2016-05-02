package VertXRunners;

import io.vertx.core.Vertx;

//https://github.com/vert-x3/vertx-examples/blob/master/core-examples/src/main/java/io/vertx/example/core/embed/EmbeddedServer.java

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class EmbeddedVertx {

    public static void main(String[] args) {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
    }
}