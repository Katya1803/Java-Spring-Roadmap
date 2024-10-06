package com.company.dry;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;

public class CommentController {

    public boolean saveComment(Comment comment) throws IOException {
        if (comment.getContent() == null ||  comment.getContent().trim().length() == 0) {
            return false;
        }
        String content = comment.getContent().trim();
        content = Jsoup.parse(content).text();
        // convert to base64
        try {
            content = new String(Base64.encodeBase64(content.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw e;
        }
        comment.setContent(content);
        //save comment
        return true;
    }
}