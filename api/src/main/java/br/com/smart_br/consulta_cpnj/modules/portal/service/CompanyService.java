package br.com.smart_br.consulta_cpnj.modules.portal.service;

import br.com.smart_br.consulta_cpnj.commons.Commons;
import br.com.smart_br.consulta_cpnj.model.Company;
import br.com.smart_br.consulta_cpnj.modules.integration.service.CnpjWsService;
import br.com.smart_br.consulta_cpnj.modules.portal.dto.CompanyDto;
import br.com.smart_br.consulta_cpnj.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseService<Company, CompanyDto, ICompanyRepository> {
    @Autowired
    AddressService addressService;
    @Autowired
    CnpjWsService wsService;

    @Override
    public Company create(CompanyDto dto) {
        Company entity = null;
        if (dto.getId() != null)
            entity = repository.getById(dto.getId());
        else
            entity = new Company();
        entity.setName(dto.getName());
        entity.setCnpj(dto.getCnpj());
        entity.setPhone(dto.getPhone());
        entity.setDtRegistry(Commons.parseDate("yyyy-MM-dd", dto.getDtRegistry()));
        entity.setStatus(dto.getStatus());
        entity.setAddress(addressService.create(dto.getAddress()));
        return repository.save(entity);
    }

    @Override
    public CompanyDto parseDto(Company entity) {
        CompanyDto dto = new CompanyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCnpj(entity.getCnpj());
        dto.setPhone(entity.getPhone());
        dto.setDtRegistry(Commons.parseDate("yyyy-MM-dd", entity.getDtRegistry()));
        dto.setStatus(entity.getStatus());
        dto.setAddress(addressService.parseDto(entity.getAddress()));
        return dto;
    }

    public Company find(String cnpj) {
        Company entity = repository.findByCnpj(cnpj);
        if (entity == null)
            entity = wsService.getCnpjWs(cnpj);
        return entity;
    }
}
