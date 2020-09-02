package com.hh.thrift.server;

import com.hh.thrift.service.HelloService;
import com.hh.thrift.service.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * @Classname: HelloServer
 * @Description: TODO
 * @Author: chenguoku
 * @Date 2020-9-2
 * @Version V1.0
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            TServerSocket serverSocket = new TServerSocket(9090);
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();

            /**
             * 关联处理器与GreetingService服务实现
             */
            TProcessor processor = new HelloService.Processor<>(new HelloServiceImpl());

            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverSocket);
            serverArgs.processor(processor);
            serverArgs.protocolFactory(proFactory);

            TServer server = new TThreadPoolServer(serverArgs);
            System.out.println("Start server on port 9090...");

            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
