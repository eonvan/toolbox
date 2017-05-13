package toolbox.rest;

import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("toolbox")
public class Configuration {

    //    @Bean
    //    public CommandBus commandBus() {
    //        SimpleCommandBus commandBus = new SimpleCommandBus();
    //        commandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());
    //        return commandBus;
    //    }
    //
    //    @Bean
    //    public DefaultCommandGateway commandGateway() {
    //        return new DefaultCommandGateway(commandBus());
    //    }

}
