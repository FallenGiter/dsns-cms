package org.dsns.common.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.dsns.common.utils.DateUtils;


public class JsonDateSerializer extends JsonSerializer<Date> {
	private static final DateFormat DF = new SimpleDateFormat(DateUtils.yyyy_MM_dd_HH_mm_ss);
	
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		String dateStr = DF.format(value);
		 
		jgen.writeString(dateStr);
	}
}
