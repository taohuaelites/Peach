package com.example.peach.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
<<<<<<< HEAD

=======
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
>>>>>>> 6a7db9e9f3898421f9b603c60b3d9744a614630a

/**
 * Created by wb-zhangkenan on 2016/11/30.
 */
@EnableWebMvc
@Configuration
<<<<<<< HEAD
public class WebConfig  implements WebMvcConfigurer {
=======
public class WebConfig implements WebMvcConfigurer {
>>>>>>> 6a7db9e9f3898421f9b603c60b3d9744a614630a

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");

    }

}
