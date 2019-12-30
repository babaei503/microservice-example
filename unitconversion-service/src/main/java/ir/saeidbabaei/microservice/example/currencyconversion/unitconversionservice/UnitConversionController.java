package ir.saeidbabaei.microservice.example.currencyconversion.unitconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UnitConversionController {
	
	  private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  @Autowired
	  private UnitConvertServiceProxy proxy;

	  @GetMapping("/unit-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	  public UnitConversionBean convertUnitFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity) {

		UnitConversionBean response = proxy.retrieveConvertValue(from, to);

	    logger.info("{}", response);

	    return new UnitConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
	        quantity.multiply(response.getConversionMultiple()), response.getPort());
	  }
	  
	  @GetMapping("/unit-converter/from/{from}/to/{to}/quantity/{quantity}")
	  public UnitConversionBean convertUnit(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {

	    Map<String, String> uriVariables = new HashMap<>();
	    uriVariables.put("from", from);
	    uriVariables.put("to", to);

	    ResponseEntity<UnitConversionBean> responseEntity = new RestTemplate().getForEntity(
	        "http://localhost:8000/unit-convert/from/{from}/to/{to}", UnitConversionBean.class,
	        uriVariables);

	    UnitConversionBean response = responseEntity.getBody();

	    return new UnitConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
	        quantity.multiply(response.getConversionMultiple()), response.getPort());
	  }
	  
}