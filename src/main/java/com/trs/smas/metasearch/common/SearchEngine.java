package com.trs.smas.metasearch.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchEngine {
	
	private int code;
	private String name;

	private SearchEngine(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static final SearchEngine Google;
	public static final SearchEngine Baidu;
	public static final SearchEngine Bing;
	public static final SearchEngine Yahoo;
	public static final SearchEngine Sogou;
	public static final SearchEngine Soso;
	public static final SearchEngine GoogleNews;
	public static final SearchEngine GoogleNewsEn;
	public static final SearchEngine GoogleNewsTw;
	public static final SearchEngine GoogleNewsHk;
	public static final SearchEngine BaiduNews;
	public static final SearchEngine BingNews;
	public static final SearchEngine YahooNews;
	public static final SearchEngine SogouNews;
	public static final SearchEngine SosoNews;
	public static final SearchEngine GA;
	
	public static final Collection<SearchEngine> supportedSearchEngine;

	public static final SearchEngine get(int code) {
		for (SearchEngine engine : supportedSearchEngine) {
			if (engine.code == code) {
				return engine;
			}
		}
		return null;
	}
	
	static{
		Baidu 			= new SearchEngine(0x0001, "百度");
		Google 			= new SearchEngine(0x0002, "谷歌");
		BaiduNews 		= new SearchEngine(0x0004, "百度新闻");
		GoogleNews		= new SearchEngine(0x0008, "谷歌新闻");
		Bing 			= new SearchEngine(0x0010, "必应");
		BingNews 		= new SearchEngine(0x0020, "必应资讯");
		Yahoo 			= new SearchEngine(0x0040, "雅虎");
		YahooNews 		= new SearchEngine(0x0080, "雅虎新闻");
		Sogou 			= new SearchEngine(0x0100, "搜狗");
		SogouNews 		= new SearchEngine(0x0200, "搜狗新闻");
		Soso 			= new SearchEngine(0x0400, "搜搜");
		SosoNews 		= new SearchEngine(0x0800, "搜搜新闻");
		GoogleNewsEn 	= new SearchEngine(0x1000, "谷歌新闻(英)");
		GoogleNewsTw 	= new SearchEngine(0x2000, "谷歌新闻(台)");
		GoogleNewsHk 	= new SearchEngine(0x4000, "谷歌新闻(港)");
		GA 				= new SearchEngine(0x8000, "");
		List<SearchEngine> engines = new ArrayList<SearchEngine>(16);
		engines.add(Baidu);
		engines.add(Google);
		// engines.add(Google);
		engines.add(Bing);
		engines.add(Yahoo);
		engines.add(Sogou);
		engines.add(Soso);

		// engines.add(GoogleNews);
		// engines.add(GoogleNewsTw);

		engines.add(BaiduNews);
		engines.add(GoogleNewsHk);
		// engines.add(GoogleNewsEn);
		engines.add(BingNews);
		engines.add(YahooNews);
		engines.add(SogouNews);
		engines.add(SosoNews);

		supportedSearchEngine = engines;
	}
}
