package com.ecemgc.orderproductdemo.security;

import com.ecemgc.orderproductdemo.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final static List<String> allowedPaths = Arrays.asList("/auth/login", "/auth/register");

    private final JwtUtils jwtUtils;
    private final CustomUserDetailService customUserDetailService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        if(allowedPaths.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String token =  jwtUtils.getToken(request);
        if (!StringUtils.hasText(token)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"errorMessage\": \"" + "Missing token." + "\"}");
            return;
        }

        try {
            jwtUtils.validateToken(token);
        } catch (UnauthorizedException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"errorMessage\": \"" + e.getMessage() + "\"}");
            return;
        }

        String email = jwtUtils.extractUsername(token);
        UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

        if (SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}
