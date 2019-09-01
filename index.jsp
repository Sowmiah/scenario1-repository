<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My app</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
</head>
<body>
<h1>Spring Boot</h1>
	<form:form id="empModel" method="get" modelAttribute="empModel">
		<label>Name</label>
		<form:input path="name"/>
		<label>Age</label>
		<form:input path="age"/>
		<div id="selectbox" style="width:50%; background-color:red">
			<label>Gender</label>
			<form:select path="gender" multiple="true" style=" min-width:30%">
				<form:option value="Male" label="Maleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"></form:option>
				<form:option value="Female" label="Femaleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"></form:option>
				<form:option value="Female" label="Femaleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeegdfgdfgdfgdeeeeeefyyyyyyyyyhjkkgyhujkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"></form:option>
			</form:select>
		</div>	
		<input type="button" value="Submit" id="submit" onclick="editFunction()"/>
	</form:form>
	
	<table id = "dataEg" width="100%">
		<thead>
			<th>Employee Name</th>
			<th>Age</th>
			<th>Gender</th>
		</thead>
		<tbody>
			<!-- <tr>
				<td>111</td>
				<td>gdg</td>
			</tr>
			<tr>
				<td>222</td>
				<td>fgdfhd</td>
			</tr>
			<tr>
				<td>123</td>
				<td>hfghfgh</td>
			</tr>
			<tr>
				<td>234</td>
				<td>hghngfcb</td>
			</tr>
			<tr>
				<td>345</td>
				<td>fbhdfb</td>
			</tr>
			<tr>
				<td>134</td>
				<td>bdfxh</td>
			</tr> -->
		</tbody>
	</table>
	
	<input type="button" name="edit" id="edit" value="Edit" '/>
	<input type="button" name="save" id="save" value="Save"/>
	
	
	<script>
	var $oTable;
	
	$(document).ready(function() {
		$("#submit").on("click", function() {
			
			var model = $('#empModel').serialize();
			var clothing = ['shoes', 'shirts', 'socks', 'sweaters'];
			
			$.ajax({
				  url: "/hello",
				  method: "GET",
				  data: {
					  clothing : clothing
				  } ,
				  success: function(response) {
					  alert('done')
				  },
				  error: function(error) {
					  alert("error")
				  }
				});
		});
		
		$oTable = $('#dataEg').dataTable( {
			"bProcessing": true,
			"bServerSide": true,
			"sAjaxSource": '/hello',
			"aoColumns": [
				{ "mData": "name" },
				{ "mData": "age" },
				{ "mData": "gender" },
				],
				"paging": false,
			    "searching": false,
			    "retrieve": true,
			    "destroy": true,
		} );
		
		console.log($oTable.dataTable().fnGetNodes());

		
		
	 	$('#edit').on( 'click', function () {
			
			var $trs = $oTable.find("tbody").find("tr");
			
			var $tds =  $oTable.find("tr").not(':first-child'); 
			
			$.each($tds , function(i, el) {
				 
				 /*  var $td =  $oTable.find("td").not(':first');
		          var txt = $(this).text();
		          var addr = $(this).val();
		          $(this).not('').html('').append("<input type='text' value='" + txt +  addr + "'>");  */
		          
		          var that = $(this);
		          if (that.find('input').length > 0) {
		              return;
		          }
		          var currentText = that.text();
		          
		          var $input = $('<input type="text">').val(currentText);
		          
		          $(this).not('').html('');
		          
		          $(this).append($input);
		          
		        }); 
			 
			
			  /* $.each("#dataEg tr td" , function(i, el) {
		          var txt = $(this).text();
		          var addr = $(this).val();
		          $(this).html("").append("<input type='text' id='addr' value='" + txt + addr + "'>");
		        }); */  
			
			
			console.log($oTable);
		});
		
	
		 $('#save').on( 'click', function () {
			console.log($oTable);
			
		}); 
		
	});
	
	function editFunction() {
		
		/* var $trs = $oTable.find("tbody").find("tr");
		
		$.each($trs , function(i, el) {
		
			var tdName = $trs.children("td:nth-child(1)"); 
			var txtAge = $trs.children("td:nth-child(2)"); 
			var txtGender = $trs.children("td:nth-child(3)");
		
			tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
			txtAge.html("<input type='text' id='txtAge' value='"+txtAge.html()+"'/>");
			txtGender.html("<input type='text' id='txtGender' value='"+txtGender.html()+"'/>");
		
		}); */
}
	
	</script>
</body>
</html>
