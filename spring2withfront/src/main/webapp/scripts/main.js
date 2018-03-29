$(document).ready(function(){
	var jsons;
	   var localStorage=window.localStorage;
	   var tokens=localStorage.getItem("token");
	$.ajax({
		url:"http://localhost:9081/spring2withfront/getPage",
		type:'GET',
	       contentType:"application/json;charset=utf-8",
	        dataType:"json",
	        header:{Authorization:tokens},
	        success:function(data)
	        {

	           
	        },
	        error:function(e){
	        	window.location.href = 'http://localhost:9081/spring2withfront/logins.html';
	        }
	
		
	});

})
