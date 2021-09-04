package io.github.sunshine001.guava;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class GPost {
    private String url;
    private Map<String, String> headers = null;
    private Map<String, String> body = null;

    public static GPost n() {
        return new GPost();
    }

    public GPost setUrl(String url) {
        this.url = url;
        return this;
    }

    public GPost setHeaders(GMap<String> headers) {
        this.headers = headers.build();
        return this;
    }

    public GPost setBody(GMap<String> body) {
        this.body = body.build();
        return this;
    }

    public GResponse exec() {
        try {
            URL _url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            setConnectionHeaders(conn);

            OutputStream outputStream = conn.getOutputStream();
            setConnectionBody(outputStream);
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder responseBody = new StringBuilder();
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                responseBody.append(line);
            }
            inputStream.close();
            return new GResponse(200, null, responseBody.toString());
        } catch (IOException ioe) {
            return new GResponse(500, ioe.fillInStackTrace().toString(), null);
        }
    }

    private void setConnectionHeaders(HttpURLConnection conn) {
        if (headers == null) return ;
        headers.forEach((key, value)->{
            conn.setRequestProperty(key, value);
        });
    }

    private void setConnectionBody(OutputStream outputStream) throws IOException {
        if (body == null) return;
        StringBuilder params = new StringBuilder();
        body.forEach((key, value) -> {
            if (params.length() > 0)
                params.append("&");
            params.append(key).append("=").append(value);
        });
        outputStream.write(params.toString().getBytes());
    }
}
