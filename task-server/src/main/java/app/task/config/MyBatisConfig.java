package app.task.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 매퍼 인터페이스를 스캔하기 위한 설정 클래스
 *
 */
@Configuration
@MapperScan("app.task")
public class MyBatisConfig {

}