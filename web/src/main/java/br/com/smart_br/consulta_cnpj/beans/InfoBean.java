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
@Named("infobean")
public class InfoBean {
    Company company;
    @Inject
    private CnpjWsRest rest;

    @Inject
    public InfoBean(SessionBean session) {
        this.company = session.getCompany();
    }

    public void save() {
        try {
            boolean valido = true;
            if (company.getAddress().getDescription() == null || company.getAddress().getDescription().isEmpty()) {
                showMesage("infoFormId:addressId", "Informe o endereço!");
                valido = false;
            }
            if(company.getPhone() == null || company.getPhone().isEmpty()) {
                showMesage("infoFormId:phoneId", "Informe o telefone!");
                valido = false;
            }
            if (!valido)
                return;
            rest.save(company);
            showMesage("infoFormId", "Salvo com sucesso!");
        } catch (Exception e) {
            showMesage("infoFormId:salvarId", "Erro ao salvar CNPJ!");
        }
    }

    public void navigate() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void showMesage(String idPath, String message) {
        FacesContext.getCurrentInstance().addMessage(idPath, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
    }
}
