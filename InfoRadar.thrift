namespace java com.trs.smas.metasearch.common.thrift

struct Result {
  1: string title,
  2: string time,
  3: string url,
  4: string site,
  5: string source,
  6: string summary,
  7: string content,
  8: string engine,
}

service InfoRadar{
	list<Result> search(1:string keywords,2:i32 engine,3:i32 page);
}