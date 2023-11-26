package br.com.smart_br.consulta_cnpj.beans;

import br.com.smart_br.consulta_cnpj.beans.commons.SessionBean;
import br.com.smart_br.consulta_cnpj.model.Company;
import br.com.smart_br.consulta_cnpj.rest.CnpjWsRest;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Getter
@Setter
@Named("indexbean")
public class IndexBean {
    private String cnpj;
    private Company company;

    @Inject
    private CnpjWsRest rest;
    @Inject
    private SessionBean session;

    public void getCompanyByCnpj(){
        try {
            String cleanCnpj = cnpj.trim()
                    .replace(".", "")
                    .replace("-", "")
                    .replace("/","");
            company = rest.get(cleanCnpj);
            if (company != null) {
                session.setCompany(company);
                navigate();
            }
        } catch (Exception e) {
            showMesage("indexFormId:pesquisarId", "Erro ao buscar CNPJ!");
        }
    }

    public void navigate() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect("info.xhtml");
    }

    public void showMesage(String idPath, String message) {
        FacesContext.getCurrentInstance().addMessage(idPath, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
    }
}
