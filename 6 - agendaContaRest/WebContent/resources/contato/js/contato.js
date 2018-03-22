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
							alert("A senha informada possui menos de 4 ou mais de 8 caracteres!");
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
							alert("Todos  os campos são de preenchimento obrigatorio!");

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

						var html = "<table class='table'>";
						html += "<tr><th>Nome</th><th>Endereço</th><th>Email</th><th>Ações</th></tr>";

						if (listaDeContatos != undefined
								&& listaDeContatos.length > 0) {
							for (var i = 0; i < listaDeContatos.length; i++) {
								html += "<tr><td>"
										+ listaDeContatos[i].nome
										+ "</td>"
										+ "<td>"
										+ listaDeContatos[i].endereco
										+ "</td>"
										+ "<td>"
										+ listaDeContatos[i].email
										+ "</td>"
										+ "<td><a class='link' onclick='SENAI.contato.editarContato("
										+ listaDeContatos[i].id
										+ ")'>"
										+ "<img src='resources/contato/img/edit.png'></a>  "
										+ "<a class='link' onclick='SENAI.contato.deletarContato("
										+ listaDeContatos[i].id
										+ ")'>"
										+ "<img src='resources/contato/img/remove.png'></a></td></tr>";
							}
						} else {
							if (listaDeContatos == undefined) {
								if (valorBusca == "") {
									valorBusca = null;
								}

								var cfg = {
									type : "POST",
									url : "rest/contatoRest/buscarContatosPorNome/"
											+ valorBusca,
									success : function(listaDeContatos) {
										SENAI.contato
												.exibirContatos(listaDeContatos);
									},

									error : function(err) {
										alert("Erro ao consultar os contatos: "
												+ err.responseText);
									}
								};

								SENAI.ajax.post(cfg);
							} else {
								html += "<tr><td colspan='3'>Nenhum registro encontrado</td></tr>";
							}
						}

						html += "</table>";
						$("#resultadoContatos").html(html);
					};

					SENAI.contato.exibirContatos(undefined, "");

					SENAI.contato.deletarContato = function(id) {

						var confirm = {
							title : "Mensagem",
							height : 250,
							width : 400,
							modal : true,
							buttons : {
								"Sim" : function() {
									var cfg = {
										type : "POST",
										url : "rest/contatoRest/deletarContato/"
												+ id,
										success : function(data) {

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
											$("#msg").html(data);
											$("#msg").dialog(cfg);
											SENAI.contato.buscar();

										},
										error : function(err) {
											alert("Erro ao deletar o contato: "
													+ err.responseText);
										}

									};

									SENAI.ajax.post(cfg);
								},
								"Não" : function() {
									$(this).dialog("close");
								}
							}

						}

						$("#msg").html("Deseja excluir este contato?");
						$("#msg").dialog(confirm);
					};

					SENAI.contato.editarContato = function(id) {
						var cfg = {
							type : "POST",
							url : "rest/contatoRest/buscarContatoPeloId/" + id,
							success : function(contato) {
								$("#nomeEdit").val(contato.nome);
								$("#enderecoEdit").val(contato.endereco);
								$("#telefoneEdit").val(contato.telefone);
								$("#emailEdit").val(contato.email);
								$("#idContatoEdit").val(contato.id);
								$("#senhaEdit").val(contato.senha);

								SENAI.contato.exibirEdicao(contato);
							},

							error : function(err) {
								alert("Erro ao editar contato!"
										+ err.responseText);
							}

						};
						SENAI.ajax.post(cfg);
					};

					SENAI.contato.exibirEdicao = function(contato) {
						var cfg = {
							title : "Editar Contato",
							height : 400,
							width : 550,
							modal : true,
							buttons : {
								"Salvar" : function() {
									var dialog = this;
									var contato = new Object();
									contato.id = $("#idContatoEdit").val();
									contato.nome = $("#nomeEdit").val();
									contato.endereco = $("#enderecoEdit").val();
									contato.telefone = $("#telefoneEdit").val();
									contato.email = $("#emailEdit").val();
									contato.senha = $("#senhaEdit").val();

									var cfg = {
										type : "POST",
										url : "rest/contatoRest/editarContato",
										data : contato,
										// ----------//
										success : function(data) {
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
											$("#msg").html(data);
											$("#msg").dialog(cfg);
											$(dialog).dialog("close");
											SENAI.contato.buscar();

											// ---------//

										},
										error : function(err) {
											alert("Erro ao editar o contato!"
													+ err.responseText);
										}
									};

									SENAI.ajax.post(cfg);
								},
								"Cancelar" : function() {
									$(this).dialog("close");
								}
							},
							close : function() {
							}
						};

						$("#editarContato").dialog(cfg);
					};

				})