package br.com.smart_br.consulta_cpnj.modules.portal.rest;

import br.com.smart_br.consulta_cpnj.modules.portal.dto.CompanyDto;
import br.com.smart_br.consulta_cpnj.modules.portal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CnpjWsEndpoint {
    @Autowired
    CompanyService service;

    @GetMapping("/{cnpj}")
    public CompanyDto get(@PathVariable String cnpj) {
        return service.parseDto(service.find(cnpj));
    }

    @PostMapping("/save")
    public CompanyDto save(@RequestBody CompanyDto dto) {
        return service.parseDto(service.create(dto));
    }
}
