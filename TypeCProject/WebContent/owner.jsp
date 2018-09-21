<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Page</title>
</head>
<body>

<div class="boxstart">
<h1>CD DVD Type C project</h1>
<h2>Admin Panel</h2>
</div>

<div class="box2">
 Item Name: <input type="text" name="itemNameee" />
 Item Price: <input type="text" name="itemPrice" />
 
<input type="button"  id="btn1" value="Insert" onclick="Insert()"/>

</div>
				
<div id="updateRecord">
</div>
	
	
<h3>Item List</h3>
<table class="table table-hover table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Operation</th>
	</tr>

	<c:forEach var="item" items="${item}">
		<tr>
				<td>${item.id }</td>
				<td>${item.itemName}</td>
				<td>${item.price }</td>
			
			<td><a href="#"   id="${item.id}" class="delete">Delete</a>/
			<a href="#" id="${item.id}" class="update">Update</a>
			</td> 
			</tr>
	</c:forEach>
	
	
</table>		


</body>
</html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript">

   function Insert(){
			var itemName = document.getElementsByName("itemNameee").item(0).value;
			var price = document.getElementsByName("itemPrice").item(0).value;
			debugger;
			
		        $.ajax
		        ({
		            type: "POST",         
		            data: '&itemName='+itemName+'&price='+price,
		            url: "owner?action=insertItem",
		            success:function(content)
		        {          
		            	location.reload(); 
		                alert('Item added') 
		            }           
		        });
   }

	$(".delete").click(function() {
	var id = +this.id; 
	debugger;
	
	$.ajax({
			url: "owner?action=deleteItem",
			type: "post",
			data: {
				id : id,
			},
		success : function(data){
			location.reload(); 
			alert("Item '"+id+"' deleted"); 
			
		}
			});
			});
	

	$(".update").click(function() {
		debugger;
		$("#updateRecord").empty();	
		
		
		var id = +this.id; 

		  
				var divv=document.createElement('div');
					
				var h1 = document.createElement("h3")  
				var caption=document.createTextNode('Update Record');
				h1.appendChild(caption);	
				
				var br=document.createElement('br');
					
				var captionId=document.createElement('p');
				captionId.innerHTML="ID: ";
					
				var inputId = document.createElement("INPUT");
				inputId.setAttribute("type", "text");
				inputId.setAttribute("value", id);
				inputId.setAttribute("name","itemId");
        		    
				var captionName=document.createElement('p');
				captionName.innerHTML="Name: ";
					
				var inputName = document.createElement("INPUT");
				inputName.setAttribute("type", "text");
				inputName.setAttribute("name","itemNamee");
			
				
				var captionPrice=document.createElement('p');
				captionPrice.innerHTML="price: ";
					
				var inputprice = document.createElement("INPUT");
				inputprice.setAttribute("type", "text");
				inputprice.setAttribute("name","price");
				
				
				var btn = document.createElement("button");
				var t = document.createTextNode("Updatee Record");
					
				btn.appendChild(t);

				btn.setAttribute('type', 'button');
				btn.setAttribute('onclick', "Update()");
			    
					
				    divv.appendChild(h1);
        		    divv.appendChild(captionId);
        		    divv.appendChild(inputId);
        		    divv.appendChild(br);
        		    divv.appendChild(captionName);
        		    divv.appendChild(inputName);
        		    divv.appendChild(captionPrice);
        		    divv.appendChild(inputprice);
        		    divv.appendChild(br);
        		    divv.appendChild(br);
        		    
        		    divv.appendChild(btn);
        		   
		        	document.getElementById("updateRecord").appendChild(divv);
    
	});
	
	function Update(){
		var itemNamee = document.getElementsByName("itemNamee").item(0).value;
		var itemId = document.getElementsByName("itemId").item(0).value;
		var price= document.getElementsByName("price").item(0).value;
		
		
	        $.ajax
	        ({
	            type: "POST",         
	            data: '&itemId='+itemId+'&itemNamee='+itemNamee+'&price='+price,
	            url: "owner?action=updateItem",
	            success:function(content)
	        {          
	                location.reload();

	                alert('Item updated') 
	            }           
	        });
	}

</script>






