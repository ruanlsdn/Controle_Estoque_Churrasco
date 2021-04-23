<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="estiloInsert.css">
<link rel="stylesheet" type="text/css" href="estiloDropdown.css">
<meta charset="ISO-8859-1">
<title>Cadastro de Churrasco</title>
</head>
<body>
	<header>
		<div class="titulo">
			<h1>RC Churrasco</h1>
		</div>
	</header>
	<div class="container">
		<h1 align=center>Cadastro de Churrasco</h1>
		<div class="insert">
			<form action="ChurrascoController" method="post"
				class="form-horizontal">
				<input type="hidden" value="insert" name="acao" id="acao">
				<table
					class="table table-bordered table-striped table-hover table-sm">
					<tr>
						<td><label for="">Tipo de churrasco: </label> <input
							class="form-control inputInsert" type="text" id="tipoChurrasco"
							name="tipoChurrasco"
							placeholder="Informe aqui o tipo de churrasco..."></td>
					</tr>
					<tr>
						<td><label>Quantidade: </label> <input
							class="form-control inputInsert" type="text" id="qtdeChurrasco"
							name="qtdeChurrasco" placeholder="Informe aqui a quantidade...">
						</td>
					</tr>
					<tr>
						<td><label>Valor: </label> <input
							class="form-control inputInsert" type="text" id="valorChurrasco"
							name="valorChurrasco"
							placeholder="Informe aqui o valor do churrasco..."></td>
					</tr>
				</table>
				<input class="btn btn-success btnCadastrar" type="submit"
					value="Cadastrar">
			</form>
		</div>
		<div class="listar">
			<form method="get" action="ChurrascoController">
				<input type="hidden" value="listAll" name="acao"> <input
					class="btn btn-primary" type="submit" value="Listar">
			</form>
		</div>
	</div>
</body>
</html>