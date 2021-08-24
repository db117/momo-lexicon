package org.db117.lexicon.impl;

import org.db117.lexicon.InputScan;
import org.db117.lexicon.LineProcessUtil;
import org.db117.lexicon.Trie;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * 导入 idea Scratches 目录下单词
 *
 * @author db117
 * @date 2021/8/24
 */
public class ScratchesInputScan implements InputScan {
    private static final String homePath = System.getProperty("user.home");
    private static final String JetBrainsPath = homePath + "/Library/Application Support/JetBrains";
    private static final String wordPath = "/scratches/lexicon.txt";


    @Override
    public List<String> scan() {
        File rootFile = new File(JetBrainsPath);
        if (!rootFile.exists()) {
            return Collections.emptyList();
        }
        File[] files = rootFile.listFiles();
        if (files == null) {
            return Collections.emptyList();
        }

        Trie root = new Trie();
        for (File file : files) {
            // 找到所有 lexicon.txt
            String wordPath = file.getPath() + ScratchesInputScan.wordPath;
            File wordFile = new File(wordPath);
            if (wordFile.exists()) {
                LineProcessUtil.read(wordFile, root);
            }
        }
        return root.toList();
    }
}
