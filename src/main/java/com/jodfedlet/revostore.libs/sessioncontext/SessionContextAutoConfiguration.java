package com.jodfedlet.revostore.sessioncontext;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@AutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SessionContextAutoConfiguration {

  @Bean
  public FilterRegistrationBean<SessionContextFilter> sessionContextFilter() {
    FilterRegistrationBean<SessionContextFilter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new SessionContextFilter());
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE + 100);
    return bean;
  }
}
