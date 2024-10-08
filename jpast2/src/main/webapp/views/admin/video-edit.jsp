<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>

<form  method="post" enctype="multipart/form-data">
    <label for="Videoid">Video ID:</label><br>
    <input type="text" id = "videoid" name = "videoid" value="${video.videoId }" readonly><br>
    <label for="Title">Video Name:</label><br>
    <input type="text" id="title" name="title" value="${video.title }"><br>
    <label for="Description">Description:</label><br>
    <input type="text" id="description" name="description" value=${video.description }><br>
	<input type="file" onchange="chooseFile(this)" id="poster" name="poster" var="imgUrl"><br>	
    <label for="poster">Poster:</label><br> 
  
		<c:if test="${video.poster.substring(0,5) != 'https'}">
			<c:url value="/image?fname=${video.poster }" var="imgUrl"></c:url>
		</c:if>			
		<c:if test="${video.poster.substring(0,5) == 'https'}">
			<c:url value="${video.poster } " var="imgUrl"></c:url>
		</c:if>	
		<img id="imagess" height="150" width="200" src="${imgUrl} name="poster" />	
	
	
    <label for="Activeon">Active : </label>
    <input id="activeon" type="radio" name="active" value="1" ${video.active==1?'checked': ''}>
    <label for="activeon">Hoạt động</label>
    <input id="activeoff" type="radio" name="active" value="0" ${video.active==0?'checked': ''}>
    <label for="activeoff">Khóa</label>

    <br>
    <label for="views">Số lượt xem:</label><br>
    <input type="text" id="views" name="views" value="${video.views }"><br>

    <br> <input type="submit" value="Submit">
</form>