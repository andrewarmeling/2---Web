SENAI.contato = new Object();

$(document).ready(function() {
	SENAI.contato.cadastrar = function() {
		
		if (document.getElementById("nome").value == "" ||
			document.getElementById("endereco").value == "" ||
			document.getElementById("telefone").value == "") {

			alert("Todos os campos são obrigatórios de preenchimento!");
			document.getElementById("nome").focus();
			return false;
		} else {
			$.ajax({
				type: "POST",
				url: "CadastroContato",
				data: $("#cadastrarContato").serialize(),
				success: function (msg) {
				var cfg = {
						title: "Mensagem",
						height: 250,
						width: 400,
						modal: true,
						buttons: {
							"Ok": function() {
								$(this).dialog("close");
							}
						}
					};
				$("#msg").html(msg.msg);
				$("#msg").dialog(cfg);
				
				SENAI.contato.buscar();
				},
				error: function (rest) {
					alert("Erro ao cadastrar um novo contato");
				}
			});
		}
	};
	SENAI.contato.buscar = function() {
		var valorBusca = $("#consultarContato").val();
		SENAI.contato.exibirContatos(undefined, valorBusca);
	};
});
