package com.nadir.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
/* static routing with config
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r->r.path("/customers/**").uri("http://localhost:8081/customers"))
				.route(r->r.path("/products/**").uri("http://localhost:8082/products"))
				.build();
	}

 */
	/* static route with eureka
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

		return builder.routes()

				.route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE") .id("r1"))
				.route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE") .id("r2"))
				.build();

	}

	 */
	//dynamic route with eureka
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoute(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}


}
