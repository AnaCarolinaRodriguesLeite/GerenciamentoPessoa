package controller;

import model.dao.EnderecoDAO;
import model.entities.Endereco;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class EnderecoMB implements Serializable {

    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private Endereco endereco = new Endereco();
    private List<Endereco> enderecos;

    public String limparEndereco() {
        endereco = new Endereco();
        return "/cadastrarendereco.xhtml";
    }

    public String adicionarEndereco() {
        if (enderecoDAO.inserirEndereco(endereco)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Endereço adicionado com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Esse endereço já foi adicionado!", null));
        }
        return null;
    }

    public String atualizarEndereco() {
        if (enderecoDAO.atualizarEndereco(endereco)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Endereço atualizado com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar endereço!", null));
        }
        return null;
    }

    public String excluirEndereco() {
        if (enderecoDAO.deletarEndereco(endereco.getId())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Endereço excluído com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir endereço!", null));
        }
        return null;
    }

    public List<Endereco> getEnderecos() {
        enderecos = List.of((Endereco) enderecoDAO.listarEndereco(String.valueOf(endereco.getEstado())));
        return enderecos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
