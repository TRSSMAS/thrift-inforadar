package com.trs.smas.metasearch.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trs.metasearch.Inforadar;
import com.trs.metasearch.TitleBean;
import com.trs.smas.metasearch.common.SearchEngine;
import com.trs.smas.metasearch.common.thrift.Result;
import com.trs.smas.metasearch.common.thrift.InfoRadar.Iface;

public class InfoRadarImpl implements Iface {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoRadarImpl.class);
	
	private Inforadar jniInforadar;
	
	public InfoRadarImpl(){
		jniInforadar = new Inforadar();
	}

	@Override
	public List<Result> search(String keywords, int engine, int page)
			throws TException {
		LOG.info("search ["+keywords+"] on engine ["+engine+","+SearchEngine.get(engine).getName()+"] page ["+page+"]");
		TitleBean [] docs = jniInforadar.MetaSearch(keywords, engine, page);
		List<Result> results = new ArrayList<Result>(docs.length);
		for(TitleBean doc : docs){
			if(doc == null){
				continue;
			}
			Result r = new Result();
			r.setTitle(doc.getUrltitle());
			r.setUrl(doc.getUrlname());
			r.setTime(doc.getUrltime());
			r.setSummary(doc.getAbs());
			r.setSite(doc.getSitename());
			r.setSource(doc.getSrcname());
			r.setContent(doc.getContent());
			r.setEngine(SearchEngine.get(engine).getName());
			results.add(r);
		}
		return results;
	}

}
