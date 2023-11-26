package br.com.smart_br.consulta_cpnj.modules.portal.service;

import br.com.smart_br.consulta_cpnj.model.Address;
import br.com.smart_br.consulta_cpnj.modules.portal.dto.AddressDto;
import br.com.smart_br.consulta_cpnj.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressDto, IAddressRepository> {
    @Autowired
    CityService cityService;

    @Override
    public Address create(AddressDto dto) {
        Address entity = null;
        if (dto.getId() != null)
            entity = repository.getById(dto.getId());
        else
            entity = new Address();
        entity.setDescription(dto.getDescription());
        entity.setCity(cityService.create(dto.getCity()));
        return repository.save(entity);
    }

    @Override
    public AddressDto parseDto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setCity(cityService.parseDto(entity.getCity()));
        return dto;
    }
}
