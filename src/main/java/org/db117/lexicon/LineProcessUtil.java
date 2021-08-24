package org.db117.lexicon;

import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author db117
 * @date 2021/8/24
 */
public class LineProcessUtil {

    @SneakyThrows
    public static void read(File file, Trie trie) {

        FileUtil.readLines(new RandomAccessFile(file, "r"),
                StandardCharsets.UTF_8,
                line -> lineHandle(line, trie));

    }

    /**
     * 行处理
     *
     * @param line 行
     */
    private static void lineHandle(String line, Trie root) {
        char[] chars = line.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isLowerCase(c)) {
                if (i == chars.length - 1) {
                    // 行最后一个单词
                    Trie.addWord(root, chars, start, i);
                }
                continue;
            }

            if (Character.isUpperCase(c)) {
                if (i > start) {
                    Trie.addWord(root, chars, start, i - 1);
                }
                // 大写字符单词从当前开始
                start = i;
                continue;
            }

            // 非字符
            if (i > start) {
                Trie.addWord(root, chars, start, i - 1);
            }
            // 单词从下一个字符开始
            start = i + 1;
        }
    }
}
