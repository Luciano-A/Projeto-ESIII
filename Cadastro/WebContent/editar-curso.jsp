<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Curso</title>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
</head>
<%
	String id=request.getParameter("id");
	String nome=request.getParameter("nome");
	String descricao=request.getParameter("descricao");
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
            <form name = "formCurso" action = "edCurso" method="get">
            	 <div style="display: none;">
					<label for="id">ID: </label>
	                <input type="text" id="id" name="id" value=<%=id%>>
				</div>
                <label for="nome">Nome:</label>
                <div class="centralizar"><input type="text" id="nome" name="nome" value="<%=nome%>"></div>
                <label for="descricao">Descrição:</label>
                <div class="centralizar"><input type="text" id="descricao" name="descricao" value="<%=descricao%>"></div>
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
</html>  