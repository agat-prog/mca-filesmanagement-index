package mca.filesmanagement.index;

import mca.filesmanagement.index.service.ServiceConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Clase principal que lanza la aplicación.

 * @author agat
 */
@SpringBootApplication
@EnableAutoConfiguration
@Import({ServiceConfiguration.class})
public class IndexApp {

  public static void main(String[] args) {
    SpringApplication.run(IndexApp.class, args);
  }

  /**
   * Mapper para la transformación de datos entre clases.

   * @return Bean del mapper que se inyectará.
   */
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
