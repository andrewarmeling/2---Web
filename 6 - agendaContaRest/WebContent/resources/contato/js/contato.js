SENAI.contato = new Object();

$(document)
		.ready(
				function() {

					SENAI.contato.cadastrar = function() {

						var nome = document.getElementById("nome").value;
						var endereco = document.getElementById("endereco").value;
						var telefone = document.getElementById("telefone").value;
						var email = document.getElementById("email").value;
						var senha = document.getElementById("senha").value;

						var confirmaSenha = document
								.getElementById("confirmaSenha").value;
						if (senha != confirmaSenha) {
							alert("As senhas não conferem!");
							return false;
						}
						if (senha.length < 4 || senha.length > 8) {
							alert("A senha informada possui menos de 04 caracteres!");
							return false;
						}

						var email = document.getElementById("email").value;
						if (email.indexOf("@") == -1
								|| email.indexOf(".") == -1
								|| email.indexOf("@") == 0
								|| email.lastIndexOf(".") + 1 == email.length
								|| (email.indexOf("@") + 1 == email
										.indexOf("."))) {
							alert("email incorreto");
							document.getElementById("email").focus();
							return false;
						}

						if (nome == "" || endereco == "" || telefone == ""
								|| senha == "" || email == "") {
							alert("Todos  os campos são de preenchimento Obrigatorio!");

						} else {

							var novoContato = new Object();

							novoContato.nome = $("#nome").val();
							novoContato.endereco = $("#endereco").val();
							novoContato.telefone = $("#telefone").val();
							novoContato.senha = $("#senha").val();
							novoContato.email = $("#email").val();

							var cfg = {

								url : "rest/contatoRest/addContato",
								data : novoContato,
								success : function(msg) {
									var cfg = {
										title : "Mensagem",
										height : 250,
										width : 400,
										modal : true,
										buttons : {
											"OK" : function() {
												$(this).dialog("close");
											}
										}
									};
									$("#msg").html(msg);
									$("#msg").dialog(cfg);
									SENAI.contato.buscar();
								},

								error : function(err) {
									alert("Erro ao cadastrar um novo contato!"
											+ err.responseText);
								}
							};
							SENAI.ajax.post(cfg);

						}

					};

					SENAI.contato.buscar = function() {
						var valorBusca = $("#consultarContato").val();
						SENAI.contato.exibirContatos(undefined, valorBusca);
					};

					SENAI.contato.exibirContatos = function(listaDeContatos,
							valorBusca) {
						alert("Ainda não implementada");
					};

				})