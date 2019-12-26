package com.github.tyang513.controller;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.jwt.config.encryption.SecretEncryptionConfiguration;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.pac4j.jwt.profile.JwtGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author tao.yang
 * @date 2018-05-23
 */

@Controller
@RequestMapping("/")
public class HelloWordController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(HelloWordController.class);

    public static void main(String[] args) {
        final String signingSecret ="QxQ6NrFioLTCSu6MqKFPC8pt5MIkNINMM697QuvPzguXsFItlTrN7PSGPe9DSjlxog9gGj5CpuTYAW50YGNA0j8VqWwO6V9wO9JquGit7RRMaSQS3oNotFYKFyLgl1ki8f4NrBm3dE7PUcZYdnqtpPqQqvCYLkcQbOaGYU0bsIrWG1L0nn4ZQb1azpQybSPTQUxAH493XejCPIm0IdfJogjKoAHvoS1Wcc1NwzGT02ia0gCep9NC6UzFUOFVGutd";
        final String encryptionSecret ="UEvlFYKcKse5Go2GaQnxZuED396EyyVyiHykox4lIMrIJGpR";



        System.out.println("signingSecret "+ signingSecret.getBytes().length);
        System.out.println("encryptionSecret "+  encryptionSecret.getBytes().length);

        final JwtGenerator<CommonProfile> generator = new JwtGenerator<>();
        generator.setSignatureConfiguration(new SecretSignatureConfiguration(signingSecret, JWSAlgorithm.HS256));
        generator.setEncryptionConfiguration(new SecretEncryptionConfiguration(encryptionSecret, JWEAlgorithm.DIR, EncryptionMethod.A192CBC_HS384));

        final CommonProfile profile = new CommonProfile();
        profile.setId("talkingdata");
        profile.addAttribute("userName ", "tao.yang");
        profile.addAttribute("tenantId ", "102001");
        final String token = generator.generate(profile);
        System.out.println("token: " + token);

        // JWT 验证
        JwtAuthenticator jwtAuthenticator = new JwtAuthenticator();
        jwtAuthenticator.addSignatureConfiguration(new SecretSignatureConfiguration(signingSecret, JWSAlgorithm.HS256));
        jwtAuthenticator.addEncryptionConfiguration(new SecretEncryptionConfiguration(encryptionSecret, JWEAlgorithm.DIR, EncryptionMethod.A192CBC_HS384));


        CommonProfile authenticatorProfile = jwtAuthenticator.validateToken(token);
//
        System.out.println(authenticatorProfile);
        System.out.println("id " + authenticatorProfile.getId());
        System.out.println("userName" + authenticatorProfile.getAttribute("userName"));
        System.out.println("tenantId" + authenticatorProfile.getAttribute("tenantId"));

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        logger.error("index {} ", new Date().getTime());
        return "index" + new Date().getTime();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        logger.error("hello world {}", new Date().getTime());
        return "hello world"+ new Date().getTime();
    }

}
