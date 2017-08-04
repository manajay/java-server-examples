package com.lj.spring.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ByteUtil {
	
	private static Log LOG = LogFactory.getLog(ByteUtil.class);
	
	public static byte[] decompress(byte[] data) throws Exception {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(data)), out);
            byte[] unzip = out.toByteArray();
            return unzip;
        } catch (Exception e) {
            throw e;
        }
    }
	
	
	 public static byte[] compress(byte[] data) {  
	        if (data == null || data.length == 0) {  
	            return null;  
	        }  
	        ByteArrayOutputStream out = new ByteArrayOutputStream();  
	        GZIPOutputStream gzip;  
	        try {  
	            gzip = new GZIPOutputStream(out);  
	            gzip.write(data);  
	            gzip.close();  
	        } catch (IOException e) {  
	        }  
	        return out.toByteArray();  
	    }
}
