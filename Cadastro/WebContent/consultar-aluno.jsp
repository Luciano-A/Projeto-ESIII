<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "br.com.fatecmc.esiii.dominio.*,java.util.ArrayList,java.util.List,java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<title>Consultar Aluno</title>
<meta charset="utf-8">
	<%
	ArrayList<EntidadeDominio> alunos = (ArrayList<EntidadeDominio>)request.getAttribute("alunos");
	
		
		
	
	%>
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class= "center">
            <div class = "logo">
                <h2 >
                    <a class="log" href="index.html">
                    <img src="img/alunos-121x121.png" alt="ALuno" style="height: 3.8rem;">
                    Cadastro do Aluno
                    </a>
                </h2>
            </div><!--logo-->
            <div class="menu">
                <div class="dropdown">
                    <button class="dropbtn">Aluno</button>
                    <div class="dropdown-content">
                      <form name = "formAluno" action = "ccAluno" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CADASTRAR" >
                      </form>
                      <form name = "formAluno" action = "csAluno" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CONSULTAR" >
                      </form>
                    </div>
                  </div>

                  <div class="dropdown">
                    <button class="dropbtn">Professor</button>
                    <div class="dropdown-content">
                      <form name = "formProfessor" action = "ccProfessor" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CADASTRAR" >
                      </form>
                      <form name = "formProfessor" action = "csProfessor" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CONSULTAR" >
                      </form>
                    </div>
                  </div>

                <div class="dropdown">
                    <button class="dropbtn">Curso</button>
                    <div class="dropdown-content">
                      <a class="buton" href="cadastrar-curso.html">CADASTRAR</a>
                      <form name = "formCurso" action = "csCurso" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CONSULTAR" >
                      </form>
                    </div>
                  </div>
                    
            </div>
        </div><!--centro-->
    </header>
    <section class="main">
    <input type="text" class="buscar-contatos" id="jsBuscarContatos" placeholder="Buscar..."/>
      <div class = "centralizartabela">
       <table id="lista" class="table">
		 <thead> 
			  <tr>
			    <th>Primeiro Nome</th>
			    <th>Nome do Meio</th> 
			    <th>Ultimo Nome</th>
			    <th>Email</th>
			    <th>Rg</th>
			    <th>Curso</th>
			    <th>Cidade</th>
			    <th>Estado</th>
			    <th>Longradouro</th>
			    <th>Numero</th>
			    <th>Cep</th>
			    <th>Editar</th>
			    <th>Excluir</th>
			  </tr>
		  </thead>
	    <tr class="contato-lista" id="jsContatoLista">
	      <%for(EntidadeDominio dd:alunos) {
			Aluno d =(Aluno)dd;%>
	       <tr class="contato-lista-item js-contato-lista-item">
	         	<td><%= d.getPnome()%></td>
	           	<td><%= d.getMnome()%></td>
				<td><%= d.getUnome()%></td>
	           	<td><%= d.getEmail()%></td>
	         	<td><%= d.getRg()%></td>
	           	<td><%= d.getCurso().getNome()%></td>
	           	<td><%= d.getEndereco().getCidade()%></td>
	           	<td><%= d.getEndereco().getEstado()%></td>
	           	<td><%= d.getEndereco().getLogradouro()%></td>
	           	<td><%= d.getEndereco().getNumero()%></td>
	           	<td><%= d.getEndereco().getCep()%></td>
	           
	           <td><div class ="aa"><a href ="editar-aluno.jsp?id=<%= d.getId()%>
	           	&pnome=<%= d.getPnome()%>
	           	&mnome=<%= d.getMnome()%>
				&unome=<%= d.getUnome()%>
	           	&email=<%= d.getEmail()%>
	         	&rg=<%= d.getRg()%>
	           	&curso=<%= d.getCurso().getId()%>
	           	&endereco=<%= d.getEndereco().getId()%>
	           	&cep=<%= d.getEndereco().getCep()%>
	           	&cidade=<%= d.getEndereco().getCidade()%>
	           	&estado=<%= d.getEndereco().getEstado()%>
	           	&logradouro=<%= d.getEndereco().getLogradouro()%>
	           	&numero=<%= d.getEndereco().getNumero()%>
	           ">EDITAR</a></div></td>
	           	<td>
	           		<form name = "formAluno" action = "exAluno" method="get">
	           			<div style="display: none;">
	           				<input type="text" id="id" name="id" value="<%=d.getId()%>">
	           				<input type="text" id="idend" name="idend" value="<%=d.getEndereco().getId()%>">
	           				
	           			</div>   
			      		<input class="button" id="operacao" name="operacao" type = "submit" value = "EXCLUIR" >
			    	</form>
				</td>
	          
	           
	       </tr>

	      <%}%> 
	     
		</table> 
     </div>   
    
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
            
 
        </div>
        
    </div>
</body>
<script src="js/pesquisa.js"></script>
</html>  