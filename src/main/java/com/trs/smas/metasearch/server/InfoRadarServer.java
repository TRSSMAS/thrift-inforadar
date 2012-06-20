package com.trs.smas.metasearch.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.trs.smas.metasearch.common.thrift.InfoRadar;
import com.trs.smas.metasearch.common.thrift.InfoRadar.Processor;

public class InfoRadarServer {
	
	private static final int DEFAULT_PORT = 8001;

	private TServer server;
	private int port;
	
	public InfoRadarServer(int port) throws TTransportException{
		this.port = port;
		InfoRadar.Processor<InfoRadarImpl> processor = new Processor<InfoRadarImpl>(new InfoRadarImpl());
		TServerTransport serverTransport = new TServerSocket(port);
		server = new TThreadPoolServer(new Args(serverTransport).processor(processor));
	}
	
	public void start(){
		System.out.println("start inforadar server on " + String.valueOf(port) + " ...");
		server.serve();
	}
	
	public void stop(){
		System.out.println("stop inforadar server ...");
		server.stop();
		System.out.println("inforadar server stoped.");
	}

	public static void main(String [] args) {
		int port = DEFAULT_PORT;
		if(args.length > 0){
			port = Integer.parseInt(args[0]);
		}
		try {
			new InfoRadarServer(port).start();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
