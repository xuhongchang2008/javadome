package es.test;

import es.utils.EsClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

public class Demo1 {

    @Test
    public void testgetClient(){
        RestHighLevelClient client =  EsClient.getClient();
        System.out.println("OK");
    }
}
