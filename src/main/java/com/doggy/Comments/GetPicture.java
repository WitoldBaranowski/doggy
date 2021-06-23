package com.doggy.Comments;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;


public class GetPicture {

    public String returnPics() throws IOException {
        String url = "https://dog.ceo/api/breeds/image/random";
        String charset = "UTF-8";
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        InputStreamReader isReader = new InputStreamReader(response);
        BufferedReader reader = new BufferedReader(isReader);
        String str = reader.readLine();
        String[] actualValue = str.split("\"");
        return actualValue[3];
    }

    public GetPicture() {
    }
}
