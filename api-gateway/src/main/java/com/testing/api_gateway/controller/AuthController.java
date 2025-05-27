//package com.testing.api_gateway.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.net.URI;
//import java.util.Map;
//
//@Controller
//public class AuthController {
//
//    @GetMapping("/login")
//    public Mono<Void> redirectToKeycloakLogin(ServerWebExchange exchange) {
//        throw new IllegalStateException("Should never reach here");
//    }
//
//    @GetMapping("/logout-success")
//    public Mono<Map<String, String>> logoutSuccess() {
//        return Mono.just(Map.of("message", "Logged out successfully"));
//    }
//
//    @GetMapping("/whoami")
//    public Mono<Map<String, Object>> whoAmI(@AuthenticationPrincipal OidcUser user) {
//        if (user == null) {
//            return Mono.just(Map.of("error", "Not authenticated"));
//        }
//        return Mono.just(Map.of(
//                "name", user.getName(),
//                "email", user.getEmail(),
//                "roles", user.getAuthorities()
//        ));
//    }
//}