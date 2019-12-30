package ir.saeidbabaei.microservice.example.currencyconversion.unitconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UnitconversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitconversionServiceApplication.class, args);
	}

}
