package br.com.smart_br.consulta_cpnj.repository;

import br.com.smart_br.consulta_cpnj.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public interface IAddressRepository extends JpaRepository<Address, String> {
}
