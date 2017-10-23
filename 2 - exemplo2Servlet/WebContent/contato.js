$(document).ready(function(){

	$('#entrar').click(function(){
		if ($('#nome').val() == "") {
			alert('O campo de nome não pode estar vazio!');
			return false;
		} else {
			if ($('#senha').val() == "") {
				alert('O campo de senha não pode estar vazio!');
				return false;
			}
		}

		return true;
	});
});