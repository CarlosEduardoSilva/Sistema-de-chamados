<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:import url="headerSimples.jsp"></c:import>
	<c:import url="../../../resources/base/base-header.jsp"></c:import>
	<c:import url="../../../resources/base/base-login.jsp"></c:import>
	<meta charset="utf-8">


<main class="login-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Login</div>
                    <div class="card-body">
                        <form action="" method="POST">
                            <div class="form-group row">
                                <label for="usuario" class="col-md-4 col-form-label text-md-right" >Usuario</label>
                                <div class="col-md-6">
                                    <input type="text" id="usuario" class="form-control" name="usuario" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="senha" class="col-md-4 col-form-label text-md-right">Senha:</label>
                                <div class="col-md-6">
                                    <input type="password" id="senha" class="form-control" name="senha" required>
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
                                <button type="button" id="btnLogar" class="btn btn-primary">
                                    Login
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
