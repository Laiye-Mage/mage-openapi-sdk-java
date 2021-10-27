package com.util;

import java.net.URI;

public class DefaultProfile {

    private static URI endpoint = URI.create("https://mage.uibot.com.cn/");
    private static String apiVersion = "v1";

    public static URI getEndpoint() {
        return endpoint;
    }

    public static String getApiVersion() {
        return apiVersion;
    }

    public static void setApiVersion(String apiVersion) {
        DefaultProfile.apiVersion = apiVersion;
    }

    public static void setEndpoint(URI endpoint) {
        DefaultProfile.endpoint = endpoint;
    }
}
