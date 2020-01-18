<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<c:import url="top.jsp"></c:import>
<body class="w3-black">
	<c:import url="icon-bar.jsp"></c:import>
	<c:import url="nav-bar.jsp"></c:import>
	<!-- Page Content -->
	<div class="w3-padding-large" id="main">
		<c:import url="user-actions.jsp"></c:import>
		<c:import url="header.jsp"></c:import>
		<div class="w3-content w3-justify w3-text-grey w3-padding-64"
			id="about">
			<h2 class="w3-text-light-grey">Gerenciar Usu�rios</h2>
			<hr style="width: 200px" class="w3-opacity">
			<ul>
				<li><a href="/rpg-campaign/gameplay?action=CreateDM">Criar
						Dungeon Master (mestre)</a></li>
				<li><a href="/rpg-campaign/gameplay?action=CreatePlayer">Criar
						Personagem</a></li>
				<li><a href="/rpg-campaign/gameplay?action=ListUser">Gerenciar
						Usu�rios</a></li>
			</ul>
			<%
				System.out.println("[ View ] : JSP user accessed!");
			%>
		</div>
		<c:import url="footer.jsp"></c:import>
		<!-- END PAGE CONTENT -->
	</div>
</body>
</html>
