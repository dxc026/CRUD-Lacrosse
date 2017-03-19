<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Roster</title>
<link rel="stylesheet" href="home.css">
</head>
<body>
	<div class="image">
		<div >
			<table>
				<tr>
					<th></th>
					<th>Number</th>
					<th>Name</th>
					<th>Position</th>
					<th>School</th>
				</tr>
				<h1>Charlotte Hounds Fantasy Team</h1>
				<br />
				<br />

			<!-- 	<div>
					<form>
						<input type="submit" name="Edit" value="Edit"> <input
							type="submit" name="Delete" value="Delete Selected Items">
					</form>
				</div> -->

				<c:forEach items="${playerList}" var="team">
				<c:if test="${team.playerName!=player.playerName }">
					${player.playerName }
					<tr>
						<td><input type="radio" name="name" value="${ team.playerName}"/></td>
						<td>${ team.playerNum}</td>
						<td>${ team.playerName}</td>
						<td>${ team.position}</td>
						<td>${ team.school}</td>
					<td><form action="editPlayer.do">
						<button type="submit" name="Edit" value="${ team.playerName}"> Edit </button> 
					</form></td>
					<td><form action="delete.do">
						<button
							type="submit" name="Delete" value="${ team.playerName}"> Delete Selected Items</button>
					</form></td>
					</tr>
					</c:if>
					<form action="edit.do">
				<c:if test="${team.playerName==player.playerName}">
				
					<tr>
						<td><input type="hidden" name="playerNum" value="${ team.playerNum}" /></td>
						<td><input type="text" name="playerName" value="${ team.playerName}" /></td>
						<td><input type="text" name="position" value="${ team.position}" /></td>
						<td><input type="text" name="school" value="${ team.school}" /></td>
					<td>
						<button type="submit" name="Edit" value="${ team.playerName}"> Edit </button> 
					</td>
					
					</tr>
					</c:if>
					</form>
					<%-- 
<p>${ team.playerNum}
	${ team.playerNum}
	${ team.position}
	${ team.school}</p> --%>

				</c:forEach>
			</table>
		</div>
		<br /> <br />

		<form action="CreateNew.do">
			<h3>Add a Free Agent</h3>
			<br /> 
			
			<label>Number<input type="text" name="playerNum"/></label> <label>Name<input
				type="text" name="playerName"/></label> <label>Position<input type="text" name="position"/></label> <label>School<input
				type="text" name="school"/></label> <input class="sumbit" type="submit" name="add"
				value="Add Free Agent" />
		</form>

	</div>
</body>
</html>
