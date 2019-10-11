package com.trilogyed.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /*
    * Clients:
  * HTML5
    * Grant Type: Password
    * Scopes: ROLE_LVL1, ROLE_LVL2
    * Secret (Bcrypt hashed): html_5_secret
  * Android
    - Grant Type: Password
    - Scopes: ROLE_LVL1, ROLE_LVL2, ROLE_ADMIN
    - Secret (Bcrypt hashed): android_secret
  * iPhone
    - Grant Type: Password
    - Scopes: ROLE_LVL1, ROLE_LVL2, ROLE_ADMIN
    - Secret (Bcrypt hashed): i_phone_secret
* Users:
  * jdoe
    * Password (Bcrypt hashed): jdoeRoCkS!!!
    * Authorities: ROLE_ADMIN
  * ssmith
    * Password (Bcrypt hashed): pwdPWDpwd!
    * Authorities: ROLE_LVL1
     */

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("html5")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$u8NMe/.0gCimlS7mTKde/ebYIe7a4XQFrUp20zAqP5WYP/EGzjLq2");

//        clients.inMemory()
//                .withClient("android")
//                .authorizedGrantTypes("password")
//                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
//                .secret("$2a$10$6h.l96PaO/ZsH9Vq/kAnTOpRc2bEVZBzjMQQkyJThpy3KiFwljrG2");
//
//        clients.inMemory()
//                .withClient("iphone")
//                .authorizedGrantTypes("password")
//                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
//                .secret("$2a$10$ruEPvP0W8OiIshguGyA8cOTrk5V5joW7Rca2dZVHuXK9m8BlwyT6S");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }

}
