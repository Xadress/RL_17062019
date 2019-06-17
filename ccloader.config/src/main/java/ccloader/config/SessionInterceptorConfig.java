package ccloader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ccloader.config.interceptors.HttpRequestInterceptor;

@Configuration
public class SessionInterceptorConfig implements WebMvcConfigurer{

  @Autowired 
  HttpRequestInterceptor httpReqInterceptor ;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(httpReqInterceptor);
  }
}
