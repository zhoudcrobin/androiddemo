package com.example.androiddemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 
 *  
 * @author zhoudongchu
 */
public class StreamTool {
    public static byte[] read(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        if((len=inStream.read(buffer))!=1){
            outStream.write(buffer,0,len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}

