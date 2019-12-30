package ir.saeidbabaei.microservice.example.uconvert.uconvertservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvertValueRepository extends JpaRepository<ConvertValue, Long>{
	
	ConvertValue findByFromAndTo(String from, String to);
	
}