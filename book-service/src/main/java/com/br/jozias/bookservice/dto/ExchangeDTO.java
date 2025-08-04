package com.br.jozias.bookservice.dto;

import java.math.BigDecimal;

public class ExchangeDTO {
    private Long id;
    private String from;
    private String to;
    private java.math.BigDecimal conversionFactor;
    private java.math.BigDecimal convertedValue;
    private String environment;

    public ExchangeDTO() {}

    public ExchangeDTO(Long id, String from, String to, java.math.BigDecimal conversionFactor, java.math.BigDecimal convertedValue, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public java.math.BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(java.math.BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public java.math.BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(java.math.BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeDTO that = (ExchangeDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (conversionFactor != null ? !conversionFactor.equals(that.conversionFactor) : that.conversionFactor != null)
            return false;
        if (convertedValue != null ? !convertedValue.equals(that.convertedValue) : that.convertedValue != null)
            return false;
        return environment != null ? environment.equals(that.environment) : that.environment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
        result = 31 * result + (convertedValue != null ? convertedValue.hashCode() : 0);
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        return result;
    }
}