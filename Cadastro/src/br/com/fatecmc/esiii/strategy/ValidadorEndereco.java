package br.com.fatecmc.esiii.strategy;

import br.com.fatecmc.esiii.dominio.Endereco;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class ValidadorEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		if(endereco.getCep() == null || endereco.getCep().trim().length()<8) {
			return "  Cep invalido";
		}else if(endereco.getCidade() == null || endereco.getCidade().trim().equals("")) {
			return "  Cidade invalida";
		}else if(endereco.getEstado() == null || endereco.getEstado().trim().equals("")) {
			return "  Estado invalido";
		}else if(endereco.getLogradouro() == null || endereco.getLogradouro().trim().equals("")) {
			return "  Logradouro invalido";
		}else if(endereco.getNumero() == null || endereco.getNumero().trim().equals("")) {
			return "  Numero invalido";
		}
		return null;
	}

}
