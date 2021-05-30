<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "br.com.fatecmc.esiii.dominio.*,java.util.ArrayList,java.util.List,java.io.PrintWriter,br.com.fatecmc.esiii.command.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastrar Aluno</title>

	<%
	ArrayList<EntidadeDominio> cursos = (ArrayList<EntidadeDominio>)request.getAttribute("cursos");
	%>
<meta charset="utf-8">
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
    	<h1>Cadastro do Aluno</h1>
        <div class="formulario">
            <form name = "formCurso" action = "cdAluno" method="get">
                <label for="pnome">Primeiro Nome:</label>
                <div class="centralizar"><input type="text" id="pnome" name="pnome" ></div>
                <label for="mnome">Nome do Meio:</label>
                <div class="centralizar"><input type="text" id="mnome" name="mnome" ></div>
               	<label for="unome">Ultimo nome:</label>
                <div class="centralizar"><input type="text" id="unome" name="unome" ></div>
                <label for="email">Email:</label>
                <div class="centralizar"><input type="email" id="email" name="email" ></div>
               	
               	<label for="rg">Rg:</label>
                <div class="centralizar"><input type="text" id="rg" name="rg"></div>
               	
               	<label for="email">Curso:</label>
                <div class="centralizar">
	                <select name="select">
	                <%for(EntidadeDominio dd:cursos) {
						
	                	Curso d =(Curso)dd;%>
							
					  <option  value="<%=d.getId()%>"><%=d.getNome()%></option>
						<%} %>
					</select>
				</div>
               	
               	<label for="cidade">Cidade:</label>
                <div class="centralizar"><input type="text" id="cidade" name="cidade" ></div>
                
                <label for="estado">Estado:</label>
                <div class="centralizar"><input type="text" id="estado" name="estado" ></div>
                <label for="longradouro">Longradouro:</label>
                <div class="centralizar"><input type="text" id="longradouro" name="longradouro" ></div>
                <label for="numero">Numero:</label>
                <div class="centralizar"><input type="text" id="numero" name="numero" ></div>
                <label for="cep">Cep:</label>
                <div class="centralizar"><input type="text" id="cep" name="cep" ></div>
                
                
                
                
               	<input class="button" name = "operacao" id ="operacao"  type = "submit" value = "SALVAR" >
    
            </form>
            <button class="button" onclick="window.location.href='index.html';">
                Voltar
            </button>

        </div>
         
            
        
    
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
 
        </div>
        
    </div>
</body>
</html> 