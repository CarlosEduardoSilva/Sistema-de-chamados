$(document).ready(function(){
	$("#btnRegistrar").click(function(){
		pin = $('#pin').val();
		nomeval= $('#nome').val();		
		usuario = $('#usuario').val();
		email = $('#email').val();
		senha = $('#senha').val();
	    confirmarSenha = $('#confirmarSenha').val();	    
	    empId = $('#empId');
	    pergunta = $('#perguntaId').val();
	    resposta = $('#perResposta').val();
		
	    if(nomeval !=""){
	    	if(usuario !=""){
	    		if(email !=""){
	    			if(resposta !=""){
	    				if(senha == confirmarSenha){
	    			    	$.ajax({
	    						url: "nvregistro", 
	    						type:"POST",
	    						data:{pin:pin, nome:nomeval, usu:usuario, email:email, senha:senha, empId:empId, pergunta:pergunta, reposta:resposta},

	    						success: function(result){
	    					    if(result == "OK"){
//	    					    	console.log("Usuario salvo com sucesso");	
	    					    	swal("Registro","Usuario Registrado","success");
//	    					    	alert('Cadastrado com sucesso');
	    					    }else{
//	    					    	console.log("Problemas ao gravar usuario");
//	    					    	alert('Erro ao cadastrar');
	    					    	swal("Registro","Usuario Não Registrado","error");
	    					    }
	    					  }});
	    					
	    				}else{
//	    					alert("SENHAS DIFERENTES!!");
	    					swal("Registro","Senhas divergentes","error");
	    				}
	    			}else{
	    				alert("Campo Resposta vazio!!");
    					swal("Registro","Campo Resposta vazio","error");
	    				
	    			}
	    		}else{
	    			alert("E-mail invalido!!");
					swal("Registro","E-mail invalido","error");
	    			
	    		}
	    	}else{
	    		alert("Campo Usuario vazio!!");
				swal("Registro","Campo Usuario vazio","error");	    		
	    	}
	    	
	    }else{
	    	alert("Campo Nome vazio!!");
			swal("Registro","Campo Nome vazio","error");	    		
	    }  

		});
	
	
	
});       