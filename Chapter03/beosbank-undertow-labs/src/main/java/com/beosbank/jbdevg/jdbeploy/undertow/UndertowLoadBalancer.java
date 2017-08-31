package com.beosbank.jbdevg.jdbeploy.undertow;

import java.net.URI;
import java.net.URISyntaxException;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.ResponseCodeHandler;
import io.undertow.server.handlers.proxy.LoadBalancingProxyClient;
import io.undertow.server.handlers.proxy.ProxyHandler;

public class UndertowLoadBalancer {
	public static void main(String[] args) throws URISyntaxException {
		Undertow node1 = Undertow.builder().addHttpListener(7071, "localhost").setHandler(new HttpHandler() {
			public void handleRequest(HttpServerExchange exchange) throws Exception {
				exchange.getResponseSender().send("Beos Bank Node1 !");
			}
		}).build();

		Undertow node2 = Undertow.builder().addHttpListener(7072, "localhost").setHandler(new HttpHandler() {
			public void handleRequest(HttpServerExchange exchange) throws Exception {
				exchange.getResponseSender().send("Beos Bank Node2 !");
			}
		}).build();

		node1.start();
		node2.start();
		
		LoadBalancingProxyClient lbConfig = new LoadBalancingProxyClient();
			lbConfig.addHost(new URI("http://localhost:7071"));
			lbConfig.addHost(new URI("http://localhost:7072"));
			lbConfig.addHost(new URI("http://localhost:7073"));

		
		Undertow lbNode = Undertow.builder().addHttpListener(7070, "localhost")
				.setIoThreads(5)
                .setHandler(new ProxyHandler(lbConfig, 10000, ResponseCodeHandler.HANDLE_404))
                .build();
		
		lbNode.start();

	};
}