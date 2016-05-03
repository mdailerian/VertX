package VertXRunners;

//import com.mongodb.connection.Server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

//https://github.com/vert-x3/vertx-examples/blob/master/core-examples/src/main/java/io/vertx/example/core/embed/EmbeddedServer.java
//http://allegro.tech/2015/11/real-time-web-application-with-websockets-and-vert-x.html

public class EmbeddedVertx extends AbstractVerticle{

    public static void main(String[] args) {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        //Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
        System.out.println("Started vertx");

        //convenient method to run within the IDE

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(EmbeddedVertx.class.getName());
    }
    public void start(Future<Void> fut) throws Exception {
            System.out.println( "Started verticle");
        Router router = Router.router(vertx);
//        router.route().handler(BodyHandler.create());

        // SET UP ROUTES
        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
            System.out.println("handling / route");
        });

        // Serve static resources from the /assets directory
        //So our index.html page is going to be served using http://localhost:8080/assets/index.html.
        router.route("/assets/*").handler(StaticHandler.create("assets"));

        // define some REST API
        router.get("/api/users").handler(ctx -> {
            System.out.println("api users");
            return;
        });

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }

    @Override
    public void stop() throws Exception {
     System.out.println("shutting down");
    }
}