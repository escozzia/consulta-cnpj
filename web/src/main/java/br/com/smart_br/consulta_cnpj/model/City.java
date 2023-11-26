package br.com.smart_br.consulta_cnpj.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    /*
     * POJO espelhando o dto referente na api*/
    private String id;
    private int ibge;
    private String description;
}
