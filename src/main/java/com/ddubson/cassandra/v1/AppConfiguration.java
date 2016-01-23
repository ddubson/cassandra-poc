package com.ddubson.cassandra.v1;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PoolingOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * Created by ddubson on 1/23/16.
 */
@Configuration
public class AppConfiguration {
	String host = "127.0.0.1";
	int port = 9042;

	@Bean
	public PoolingOptions poolingOptions() {
		return new PoolingOptions();
	}

	@Bean
	public Cluster cluster() {
		return Cluster.builder().withPoolingOptions(poolingOptions()).addContactPointsWithPorts(
				Lists.newArrayList(inetSocketAddress())).build();
	}

	@Bean
	public InetSocketAddress inetSocketAddress() {
		return new InetSocketAddress(host, port);
	}

	@Bean
	public ObjectMapper json() {
		return new ObjectMapper();
	}
}
