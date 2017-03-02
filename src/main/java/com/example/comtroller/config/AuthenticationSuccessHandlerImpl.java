package com.example.comtroller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by illidanet on 3/2/17.
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
           HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        logger.info("AT onAuthenticationSuccess(...) function!");

        httpServletResponse.sendRedirect("/results");

//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            if ("ROLE_ADMIN".equals(auth.getAuthority())){
//                admin = true;
//            }
//        }
//
//        if(admin){
//            response.sendRedirect("/admin");
//        }else{
//            response.sendRedirect("/welcome");
//        }
    }
}
