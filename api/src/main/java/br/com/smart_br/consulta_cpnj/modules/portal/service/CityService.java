package br.com.smart_br.consulta_cpnj.modules.portal.service;

import br.com.smart_br.consulta_cpnj.model.City;
import br.com.smart_br.consulta_cpnj.modules.portal.dto.CityDto;
import br.com.smart_br.consulta_cpnj.repository.ICityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseService<City, CityDto, ICityRepository> {
    @Override
    public City create(CityDto dto) {
        City entity = null;
        if (dto.getId() != null)
            entity = repository.getById(dto.getId());
        else {
            entity = repository.findByIbge(dto.getIbge());
            if (entity == null)
                entity = new City();
        }
        entity.setIbge(dto.getIbge());
        entity.setDescription(dto.getDescription());
        return repository.save(entity);
    }

    @Override
    public CityDto parseDto(City entity) {
        CityDto dto = new CityDto();
        dto.setId(entity.getId());
        dto.setIbge(entity.getIbge());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
