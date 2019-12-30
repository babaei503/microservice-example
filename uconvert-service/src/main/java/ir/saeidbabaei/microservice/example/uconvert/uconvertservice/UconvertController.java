package ir.saeidbabaei.microservice.example.uconvert.uconvertservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UconvertController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ConvertValueRepository repository;
  
  @GetMapping("/unit-convert/from/{from}/to/{to}")
  public ConvertValue retrieveConvertValue
    (@PathVariable String from, @PathVariable String to){
    
    ConvertValue convertValue = 
        repository.findByFromAndTo(from, to);
    
    convertValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    return convertValue;
  }
}