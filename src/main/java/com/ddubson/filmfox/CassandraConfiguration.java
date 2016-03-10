package com.ddubson.filmfox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by ddubson on 1/23/16.
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableCassandraRepositories(
        basePackages = "com.ddubson.filmfox.repositories")
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${cassandra.host}")
	String host;
    @Value("${cassandra.port}")
	int port;
    @Value("${cassandra.keyspace}")
    String keySpace;

	@Bean
	public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        cluster.setContactPoints(this.host);
        cluster.setPort(this.port);
        return cluster;
	}

    @Override
    protected String getKeyspaceName() {
        return this.keySpace;
    }

    @Bean
	public CassandraMappingContext cassandraMapping()
			throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
