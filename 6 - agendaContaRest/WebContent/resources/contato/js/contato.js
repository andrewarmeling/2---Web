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

						if (nome == "" || endereco == "" || telefone == ""
								|| senha == "" || email == "") {
							alert("Todos os campos são de preenchimento obrigatório");
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
										title : "Mennsagem",
										height : 250,
										width : 400,
										modal : true,
										buttos : {
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

				});