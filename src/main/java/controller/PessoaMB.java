package controller;

import model.dao.PessoaDAO;
import model.entities.Endereco;
import model.entities.Pessoa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean
@SessionScoped
public class PessoaMB implements Serializable {

    private PessoaDAO pessoaDAO = new PessoaDAO();
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;

    public String limparPessoa() {
        pessoa = new Pessoa();
        endereco = new Endereco();
        return "/cadastrarpessoa.xhtml";
    }

    public String adicionarPessoa() {
        if (pessoaDAO.inserirPessoa(pessoa)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa adicionada com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Essa pessoa já foi adicionada!", null));
        }
        return null;
    }

    public String atualizarPessoa() {
        if (pessoaDAO.atualizarPessoa(pessoa)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa atualizada com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar pessoa!", null));
        }
        return null;
    }

    public String excluirPessoa() {
        if (pessoaDAO.deletarPessoa(pessoa.getId())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir pessoa!", null));
        }
        return null;
    }

    public List<Pessoa> getPessoas() {
        pessoas = Collections.singletonList(pessoaDAO.listarPessoa(String.valueOf(pessoa.getId())));
        return pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
