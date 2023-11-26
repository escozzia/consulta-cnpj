package br.com.smart_br.consulta_cpnj.modules.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityIntegrationDto {
    @JsonProperty("ibge_id")
    private int ibge;

    @JsonProperty("nome")
    private String description;
}
