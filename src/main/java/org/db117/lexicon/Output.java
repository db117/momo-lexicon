package org.db117.lexicon;

import java.util.Collection;

/**
 * 输出单词
 *
 * @author db117
 * @date 2021/8/17
 */
public interface Output {


    /**
     * 输出字典
     *
     * @param words 单词
     */
    void write(Collection<String> words);
}
