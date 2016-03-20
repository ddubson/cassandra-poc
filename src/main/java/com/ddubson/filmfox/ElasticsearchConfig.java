package com.ddubson.filmfox;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Author: ddubson
 */
@Configuration
public class ElasticsearchConfig {
    @Autowired
    Logger sysLog;
    @Value("${elasticsearch.cluster.name}")
    String clusterName;
    @Value("${elasticsearch.host}")
    String host;
    @Value("${elasticsearch.port}")
    int port;

    @Bean
    public Client elasticClient() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", clusterName).build();
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName(host), port);
        TransportClient client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(address);

        if (!client.connectedNodes().isEmpty()) {
            sysLog.info("Elasticsearch transport client created successfully.");
            sysLog.info("Elasticsearch node connected: " + client.connectedNodes().get(0));
        } else {
            sysLog.error("Elasticsearch nodes could not be found. Search capabilities will not be enabled. Is your Elasticsearch running?");
        }

        return client;
    }
}