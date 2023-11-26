package br.com.smart_br.consulta_cpnj.modules.integration.service;

import br.com.smart_br.consulta_cpnj.commons.Commons;
import br.com.smart_br.consulta_cpnj.model.Address;
import br.com.smart_br.consulta_cpnj.model.City;
import br.com.smart_br.consulta_cpnj.model.Company;
import br.com.smart_br.consulta_cpnj.modules.integration.dto.CompanyIntegrationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

@Service
public class CnpjWsService extends BaseIntegrationService<Company, CompanyIntegrationDto> {
    private final String URL_API = "https://publica.cnpj.ws/cnpj/%s";

    /*
    * Transforma um CompanyIntegrationDto obtido pelo Json do WS em uma entidade Company*/
    @Override
    public Company create(CompanyIntegrationDto dto) {
        if (dto != null) {
            Company entity = new Company();
            entity.setName(dto.getName());

            if (dto.getEstablishment() != null) {
                entity.setCnpj(dto.getEstablishment().getCnpj());
                entity.setDtRegistry(Commons.parseDate("yyyy-MM-dd", dto.getEstablishment().getDtRegistry()));
                entity.setStatus(dto.getEstablishment().getStatus());

                if (dto.getEstablishment().getCity() != null) {
                    City city = new City();
                    city.setIbge(dto.getEstablishment().getCity().getIbge());
                    city.setDescription(dto.getEstablishment().getCity().getDescription());

                    Address address = new Address();
                    address.setCity(city);
                    entity.setAddress(address);
                }
            }

            return entity;
        }
        return null;
    }

    /*
    * Consulta a API https://www.cnpj.ws/ e retorna uma entidade Company*/
    public Company getCnpjWs(String cnpj) {
        try {
            StringBuilder sb = new StringBuilder();
            new BufferedReader(new InputStreamReader(new URL(String.format(URL_API, cnpj)).openConnection().getInputStream()))
                    .lines().forEach(l -> sb.append(l.trim()));
            CompanyIntegrationDto dto = new ObjectMapper().readValue(sb.toString(), CompanyIntegrationDto.class);
            return create(dto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
