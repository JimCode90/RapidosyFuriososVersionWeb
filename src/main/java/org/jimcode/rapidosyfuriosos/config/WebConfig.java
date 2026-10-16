package org.jimcode.rapidosyfuriosos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//esta clase permite configurar el Thymeleaf para las interfaces gráficas
//@Configuration -> se utiliza para que la clase sea una fuente de configuración
@Configuration
//implements WebMvcConfigurer -> implementamos que permita configurar el Spring MVC


public class WebConfig implements WebMvcConfigurer{
    //@Bean -> indica que devuelve un objeto que sera administrado por el contenedor de Spring
    @Bean
    //creamos un método para definir la resolución se pantallas
    public ClassLoaderTemplateResolver templateResolver() {
        //declaramos una variable de tipo ClassLoaderTemplateResolver
        var templateResolver= new ClassLoaderTemplateResolver();
        //definimos la carpeta donde se va a encontrar las páginas web
        templateResolver.setPrefix("templates/");
        //deshabilitamos la opción cacheable
        templateResolver.setCacheable(false);
        //definimos el tipo de páginas web que van a cargar
        templateResolver.setSuffix(".html");
        //definimos el modo de plantilla de páginas
        templateResolver.setTemplateMode("HTML");
        //definimos que permita caracteres especiales
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }


    @Bean
    //creamos un método para definir el motor de integración del Thymeleaf
    public SpringTemplateEngine templateEngine() {
        //declaramos una variable de tipo SpingTemplateEngine
        var templateEngine=new SpringTemplateEngine();
        //asignamos la resolución de plantillas
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }


    @Bean
    //creamos un método para la resolución de vistas
    public ViewResolver viewResolver() {
        //creamos un objeto de tipo ThymeleafViewResolver
        var viewResolver=new ThymeleafViewResolver();
        //asignamos el motor de integración
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    //sobrecargar el método addResourceHandlers
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //asignamos la ubicación de los recursos estáticos
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

}
