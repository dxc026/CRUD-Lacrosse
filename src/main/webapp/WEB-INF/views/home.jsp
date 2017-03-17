<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Roster</title>
	<link rel="stylesheet" href="home.css">
</head>
<body>
<div>
<div id="#test">
<table>
  <tr>
    <th></th>
    <th>Number</th>
    <th>Name</th>
    <th>Position</th>
    <th>School</th>
  </tr>
<h1>Charlotte Hounds Fantasy Team</h1>
<c:forEach items="${playerList}" var="team">
  <tr >
<td><input type="checkbox" name="name" /></td>
    <td>${ team.playerNum}</td>
    <td>${ team.playerName}</td>
    <td>${ team.position}</td>
    <td>${ team.school}</td>
  </tr>
  
<%-- 
<p>${ team.playerNum}
	${ team.playerNum}
	${ team.position}
	${ team.school}</p> --%>

</c:forEach>
</table>
</div>
<br/>
<br/>

</div>
</body>
</html>
