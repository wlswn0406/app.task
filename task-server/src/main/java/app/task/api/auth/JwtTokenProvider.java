package app.task.api.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String createToken(String userId) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtExpiration);

        return JWT.create()
                .withSubject(userId)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    public boolean validateToken(String token) {
        try {
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(jwtSecret))
                    .build()
                    .verify(token);

            return !jwt.getExpiresAt().before(new Date());
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUserId(String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .build()
                .verify(token)
                .getSubject();
    }

    public Map<String, Object> getClaims(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(jwtSecret))
                .build()
                .verify(token);

        Map<String, Object> claims = new HashMap<>();
        jwt.getClaims().forEach((key, value) -> claims.put(key, value.asString()));

        return claims;
    }

}