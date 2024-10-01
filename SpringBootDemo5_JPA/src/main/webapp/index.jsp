<%@page import="jakarta.persistence.Entity"%>
<%@page import ="com.springBoot.Entity.EntityClass" %>
<%@page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  
  <style>

  
  </style>
</head>
<body>
<h1 style="background-color:#7F8C8D;margin:0;">Product@Genzzzz</h1>
<header style="height:7vh;background-color:#2e4053"></header>

 <div style="padding-top:2vh;background-color:#17202A">
	      <marquee scrolldelay="10" loop="infinite">
	      <img style="height:25vh" src = "https://i0.wp.com/stanzaliving.wpcomstaging.com/wp-content/uploads/2024/05/22da9-malls-in-mumbai.jpg?fit=1000%2C678&ssl=1"/>
	      <img  style="height:25vh" src = "https://www.searchenginejournal.com/wp-content/uploads/2022/08/google-shopping-ads-6304dccb7a49e-sej.png"/>
	      <img  style="height:25vh" src = "https://images.inc.com/uploaded_files/image/1920x1080/getty_522735456_249841.jpg"/>
	      <img  style="height:25vh" src = "https://m.media-amazon.com/images/I/71oDYXoq9TL._AC_SX679_.jpg"/>
	      <img  style="height:25vh" src = "https://media.self.com/photos/656cedb0d05b27c016503a35/16:9/w_1160%2Cc_limit/adidas%2520supernova%2520rise.png"/>
	      <img  style="height:25vh" src = "https://external-preview.redd.it/google-pixel-9-key-specs-just-leaked-before-launch-theres-v0-aeQITtH6TsD7fUrLmKDdo0TQhXwPAb7Jzf0qcNbIIhw.jpg?width=1080&crop=smart&auto=webp&s=f9d06f7322c7ba52ef46ca57984322947d8bb05c"/>
	      </marquee>
	   <div style="background-color:#F4D03F;height:100vh">
	       <form action="/add" method="post">
	          <label style="margin-left:10vw;padding-top:2vh"><b>Name of the Product</b></label>
	          <input style="margin-top:2vh;width:40vw;margin-left:1vw" type="text" name="product"/>
	          <br>
	         <label style="margin-left:10vw;padding-top:2vh"><b>Category</b></label>
	          <select style="margin-top:2vh;width:40vw;margin-left:6.7vw;padding-top:0.5vh" name="category">
	          <option>Mobile</option>
	           <option>Apparels</option>
	            <option>Watches</option>
	             <option>Shoes</option>
	          </select>
	          
	          <br>
	          <label style="margin-left:10vw;padding-top:2vh"><b>Price</b></label>
	          <input style="margin-top:2vh;width:40vw;margin-left:8.7vw" type="text" name="price"/>
	          
	          <br>
	          <label style="margin-left:10vw;padding-top:2vh"><b>Photo</b></label>
	          <input style="margin-top:2vh;width:40vw;margin-left:8.1vw" type="url" name="photo"/>
	          
	          
	          <button style="margin-top:4vh;margin-left:40vw" class="btn btn-danger">add</button>
	         
	       </form>
	       
	       <hr/>
	       <form action="/search">
	       <input style="width:40vw;margin-left:7.5vw" type="text" name="search" placeholder="Enter the product ID"/>
	       <button style="margin-left:7.5vw" class="btn btn-success">Search</button>
	       </form>
	         <form action="/Page" action="get">
	       <button style="margin-left:7.5vw" class="btn btn-primary mt-2">clear</button>
	      
	      
	        <br>
	          <img style="height:60vh;margin-left:50vw" src="api/chart"/>
	      </form>
	     
	      	<div  class="container">
	      	 
	        <span style="color:blue"><b>${message}</b></span>
	       <table class="table table-striped mt-4">
	       <thead>
	           <tr>
	                <th>ID</th>
	                <th>
	                <a href="sorting?sortBy=product&orderBy=${orderBy}"> Product Name</a>
	                </th>
	                <th><a href="sorting?sortBy=category&orderBy=${orderBy}">Category</a></th>
	 				<th>Price</th>
	 				<th>Photo</th> 
	 				<th>Action</th>               
	 	        </tr>
	       </thead>
	       <tbody>
	         <%
	            List<EntityClass> lobj =(List<EntityClass>)request.getAttribute("productlist");
	         if(lobj!=null){
	            for(EntityClass x: lobj){
	         %>
	           <tr>
	             <td><%=x.getId() %></td>
	             <td><%=x.getProduct() %></td>
	             <td><%=x.getCategory() %></td>
	             <td><%=x.getPrice() %>$</td>
	             <td>
                       <img style="height:20vh"src= "<%= x.getPhoto()%>">
				</td>
					<td>
					   <a href="deleteproduct?id=<%=x.getId()%>">Delete</a>
					</td>
	            </tr>
	            <%}} %>
	       </tbody>
	       </table>
	       </div>
	    </div>
	</div> 

</body>
</html>