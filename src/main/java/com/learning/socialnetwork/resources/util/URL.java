package com.learning.socialnetwork.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.util.Date;

public class URL {


    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Instant convertInstant(String textInstant) {
        if (!textInstant.isEmpty()) {
            return Instant.parse(textInstant);
        } else {
            return new Date(0L).toInstant();
        }
    }
}
