package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author DengQiao
 */
public class Estest_Client {

    public static void main(String[] args) throws IOException {
        //创建客户端
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.64.3", 9200, "http")));
        esClient.close();
    }
}
