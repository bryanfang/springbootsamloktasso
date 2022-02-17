package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/home")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Saml2Authentication authentication = (Saml2Authentication) auth;
        String saml2Response = authentication.getSaml2Response();
        logger.info("Saml2 response is {}.", saml2Response);
        return "index.html";
    }
}
