package com.example.readbook.Controller.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.readbook.Model.TblUser;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME = 10*60*60*1000; //token到期时间10小时
    private static final String TOKEN_SECRET = "ljdyaishijin**3nkjnj??";            //设置密钥
    private static Date expireAtTime;

    /**
     * 生成token
     * **/
    public static String sign(TblUser tblUser){
        String token = null;
        try {
            Date expireAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            expireAtTime = expireAt;
            token = JWT.create()
                    .withClaim("role",tblUser.getRole())        //存放用户角色
                    .withIssuer("auth0")    //发行人
                    .withClaim("username",tblUser.getName())    //存放用户名

                    .withExpiresAt(expireAt)                          //过期时间
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        }catch (IllegalArgumentException| JWTCreationException je){

        }
        return token;
    }

    /**
     * @Description  ：token验证
     */
    public static Boolean verify(String token){

        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("username: " + decodedJWT.getClaim("username").asString());
//            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    /**
     * 验证是否过期
     * **/
    public static Boolean isTokenExpired(String token){
        try {
            return expireAtTime.before(new Date());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户名
     * **/
    public static String getUsername(String token){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT.getClaim("username").asString();
    }

    /**
     * 获取用户名
     * **/
    public static String getUsername1(String token){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT.getIssuer();
    }

    /**
     * 获取角色
     * **/
    public static String getRole(String token){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT.getClaim("role").asString();
    }
}
