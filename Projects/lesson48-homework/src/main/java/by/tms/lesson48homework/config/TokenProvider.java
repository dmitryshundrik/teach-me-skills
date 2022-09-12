package by.tms.lesson48homework.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class TokenProvider {

    private static final String JWT_SECRET = "awr2r3223ree22g24g43g3443g4g42g";

    public String generateToken(String username) {
       return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date((new Date().getTime()) + 3600))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
}
