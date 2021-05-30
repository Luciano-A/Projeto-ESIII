<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Professor</title>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
</head>
<%
	String id=request.getParameter("id");
	System.out.print(id);
	String email=request.getParameter("email");
	String pnome=request.getParameter("pnome");
	String cpf=request.getParameter("cpf");
	String formacao=request.getParameter("formacao");
	String mnome=request.getParameter("mnome");
	String unome=request.getParameter("unome");
	String curso=request.getParameter("curso");
	String endereco=request.getParameter("endereco");
	
	String cep=request.getParameter("cep");
	String cidade=request.getParameter("cidade");
	String estado=request.getParameter("estado");
	String numero=request.getParameter("numero");
	String logradouro=request.getParameter("logradouro");

%>
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
        <div class="formulario">
            <form name = "formProfessor" action = "edProfessor" method="get">
            	 <div style="display: none;">
					<label for="id">ID: </label>
	                <input type="text" id="id" name="id" value=<%=id%>>
				</div>
				<div style="display: none;">
					<label for="curso">Curso: </label>
	                <input type="text" id="curso" name="curso" value=<%=curso%>>
				</div>
				<div style="display: none;">
					<label for="endereco">Endereco: </label>
	                <input type="text" id="endereco" name="endereco" value=<%=endereco%>>
				</div>
                
                <label for="pnome">Primeiro Nome:</label>
                <div class="centralizar"><input type="text" id="pnome" name="pnome" value="<%=pnome%>"></div>
                <label for="mnome">Nome do Meio:</label>
                <div class="centralizar"><input type="text" id="mnome" name="mnome" value="<%=mnome%>"></div>
               	<label for="unome">Ultimo nome:</label>
                <div class="centralizar"><input type="text" id="unome" name="unome" value="<%=unome%>"></div>
                <label for="email">Email:</label>
                <div class="centralizar"><input type="email" id="email" name="email" value="<%=email%>"></div>	
               	<label for="cpf">Cpf:</label>
                <div class="centralizar"><input type="text" id="cpf" name="cpf" value="<%=cpf%>"></div>
                <label for="formacao">Formação:</label>
                <div class="centralizar"><input type="text" id="formacao" name="formacao" value="<%=formacao%>"></div>
               	
               	<label for="unome">Cidade:</label>
               	<div class="centralizar"><input type="text" id="cidade" name="cidade" value="<%=cidade%>"></div>
                <label for="mnome">Cstado:</label>
                <div class="centralizar"><input type="text" id="estado" name="estado" value="<%=estado%>"></div>
               	<label for="unome">Numero:</label>
                <div class="centralizar"><input type="text" id="numero" name="numero" value="<%=numero%>"></div>
               	<label for="unome">Logradouro:</label>
               	<div class="centralizar"><input type="text" id="logradouro" name="logradouro" value="<%=logradouro%>"></div>
                <label for="mnome">Cep:</label>
                <div class="centralizar"><input type="text" id="cep" name="cep" value="<%=cep%>"></div>
               	
               	<input class="button"  type = "submit"id="operacao" name = "operacao" value = "EDITAR" >
    
     

            </form>
            
            

        </div>
         
            
        
    
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
 
        </div>
        
    </div>
</body>
</html>  tml>