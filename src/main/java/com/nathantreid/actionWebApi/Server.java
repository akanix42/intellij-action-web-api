package com.nathantreid.actionWebApi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class Server extends AbstractVerticle {
  private Vertx vertx;

  Server() {
    System.setProperty("vertx.disableFileCPResolving", "true");
    System.setProperty("vertx.disableFileCache", "true");
    vertx = Vertx.vertx();
  }

  public void start() {
    HttpServer httpServer = vertx.createHttpServer();
    httpServer.requestHandler(configureRouter()::accept);
//    httpServer.requestHandler(req -> {
//      req.response()
//         .putHeader("content-type", "text/plain")
//         .end("Hello from Vert.x!");
//    });
    httpServer.listen(8089);
  }

  private Router configureRouter() {
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/action").handler(routingContext -> {
      final ApiCommand apiCommand = Json.decodeValue(routingContext.getBodyAsString(), ApiCommand.class);
      ActionRunner actionRunner = new ActionRunner();
      actionRunner.runAction(apiCommand);
      HttpServerResponse response = routingContext.response();
      response
          .putHeader("content-type", "text/plain")
          .end(apiCommand.action);
    });
    router.post("/").handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      response
          .putHeader("content-type", "text/plain")
          .end("Routed hello");
    });
    return router;
  }
}
