package cn.com.sk.mybatis;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.context.annotation.Conditional;

/**
 * @author sunkai
 * @title: GetAutoEntityAndDao
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/416:24
 */
public class GetAutoEntityAndDao {
    // 该配置文件放在src\\main\\resources\\该路径下即可
    public static void main(String[] args) {
        args = new String[] { "-configfile", "/Users/sunkai/IdeaProjects/springboot-all/springboot-mybatis/src/main/resources/generatorConfig.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
