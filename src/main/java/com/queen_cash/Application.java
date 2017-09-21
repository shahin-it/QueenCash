package com.queen_cash;

import com.queen_cash.repository.CustomRepositoryImpl;
import com.queen_cash.util.AppUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.queen_cash", repositoryBaseClass = CustomRepositoryImpl.class)
public class Application {
    public static void main(String[] args) {
      new SpringApplicationBuilder()
              .sources(Application.class)
              .run(args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                AppUtil.servletContext = servletContext;
            }
        };
    }
}