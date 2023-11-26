package br.com.smart_br.consulta_cnpj.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    /*
    * POJO espelhando o dto referente na api*/
    private String id;
    private String description;
    private City city;
}
