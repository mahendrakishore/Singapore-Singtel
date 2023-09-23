package stepdefination;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	 private static final String GET_RESPONSE = "GET_RESPONSE";
	 private static final String POST_REQUEST_STRING = "POST_REQUEST_STRING";	
	 private static final String POST_RESPONSE = "POST_RESPONSE";
	 private static final String COMMENT_REQUEST_STRING = "POST_REQUEST_STRING";	
	 private static final String COMMENT_RESPONSE = "POST_RESPONSE";	

	    private static final String BASEURI = "BASEURI";
	    ThreadLocal<Map<String,Object>> localThread = ThreadLocal.withInitial(HashMap::new);

	    private  Map<String,Object>  testContextMap(){
	        return localThread.get();
	    }


	    public void set(String key,Object value) {
	        testContextMap().put(key,value);
	    }
	    public Object get(String key) {
	        return testContextMap().get(key);
	    }
	    public <T> T get(String key, Class<T> clz ) {
	        return clz.cast(testContextMap().get(key));
	    }

	    public void setGetResponse(Object val){
	        set(GET_RESPONSE,val);
	    }
	    public Object getGetResponse(){
	     return get(GET_RESPONSE);
	    }
	    public void setUri(String val){
	        set(BASEURI,val);
	    }
	    public String getUri(){
	     return (String) get(BASEURI);
	    }
	    
	    public void setPostRequestString(Object val){
	        set(POST_REQUEST_STRING,val);
	    }
	    public Object getPostRequestString(){
	     return get(POST_REQUEST_STRING);
	    }

	    public void setPostResponse(Object val){
	        set(POST_RESPONSE,val);
	    }
	    public Object getPostResponse(){
	     return get(POST_RESPONSE);
	    }
	    public void setCommentOnPostRequestString(Object val){
	        set(COMMENT_REQUEST_STRING,val);
	    }
	    public Object getCommentOnPostRequestString(){
	     return get(COMMENT_REQUEST_STRING);
	    }

	    public void setCommentOnPostResponse(Object val){
	        set(COMMENT_RESPONSE,val);
	    }
	    public Object getCommentOnPostResponse(){
	     return get(COMMENT_RESPONSE);
	    }

}
