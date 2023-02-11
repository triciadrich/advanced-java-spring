package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create snowboard table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS snowboards  (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "brand VARCHAR(255) NOT NULL,type  VARCHAR(255) NOT NULL, length VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }



        //create a list snowboards
        List<Object[]> splitUpSnowboard = Stream.of("Gnu freestyle 141", "Burton all-mountain 143", "NeverSummer freeride 145", "NeverSummer powder 145")
                .map(snowboard -> snowboard.split(" "))
                .collect(Collectors.toList());

        //for each snowboard pair insert an snowboard into the database
        for (Object[] snowboard : splitUpSnowboard) {
            jdbcTemplate.execute(String.format("INSERT INTO snowboards(brand, type, length) VALUES ('%s','%s','%s')", snowboard[0], snowboard[1], snowboard[2]));
        }

        //query the database for brand NeverSummer
        jdbcTemplate.query(
                        "SELECT * FROM snowboards WHERE brand = 'NeverSummer'",
                        (rs, rowNum) -> new Snowboard(rs.getLong("id"), rs.getString("brand"), rs.getString("type"), rs.getString("length"))
                )
                //print each found employee to the console
                .forEach(snowboard -> System.out.println(snowboard.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE snowboards;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE snowboards");
    }
}
