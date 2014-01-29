function validaSenha() {
	if(document.getElementById("senha").valueOf() != document.getElementById("rsenha").valueOf()){
		alert("as senhas digitadas nao combinam!");
		return false;
	}
	return true;
}

function cadastro(){
	
	var dadosAux = $('#dados').val();
	var dados = new Array();
	dados = dadosAux.split(",");
	var teste = 0;
	for(var i = 0; i < dados.length; i++){
		var aux = $('#camp'+[i]).val();
		if(aux==""){
			aux=("vazio");
		}
		if(dados[i].indexOf(aux)!=-1){
			teste++;
		}
	}
	
	if(dados.length == teste){

		$('.exec').attr("style","z-index:-1");
		$('#componentes').attr("style","background-image:url(images/loading.gif);background-position-y: center");
		
		var tipo = $('#tipo').val();
		
		if(tipo == 'Sucesso'){
		
			setTimeout(function(){
			$('#componentes').attr("style","background-image:url(images/sucesso.png);background-position-y: center; background-repeat: no-repeat");
			},1000);
			
		}else{
		
			setTimeout(function(){
			$('.exec').removeAttr("style","z-index:-1");
			$('#componentes').removeAttr("style","background-image:url(images/loading.gif)");
			alert($('#msgm').val());
			},1000);
		
		}
	
	}else{
		alert("preencha os dados de forma correta");
	}
	
}