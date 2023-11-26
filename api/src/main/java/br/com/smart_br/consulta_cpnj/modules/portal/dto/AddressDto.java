package br.com.smart_br.consulta_cpnj.modules.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    /*
     * POJO espelhando a entidade referente no front*/
    private String id;
    private String description;
    private CityDto city;
}
