package org.db117.lexicon.impl;

import org.db117.lexicon.Constant;
import org.db117.lexicon.InputScan;
import org.db117.lexicon.LineProcessUtil;
import org.db117.lexicon.Trie;

import java.io.File;
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
        Trie trie = new Trie();

        // 已经保存的词典
        File lexicon = new File(Constant.outPath);
        LineProcessUtil.read(lexicon, trie);

        for (File file : new File(Constant.inputPath).listFiles()) {
            LineProcessUtil.read(file, trie);
        }

        return trie.toList();
    }
}
