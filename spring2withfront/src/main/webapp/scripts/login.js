$(document).ready(function(){
	 $.fn.serializeObject = function () {
         var obj = {};
         var count = 0;
         $.each(this.serializeArray(), function (i, o) {
             var n = o.name, v = o.value;
             count++;
             obj[n] = obj[n] === undefined ? v
             : $.isArray(obj[n]) ? obj[n].concat(v)
             : [obj[n], v];
         });
         //obj.nameCounts = count + "";//表单name个数
         return JSON.stringify(obj);
     };
	$("#login").click(function(){
		var serStr = $('#test').serializeObject();
		$.ajax({
			url:"http://localhost:9081/spring2withfront/login",
			type:'POST',
			async:false,
			data: serStr,
		   contentType:"application/json;charset=utf-8",
		    dataType:"text",
		        success:function(data)
		        { 
		        
		        
		        	
		        	window.location.href = 'http://localhost:9081/spring2withfront/main.html';
		        
		        	
		           
		        },
		        error:function(data){
		        	 var result = data.responseText;  
		        	  var json =$.parseJSON(result)
		        	 alert(json.errorMessage);
		        	 
		        }
		});	
		return false;
		
	})

	
})
