thrift-inforadar
================


### generate the source(com.trs.smas.metasearch.common.thrift.*) from thrift file(InfoRadar.thrift)

    thrift -out src/main/java --gen java InfoRadar.thrift

### install metasearch.jar(jni) to local maven repository

    mvn install:install-file -DgroupId=com.trs.metasearch -DartifactId=MetaSearch -Dversion=1.0 \
    -Dfile=lib/MetaSearch-1.0.jar -Dpackaging=jar

### copy dependency to target/lib

    mvn dependency:copy-dependencies -DoutputDirectory=target/lib

### build thrift-inforadar

    mvn package

### start thrift-inforadar server

    java -jar thrift-inforadar-1.0-server.jar <port>
