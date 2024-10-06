package com.company.dry;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;

public class StringUtil {

    public static String sanitizeString(String content) throws UnsupportedEncodingException {
        String sanitized = content.trim();
        sanitized = Jsoup.parse(sanitized).text();
        // convert to base64
        try {
            sanitized = new String(Base64.encodeBase64(sanitized.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw e;
        }
        return sanitized;
    }
}