package com.shynggysdimash.spring.security.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
// просто прописываем наследование, а то не будет запрашиваться форма для аудентификации

public class MySecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
