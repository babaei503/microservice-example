package ir.saeidbabaei.microservice.example.currencyconversion.unitconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="uconvert-service")
@RibbonClient(name="forex-service")
public interface UnitConvertServiceProxy {
	
  @GetMapping("/unit-convert/from/{from}/to/{to}")
  public UnitConversionBean retrieveConvertValue(@PathVariable("from") String from, @PathVariable("to") String to);
  
}