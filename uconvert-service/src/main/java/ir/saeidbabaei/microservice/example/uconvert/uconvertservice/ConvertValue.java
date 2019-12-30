package ir.saeidbabaei.microservice.example.uconvert.uconvertservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConvertValue {
  
  @Id
  private Long id;
  
  @Column(name="unit_from")
  private String from;
  
  @Column(name="unit_to")
  private String to;
  
  private BigDecimal conversionMultiple;
  
  private int port;
  
  public ConvertValue() {
    
  }
  

  public ConvertValue(Long id, String from, String to, BigDecimal conversionMultiple) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }
  
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}