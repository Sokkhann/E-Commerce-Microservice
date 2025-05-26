package com.testing.api_gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class IdTokenRelayGatewayFilterFactory extends AbstractGatewayFilterFactory<IdTokenRelayGatewayFilterFactory.Config> {

    public IdTokenRelayGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return exchange.getPrincipal()
                    .filter(principal -> principal instanceof OAuth2AuthenticationToken)
                    .cast(OAuth2AuthenticationToken.class)
                    .flatMap(auth -> {
                        if (auth.getPrincipal() instanceof DefaultOidcUser oidcUser) {
                            String idToken = oidcUser.getIdToken().getTokenValue();
                            ServerHttpRequest request = exchange.getRequest().mutate()
                                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + idToken)
                                    .build();
                            ServerWebExchange mutatedExchange = exchange.mutate().request(request).build();
                            return chain.filter(mutatedExchange);
                        } else {
                            return chain.filter(exchange);
                        }
                    })
                    .switchIfEmpty(chain.filter(exchange));
        };
    }

    public static class Config {}
}
