package queen;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
      new SpringApplicationBuilder()
              .sources(Application.class)
              .run(args);
    }
    
    @Bean
    public HttpServlet myServlet() {
        return new HttpServlet() {};
    }

    @Bean
    public Filter myFilter() {
        return new Filter() {

            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
            }

            @Override
            public void doFilter(ServletRequest request,
                    ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
            }

            @Override
            public void destroy() {
            }

        };
    }
}