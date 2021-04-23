<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="estiloUpdate.css">
<link rel="stylesheet" type="text/css" href="estiloDropdown.css">
<meta charset="ISO-8859-1">
<title>Atualizar Churrasco</title>
</head>
<body>
<header>
		<div class=header>
			<div class="titulo">
				<h1>RC Churrasco</h1>
			</div>
			<div class="dropdown">
				<button class="btn btn-info btn-sm botaoDrop">Menu</button>
				<div class="dropdown-content">
					<a href="index.jsp">Cadastrar</a> <a
						href="ChurrascoController?acao=listAll">Listar</a>
				</div>
			</div>
		</div>
	</header>
	</div>
	<div class="container">
		<h1 align=center>Update de Churrasco</h1>
		<div class="update">
			<form action="ChurrascoController" method="post">
				<input type="hidden" value="update" name="acao" id="acao">
				<table
					class="table table-bordered table-striped table-hover table-sm">
					<tr>
						<td><label>ID Churrasco: </label> <input
							class="form-control inputUpdate" type="text" id="idChurrasco"
							name="idChurrasco" value="${idChurrasco}" readonly></td>
					</tr>
					<tr>
						<td><label>Tipo de churrasco: </label> <input
							class="form-control inputUpdate" type="text" id="tipoChurrasco"
							name="tipoChurrasco" value="${tipoChurrasco}"></td>
					</tr>
					<tr>
						<td><label>Quantidade: </label> <input
							class="form-control inputUpdate" type="text" id="qtdeChurrasco"
							name="qtdeChurrasco" value="${qtdeChurrasco}"></td>
					</tr>
					<tr>
						<td><label>Valor: </label> <input
							class="form-control inputUpdate" type="text" id="valorChurrasco"
							name="valorChurrasco" value="${valorChurrasco}"></td>
					</tr>
				</table>
				<input class="btn btn-success btnAtualizar" type="submit"
					value="Atualizar">
			</form>
		</div>
	</div>
</body>
</html>