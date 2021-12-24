package com.example.jwtauthentications.filter;

import com.example.jwtauthentications.services.CustomUserDetailServices;
import com.example.jwtauthentications.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailServices customUserDetailServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //get the token and username then user details
        String AutherazationHeader=request.getHeader("Authorization");
        String userName=null;
        String token=null;

        if(AutherazationHeader !=null && AutherazationHeader.startsWith("Bearer")){
            token=AutherazationHeader.substring(7);
            userName=jwtUtil.extractUsername(token);

        }

        if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= customUserDetailServices.loadUserByUsername(userName);
            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);



    }
}
