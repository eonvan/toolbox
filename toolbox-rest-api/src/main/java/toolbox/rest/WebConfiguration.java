package toolbox.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import toolbox.rest.events.Event;
import toolbox.rest.events.EventDeserializer;
import toolbox.rest.events.EventSerializer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        SimpleModule m = new SimpleModule();
        m.addSerializer(Event.class, new EventSerializer());
        final EventDeserializer eventDeserializer = new EventDeserializer();
        m.addDeserializer(Event.class, eventDeserializer);

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().modules(m, new KotlinModule());
        final ObjectMapper mapper = builder.build();
        converters.add(new MappingJackson2HttpMessageConverter(mapper));
        eventDeserializer.setMapper(mapper);
    }
}
