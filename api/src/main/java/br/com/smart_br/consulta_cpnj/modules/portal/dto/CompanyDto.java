package br.com.smart_br.consulta_cpnj.modules.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
    /*
     * POJO espelhando a entidade referente no front*/
    private String id;
    private String cnpj;
    private String name;
    private String dtRegistry;
    private String status;
    private String phone;
    private AddressDto address;
}
