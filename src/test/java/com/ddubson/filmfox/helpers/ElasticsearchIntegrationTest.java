package com.ddubson.filmfox.helpers;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileSystemUtils;

import java.io.File;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Author: ddubson
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class ElasticsearchIntegrationTest {
    private static final String HTTP_PORT = "9205";
    private static final String HTTP_TRANSPORT_PORT = "9305";
    private static final String ES_WORKING_DIR = "target/es";
    private static Node node;

    @BeforeClass
    public static void startElasticsearch() throws Exception {
        removeOldDataDir(ES_WORKING_DIR + "/my-application");

        Settings settings = Settings.builder()
                .put("path.home", ES_WORKING_DIR)
                .put("path.conf", ES_WORKING_DIR)
                .put("path.data", ES_WORKING_DIR)
                .put("path.work", ES_WORKING_DIR)
                .put("path.logs", ES_WORKING_DIR)
                .put("http.port", HTTP_PORT)
                .put("transport.tcp.port", HTTP_TRANSPORT_PORT)
                .put("index.number_of_shards", "1")
                .put("index.number_of_replicas", "0")
                .put("discovery.zen.ping.multicast.enabled", "false")
                .build();
        node = nodeBuilder().settings(settings).clusterName("my-application").client(false).node();
        node.start();

        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder()
                .addContactPoints("127.0.0.1").withPort(9142).build();
        Session session = cluster.connect();
    }

    @AfterClass
    public static void stopElasticsearch() {
        node.close();
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }

    private static void removeOldDataDir(String datadir) throws Exception {
        File dataDir = new File(datadir);
        if (dataDir.exists()) {
            FileSystemUtils.deleteRecursively(dataDir);
        }
    }
}
