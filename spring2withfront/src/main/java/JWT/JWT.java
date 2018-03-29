package JWT;

import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JWT {
	   private static final String SECRET = "HONGHUJWT1234567890QWERTYUIOPASDFGHJKLZXCVBNM";  
	   
	    private static final String EXP = "exp";  
	  
	    private static final String PAYLOAD = "payload";
	  
	    public static<T> String sign(T object,long maxAge){
	    	 final JWTSigner signer = new JWTSigner(SECRET);  
	    	 final Map<String, Object> claims = new HashMap<String, Object>();  
	    	// 它提供一些功能将转换成Java对象匹配JSON结构,
	            ObjectMapper mapper = new ObjectMapper(); 
	            try {
					String jsonString = mapper.writeValueAsString(object);//转换成json字符串
					claims.put(PAYLOAD, jsonString);
					claims.put(EXP, System.currentTimeMillis() + maxAge); 
					return signer.sign(claims);
				} catch (JsonProcessingException e) {
					// TODO 自動生成された catch ブロック
					return null;
				} 
	    
	    }
	    //解密  
	    public static<T> T unsign(String jwt, Class<T> classT) {  
	        final JWTVerifier verifier = new JWTVerifier(SECRET);  
	        try {  
	            final Map<String,Object> claims= verifier.verify(jwt);  
	            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {  
	                  String json = (String)claims.get(PAYLOAD);  
	                  ObjectMapper objectMapper = new ObjectMapper();  
	                  return objectMapper.readValue(json, classT);  
	  
	            }  
	            return null;  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    } 
}
