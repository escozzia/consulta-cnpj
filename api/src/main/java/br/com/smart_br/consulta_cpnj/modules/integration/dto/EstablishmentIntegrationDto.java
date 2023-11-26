package br.com.smart_br.consulta_cpnj.modules.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstablishmentIntegrationDto {
    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("data_inicio_atividade")
    private String dtRegistry;

    @JsonProperty("situacao_cadastral")
    private String status;

    @JsonProperty("cidade")
    private CityIntegrationDto city;
}
