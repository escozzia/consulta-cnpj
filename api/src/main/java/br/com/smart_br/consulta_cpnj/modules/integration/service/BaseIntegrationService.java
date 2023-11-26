package br.com.smart_br.consulta_cpnj.modules.integration.service;

public abstract class BaseIntegrationService<ENTITY, DTO> {
    public abstract ENTITY create(DTO dto);
}