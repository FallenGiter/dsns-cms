package org.dsns.common.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.util.StringUtils;

public class JsonUtils {
	protected final static Logger LOG = Logger.getLogger(JsonUtils.class);
	
    private static ObjectMapper objectMapper;
	
    static {
		 objectMapper = new ObjectMapper();
		 objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion .ALWAYS);
		 objectMapper.getDeserializationConfig().without(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		 
		 setDateFormat(DateUtils.yyyy_MM_dd_HH_mm_ss);
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper) {
		JsonUtils.objectMapper = objectMapper;
	}
	
	public static void setDateFormat(String pattern) {  
        if (StringUtils.hasText(pattern)) {  
            DateFormat df = new SimpleDateFormat(pattern);  
            JsonUtils.objectMapper.getSerializationConfig().withDateFormat(df);  
            JsonUtils.objectMapper.getDeserializationConfig().withDateFormat(df);  
        }
    }
	
	
    public static <T> T fromJson(String jsonString, Class<T> clazz) {  
        if (StringUtils.isEmpty(jsonString)) {  
            return null;  
        } else {
	        try {  
	            return objectMapper.readValue(jsonString, clazz);  
	        } catch (IOException e) {  
	            return null;  
	        }  
        }
    }  
    
    public static String toJson(Object object) {  
        try {  
            return objectMapper.writeValueAsString(object);  
        } catch (IOException e) {  
            return null;  
        }  
    }  
}
