package org.db117.lexicon;

/**
 * @author db117
 * @date 2021/8/17
 */
public class Constant {

    /**
     * 基本路径
     */
    public static final String basePath = Constant.class
            .getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .getPath().replace("build/classes/java/main/", "");

    /**
     * 输出路径
     */
    public static final String outPath = "output/lexicon.txt";

    /**
     * 输入路径
     */
    public static final String inputPath = "input";
}
