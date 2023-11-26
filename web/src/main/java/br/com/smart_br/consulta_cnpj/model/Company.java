package br.com.smart_br.consulta_cnpj.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    /*
     * POJO espelhando o dto referente na api*/
    private String id;
    private String cnpj;
    private String name;
    private String dtRegistry;
    private String status;
    private String phone;
    private Address address;
}
