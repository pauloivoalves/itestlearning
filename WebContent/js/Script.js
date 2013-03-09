function validaSenha() {
	if(document.getElementById("senha").valueOf() != document.getElementById("rsenha").valueOf()){
		alert("as senhas digitadas nao combinam!");
		return false;
	}
	return true;
}