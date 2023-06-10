package com.github.erikrz.contacts.client.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * ContentTypeInterceptor.
 */
public class ContentTypeInterceptor implements RequestInterceptor {

    private static final String CONTENT_TYPE = "Content-Type";

    private final String contentType;

    public ContentTypeInterceptor() {
        this("application/json");
    }

    public ContentTypeInterceptor(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(CONTENT_TYPE, contentType);
    }

}
