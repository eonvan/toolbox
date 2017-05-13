package toolbox.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

@SpringBootApplication
@EnableAutoConfiguration
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HandlerInstantiator handlerInstantiator(final ApplicationContext context) {
        return new SpringHandlerInstantiator(context.getAutowireCapableBeanFactory());
    }

    @Bean
    public ObjectMapper objectMapper(final HandlerInstantiator handlerInstantiator) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.handlerInstantiator(handlerInstantiator);
        return builder.build();
    }
}
