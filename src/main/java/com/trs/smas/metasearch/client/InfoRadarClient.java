package com.trs.smas.metasearch.client;

import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.trs.smas.metasearch.common.SearchEngine;
import com.trs.smas.metasearch.common.thrift.InfoRadar;
import com.trs.smas.metasearch.common.thrift.Result;
import com.trs.smas.metasearch.exception.MetaSearchException;

public class InfoRadarClient {
	
	private String host;
	private int port;
	
	public InfoRadarClient(String host,int port){
		this.host = host;
		this.port = port;
	}
	
	public List<Result> search(String keywords,int engine,int page) throws MetaSearchException{
		TTransport transport = new TSocket(host,port);
		TProtocol protocol = new TBinaryProtocol(transport);
		InfoRadar.Client client = new InfoRadar.Client(protocol);
		try {
			transport.open();
			return client.search(keywords, engine, page);
		} catch (TException e) {
			throw new MetaSearchException("fail to search :{keywords:["
					+ keywords + "],engine:[" + engine + "],page:[" + page
					+ "]} on {host:[" + host + "],port:[" + port + "]}", e);
		} finally {
			transport.close();
		}
	}
	
	public static void main(String [] args){
		try {
			List<Result> results = new InfoRadarClient("192.168.50.99",8000).search("百度", SearchEngine.Baidu.getCode(), 1);
			System.out.println("total "+ results.size() + " results.");
			for(Result r : results){
				System.out.println(r.getTitle());
				System.out.println(r.getUrl());
				System.out.println(r.getEngine());
			}
		} catch (MetaSearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
