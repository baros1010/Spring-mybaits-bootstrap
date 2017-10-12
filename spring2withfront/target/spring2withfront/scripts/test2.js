$(document).ready(function(){
	var jsons;
	$.ajax({
		url:"http://localhost:9081/spring2withfront/test2",
		type:'GET',
	       contentType:"application/json;charset=utf-8",
	        dataType:"json",
	        success:function(data)
	        {
	            jsons = data;
	           $("#2").html("<h2>"+jsons.name+"</h2>");
	           alert(jsons);
	           
	        },
	        error:function(e){
	        	alert("a");
	        }
	
		
	});
	$("#1").click(function(){
		alert("hello");
	});
})
