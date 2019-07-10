<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:import url="../login/headerSimples.jsp"></c:import>
	<c:import url="../../../resources/base/base-registrar.jsp"></c:import>
	
	<meta charset="utf-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<main class="login-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Cadastre-se aqui</div>
                    <div class="card-body">
                        <form action="" method="POST">
                         <div class="form-group row">
                                <label for="pin" class="col-md-4 col-form-label text-md-right" placeholder="">Pin </label>
                                <div class="col-md-6">
                                    <input type="text" id="pin" class="form-control" name="pin" required autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="nome" class="col-md-4 col-form-label text-md-right" placeholder="">Nome </label>
                                <div class="col-md-6">
                                    <input type="text" id="nome" class="form-control" name="nome" required autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="usuario" class="col-md-4 col-form-label text-md-right" placeholder="">Usuario </label>
                                <div class="col-md-6">
                                    <input type="text" id="usuario" class="form-control" name="usuario" required autofocus>
                                </div>
                            </div>
							<div class="form-group row">
                                <label for="email" class="col-md-4 col-form-label text-md-right" placeholder="email@email.com">E-mail </label>
                                <div class="col-md-6">
                                    <input type="text" id="email" class="form-control" name="email" placeholder="email@email.com" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="senha" class="col-md-4 col-form-label text-md-right">Senha </label>
                                <div class="col-md-6">
                                    <input type="password" id="senha" class="form-control" name="senha" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="confirmarSenha" class="col-md-4 col-form-label text-md-right">Confirmar senha </label>
                                <div class="col-md-6">
                                    <input type="password" id="confirmarSenha" class="form-control" name="confirmarSenha" required>
                                </div>
                            </div>
                                                    
                            <div class="form-group row">
   							 <label for="perguntaSecreta" class="col-md-4 col-form-label text-md-right">Pergunta secreta </label>
   							 	<div class= col-md-6>	
   							 		<select class="form-control " id="perguntaSecreta">
   							 		<c:forEach var="p" items="${perg}">
      									<option value="${p.id}">${p.pergunta}</option>
      								</c:forEach>   									
    								</select>
  						    	</div>
  						    </div>		    
  			
  						    
  						    <div class="form-group row">
                                <label for="resposta" class="col-md-4 col-form-label text-md-right" placeholder="">Resposta </label>
                                <div class="col-md-6">
                                    <input type="text" id="resposta" class="form-control" name="resposta" required autofocus>
                                </div>
                            </div>
                            
                           

                            <div class="form-group row">
                                <div class="col-md-6 offset-md-4">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="remember"> Continuar conectado
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="button" id="btnRegistrar" class="btn btn-primary">
                                <i class="far fa-save"></i>
                                    
                                </button>
                                <a href="#" class="btn btn-link">
                                    Esqueceu sua senha?
                                </a>
                            </div>
                            
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>

</main>
