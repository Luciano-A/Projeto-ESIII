const classeEscondido = "js-escondido";
const classeBotaoRemocao = "js-contato-remover";
const classeAvatar = "js-contato-avatar";

function exibir(elemento) {
  elemento.classList.remove(classeEscondido);
}

function esconder(elemento) {
  elemento.classList.add(classeEscondido);
}
(function registrarEventoAlteracaoCaixaPesquisa() {
	  document
	    .getElementById("jsBuscarContatos")
	    .addEventListener("keyup", function (e) {
	      const filtro = e.target.value;
			console.log(e.target.value);
	      const itensLista = document.getElementsByClassName(
	        "js-contato-lista-item"
	      );
	      for (let i = 0; i < itensLista.length; i++) {
	        const conteudoTextualItem = itensLista[i].innerText;
	        if (
	          conteudoTextualItem.toUpperCase().indexOf(filtro.toUpperCase()) >= 0
	        ) {
	          exibir(itensLista[i]);
	        } else {
	          esconder(itensLista[i]);
	        }
	      }
	    });
	})();