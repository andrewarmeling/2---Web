SENAI.contato = new Object();

$(document)
		.ready(
				function() {
					SENAI.contato.cadastrar = function() {

						if (document.getElementById("nome").value == ""
								|| document.getElementById("endereco").value == ""
								|| document.getElementById("telefone").value == "") {

							alert("Todos os campos são obrigatórios de preenchimento!");
							document.getElementById("nome").focus();
							return false;
						} else {
							$.ajax({
								type : "POST",
								url : "CadastroContato",
								data : $("#cadastrarContato").serialize(),
								success : function(msg) {
									var cfg = {
										title : "Mensagem",
										height : 250,
										width : 400,
										modal : true,
										buttons : {
											"Ok" : function() {
												$(this).dialog("close");
											}
										}
									};
									$("#msg").html(msg.msg);
									$("#msg").dialog(cfg);

									SENAI.contato.buscar();
								},
								error : function(rest) {
									alert("Erro ao cadastrar um novo contato");
								}
							});
						}
					};
					SENAI.contato.buscar = function() {
						var valorBusca = $("#consultarContato").val();
						SENAI.contato.exibirContatos(undefined, valorBusca);
					};
					// rotina que os contatos cadastrados
					SENAI.contato.exibirContatos = function(listaDeContatos,
							valorBusca) {
						var html = "<table class='table'>";
						html += "<tr><th>Nome</tr><th>Endereço</th><th>Telefone</th><th>Ações</th></tr>"
						if (listaDeContatos != undefined
								&& listaDeContatos.length > 0
								&& listaDeContatos[0].id != undefined) {
							for (var i = 0; i < listaDeContatos.length; i++) {
								html += "<tr><td>"
										+ listaDeContatos[i].nome
										+ "</td>"
										+ "<td>"
										+ listaDeContatos[i].endereco
										+ "</td>"
										+ "<td>"
										+ listaDeContatos[i].telefone
										+ "</td>"

										+ "<td>"
										+ "<a class= 'link' href='#' onclick='SENAI.contato.editarContato("
										+ listaDeContatos[i].id
										+ ")'>Editar</a>"
										+ "<a class= 'link' href='#' onclick='SENAI.contato.deletarContato("
										+ listaDeContatos[i].id
										+ ")'>Deletar</a></td></tr>";
							}

						} else {
							if (listaDeContatos == undefined
									|| (listaDeContatos != undefined && listaDeContatos.lenght > 0)) {

								$
										.ajax({
											type : "POST",
											url : "ConsultaContato",
											data : "valorBusca=" + valorBusca,
											success : function(listaDeContatos) {
												SENAI.contato.exibirContatos(
														listaDeContatos, "");
											},
											error : function(rest) {
												alert("Erro  ao consultar os contatos");
											}
										});
							} else {
								html += "<tr><td  colspan='3'>Nenhum registro encontrado</td></tr>";

							}
						}
						html += "</table>";
						$("#resultadoContatos").html(html);
					};

					SENAI.contato.exibirContatos(undefined, "");

				});
