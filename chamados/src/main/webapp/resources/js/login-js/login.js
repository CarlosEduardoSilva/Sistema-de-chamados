$(document).ready(function(){
	$("#btnLogar").click(function(){
			
		usuario = $('#usuario').val();
		senha = $('#senha').val();
				
	    if(usuario!=""){
	    	if(senha !=""){
	    		
	    		
	    		$.ajax({
					url: "logon", 
					type:"POST",
					data:{usu:usuario, senha:senha},

					success: function(result){
						
				    if(result == "/dashboard"){
//				    	
				    	swal("Login","Logou","success");	 
				    	window.location= result;
				    	
//				    	
				    }if(result == "/login"){
//				    	
				    	swal("Login","Não foi possivel logar","error");	 
				    }
				  }});
	    		
	    		   			    		
	    	}else{
	    		swal("Login","Campo senha vazio","error");	 				
	    	}	    	
	    }else{	    	
	    	swal("Login","Campo usuario vazio","error");	 				
	    }  

		});	
});       