package au.com.attari.ivcweb.crud.view;

import java.util.List;

public class JwtResponse {
    private String token;


    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

}
