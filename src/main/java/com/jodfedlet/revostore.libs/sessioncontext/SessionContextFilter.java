package com.jodfedlet.revostore.sessioncontext;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class SessionContextFilter extends OncePerRequestFilter {

  private static final Logger log = LoggerFactory.getLogger(SessionContextFilter.class);

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain
  ) throws ServletException, IOException {

    String userId = request.getHeader("X-User-Id");
    String email = request.getHeader("X-Email");
    String accessToken = request.getHeader("Authorization");

    if (accessToken != null) {
      log.info("Session context headers - userId: {}, email: {}, tokenPresent: {}",
          userId, email, accessToken != null ? "*****" : "");
      SessionContext.set(new SessionContextModel(userId, email, accessToken));
    }

    try {
      filterChain.doFilter(request, response);
    } finally {
      SessionContext.clear();
    }
  }
}