package br.com.smart_br.consulta_cnpj.beans.commons;

import br.com.smart_br.consulta_cnpj.model.Company;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@Getter
@Setter
@Named("sessionbean")
public class SessionBean implements Serializable {
    /*
    * Bean referente à sessão ativa*/
    private Company company;
}

