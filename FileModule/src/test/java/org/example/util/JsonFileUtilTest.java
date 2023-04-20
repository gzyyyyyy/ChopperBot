package org.example.util;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import org.example.bean.Student;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.PackageUtils;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author Genius
 * @date 2023/04/20 11:43
 **/

public class JsonFileUtilTest {



    @Test
    public void writeClassInJsonFile() {
        Student student = new Student(
                "Genius",
                18,
                "HUST",
                "CS",
                List.of("Coding", "Reading", "Playing"),
                Map.of("QQ", "123456789", "WeChat", "987654321")
        );
        JsonFileUtil.writeJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\", "student.json", student);
        JsonFileUtil.writeBigJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\student2.json", List.of(student));
        JsonFileUtil.writeJsonFileIsExist("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\student3.json", student);

        System.out.println(JsonFileUtil.readJsonFileToObject("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\student.json", Student.class));
        System.out.println(JsonFileUtil.readJsonFileToObject("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\student2.json",List.class));
    }

    @Test
    public void readJsonFile() {
        Map maps = JsonFileUtil.readJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\", "test.json");
        Object test = maps.get("module");
        System.out.println(test);
        System.out.println(maps);
    }

    @Test
    public void writeJsonFile() {
        Map maps = JsonFileUtil.readJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\", "test.json");
        JsonFileUtil.writeJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\", "test2.json", maps);
        JsonFileUtil.writeJsonFileIsExist("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\test2.json", maps);
    }

    @Test
    public void writeJsonFileByJsonWriter() throws IOException {
        Map maps = JsonFileUtil.readJsonFile("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\", "test.json");
        Path dir = Paths.get("E:\\Project\\ChopperBot\\FileModule\\src\\main\\resources\\test2.json");
        JsonFileUtil.writeBigJsonFile(dir.toString(),maps);
    }

}
