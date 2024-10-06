package com.company.dry;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;

public class UserController {

    public boolean saveUser(User user) throws UnsupportedEncodingException {
        if(user.getTagline() != null &&  user.getTagline().trim().length() > 0) {
             String tagline = user.getTagline().trim();
             tagline = Jsoup.parse(tagline).text(); 
             tagline = new String(Base64.encodeBase64(tagline.getBytes("UTF-8")), "UTF-8");
             user.setTagline(tagline);   
        }
        return true;
    }
}