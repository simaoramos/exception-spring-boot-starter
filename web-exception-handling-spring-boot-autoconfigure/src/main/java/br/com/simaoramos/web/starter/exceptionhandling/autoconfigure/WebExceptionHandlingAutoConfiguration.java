package br.com.simaoramos.web.starter.exceptionhandling.autoconfigure;

import br.com.simaoramos.core.exception.DataException;
import br.com.simaoramos.web.starter.exceptionhandling.library.ExceptionResponseFactory;
import br.com.simaoramos.web.starter.exceptionhandling.library.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(DataException.class)
public class WebExceptionHandlingAutoConfiguration {
    @Bean
    public ExceptionResponseFactory exceptionResponseFactory() {
        return new ExceptionResponseFactory();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ExceptionResponseFactory exceptionResponseFactory) {
        return new GlobalExceptionHandler(exceptionResponseFactory);
    }
}
