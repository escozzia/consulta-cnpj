package br.com.smart_br.consulta_cpnj.modules.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
    /*
     * POJO espelhando a entidade referente no front*/
    private String id;
    private int ibge;
    private String description;
}
