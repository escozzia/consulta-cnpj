package br.com.smart_br.consulta_cpnj.modules.portal.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<ENTITY, DTO, REPO> {
    /*
    * Injection do repository referente ao service*/
    @Autowired
    REPO repository;

    /*
    * Cria uma entidade ENTITY com base em um dto DTO vindo do front*/
    public abstract ENTITY create(DTO dto);


    /*
     * Cria um dto DTO com base em uma entidade ENTITY para enviar ao front*/
    public abstract DTO parseDto(ENTITY entity);
}
