<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="estiloListar.css">
<link rel="stylesheet" type="text/css" href="estiloDropdown.css">
<meta charset="ISO-8859-1">
<title>Listagem de Churrasco</title>
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
						href="ChurrascoController?acao=listAll">Listar Todos</a>
				</div>
			</div>
		</div>
	</header>
	<div class="pesquisar">
		<h3 align="center">Pesquisar</h3>
		<form action="ChurrascoController" method="post"
			class="form-horizontal">
			<input type="text" name="pesquisar" id="pesquisar"
				placeholder="Informe o código que deseja pesquisar..."
				class="form-control inputPesquisa">
			<button type="submit" name="acao" value="listById"
				class="btn btn-primary btn-sm btnPesquisa">Pesquisar</button>
		</form>
	</div>
	<h1 align="center">Lista de Churrasco</h1>
	<br>
	<c:choose>
		<c:when test="${churrascoById != null}">
			<form method="get" action="ChurrascoController">
				<input type="hidden" name="idChurrasco"
					value="${churrascoById.getId_churrasco()}">
				<div class="listar">
					<table
						class="table table-bordered table-striped table-hover table-sm">
						<tr>
							<th>ID Churrasco</th>
							<th>Tipo de churrasco</th>
							<th>Quantidade de churrasco</th>
							<th>Valor do churrasco</th>
							<th>Update</th>
							<th>Delete</th>
						</tr>
						<tr>
							<td align="center">${churrascoById.getId_churrasco()}"</td>
							<td align="center">${churrascoById.getTipoChurrasco()}</td>
							<td align="center">${churrascoById.getQtdeChurrasco()}</td>
							<td align="center">${churrascoById.getValorChurrasco()}</td>
							<td><button class="btn btn-warning btn-sm" type="submit"
									name="acao" value="formAlterar">Update</button></td>
							<td><button class="btn btn-danger btn-sm" type="submit"
									name="acao" value="delete">Delete</button></td>
						</tr>
					</table>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<form method="get" action="ChurrascoController">
				<div class="listar">
					<table
						class="table table-bordered table-striped table-hover table-sm">
						<tr>
							<th>ID Churrasco</th>
							<th>Tipo de churrasco</th>
							<th>Quantidade de churrasco</th>
							<th>Valor do churrasco</th>
							<th>Update</th>
							<th>Delete</th>
						</tr>
						<c:forEach items="${churrascoLista}" var="churrasco">
							<tr>
								<td align="center">${churrasco.getId_churrasco()}</td>
								<td align="center">${churrasco.getTipoChurrasco()}</td>
								<td align="center">${churrasco.getQtdeChurrasco()}</td>
								<td align="center">${churrasco.getValorChurrasco()}</td>
								<td><a class="btn btn-warning btn-sm"
									href="ChurrascoController?idChurrasco=${churrasco.getId_churrasco()}&acao=formAlterar">Update</a></td>
								<td><a class="btn btn-danger btn-sm"
									href="ChurrascoController?idChurrasco=${churrasco.getId_churrasco()}&acao=delete">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
	<div class="refresh">
		<form action="ChurrascoController" method="post">
			<button type="submit" name="acao" value=listAll
				class="btn btn-primary btn-sm ">Refresh</button>
		</form>
	</div>
</body>
</html>