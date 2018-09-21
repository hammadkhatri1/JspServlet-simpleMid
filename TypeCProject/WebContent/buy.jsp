<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="boxstart">
<h2>Customer basket</h2>
<h3>Item Selected</h3>
</div>
<br>
Item selected: <input type="text" name="itemId" value="<%= request.getParameter("itemId") %>">

customer Id: <input type="text" name="customerId">

First Name: <input type="text" name="customerFirstName">
address: <input type="text" name="customeradress">

<input type="button" value="Buy Now!" onclick="Insert()">



</body>
</html>
<script>

function Insert(){
   			var customerFirstName = document.getElementsByName("customerFirstName").item(0).value;
   			var customeradress = document.getElementsByName("customeradress").item(0).value;
   			var itemId = document.getElementsByName("itemId").item(0).value;
   			var customerId = document.getElementsByName("customerId").item(0).value;
   			
   			
   		            $.ajax
			        ({
			            type: "POST",         
			            data: '&customerFirstName='+customerFirstName+'&customeradress='+customeradress+'&itemId='+itemId+'&customerId='+customerId,
			            url: "customer?action=Order",
			            success:function(content)
			        {          

		                    window.location = "/TypeCProject/customer";
			        }           
			        });
        }
        </script>
        