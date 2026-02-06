package com.busanit501.jsp_server_project_260205.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

// HikariCP를 사용하여 효율적인 데이터베이스 연결
public enum ConnectionUtil {
    // 클래스가 메모리에 딱 한번만 생성되도록 함
    INSTANCE;
    // DB에 연결하는 도구
    private HikariDataSource ds;

    //생성자
    // ds 에다 config(데이터베이스 Mriabd연결) 를 넣는다!
    ConnectionUtil() {
        // HikariConfig 클래스 객체생성 및 옵션 설정
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        // PreparedStatement 캐시 설정
        // - **개념**: PreparedStatement 캐싱 기능을 활성화하는 기본 옵션입니다.
        config.addDataSourceProperty("cachePrepStmts", "true");
        // 각 연결(Connection)당 캐시할 수 있는 PreparedStatement의 최대 개수입니다.
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        //- **개념**: 캐시할 수 있는 SQL 문의 최대 길이(문자 수)입니다.
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        // HikariDataSource 클래스에, 위의 설정 config 클래스를 담아주기
        ds = new HikariDataSource(config);

    }
    // 외부(DAO 등)에서 DB 작업이 필요할 때 호출하는 창구입니다.
    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }

    // 닫는 메서드 추가.
    public void closePool() {
        if (ds != null && !ds.isClosed()){
            ds.close(); // 풀 전체 종료
        }
    }

}
