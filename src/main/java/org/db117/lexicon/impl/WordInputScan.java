package org.db117.lexicon.impl;

import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;
import org.db117.lexicon.Constant;
import org.db117.lexicon.InputScan;
import org.db117.lexicon.Trie;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 单词扫描
 *
 * @author db117
 * @date 2021/8/17
 */
public class WordInputScan implements InputScan {
    @Override
    public List<String> scan() {
        Trie trie = new Trie('0');

        // 已经保存的词典
        File lexicon = new File(Constant.outPath);
        read(lexicon, trie);

        for (File file : new File(Constant.inputPath).listFiles()) {
            read(file, trie);
        }

        return trie.toList();
    }


    @SneakyThrows
    private void read(File file, Trie trie) {

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
