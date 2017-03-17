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
<br/>
<br/>

<div>
<form>
<input type="submit" name="Edit" value="Edit">
<input type="submit" name="Delete" value="Delete Selected Items">
</form>
</div>

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

<form>
<h3>Add a Free Agent</h3>
<br/>
<label>Number<input type="text" /></label>
<label>Name<input type="text" /></label>
<label>Position<input type="text" /></label>
<label>School<input type="text" /></label>
<input class="sumbit" type="submit" name="add" value="Add Free Agent"/>
</form>

</div>
</body>
</html>
