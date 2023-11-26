package br.com.smart_br.consulta_cpnj.repository;

import br.com.smart_br.consulta_cpnj.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public interface ICompanyRepository extends JpaRepository<Company, String> {
    @Query("SELECT t FROM Company t WHERE t.cnpj = ?1")
    Company findByCnpj(String cnpj);
}
