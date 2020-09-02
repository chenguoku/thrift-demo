package com.hh.thrift.client;

import com.hh.thrift.service.HelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @Classname: HelloClient
 * @Description: TODO
 * @Author: chenguoku
 * @Date 2020-9-2
 * @Version V1.0
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("127.0.0.1", 9090);

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            HelloService.Client client = new HelloService.Client(protocol);

            String name = "hh";
            System.out.println("请求入参==> name:" + name);
            String result = client.sayHello(name);
            System.out.println("返回结果==> " + result);

            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
