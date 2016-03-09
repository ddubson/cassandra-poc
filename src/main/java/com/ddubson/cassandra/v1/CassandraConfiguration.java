package com.ddubson.cassandra.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by ddubson on 1/23/16.
 */
@Configuration
@EnableCassandraRepositories(
        basePackages = "com.ddubson.cassandra.v1.repositories")
public class CassandraConfiguration extends AbstractCassandraConfiguration {
	String host = "127.0.0.1";
	int port = 9042;
    String keySpace = "movies_keyspace";

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
