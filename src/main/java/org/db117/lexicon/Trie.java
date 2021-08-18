package org.db117.lexicon;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树
 *
 * @author db117
 * @date 2021/8/17
 */
public class Trie {
    // 当前字符
    char cur;
    // 后续字符
    Trie[] child;
    // 是否是结尾
    boolean over;

    private final static Trie root = new Trie('0');

    public Trie(char c) {
        this.cur = c;
        child = new Trie[26];
    }

    public static void addWord(Trie cur, char[] chars, int i, int end) {
        if (i >= chars.length || i > end) {
            // 后面没有了
            cur.over = true;
            return;
        }

        char c = chars[i];
        boolean lowerCase = Character.isLowerCase(c);

        // 索引位置
        int index = lowerCase ? c - 'a' : c - 'A';

        if (cur.child[index] == null) {
            cur.child[index] = new Trie(lowerCase ? c : (char) (c + 32));
        }

        addWord(cur.child[index], chars, i + 1, end);
    }

    /**
     * 转为集合
     *
     * @return {@link List}<{@link String}>
     */
    public List<String> toList() {
        List<String> ans = new ArrayList<>();

        StringBuilder b = new StringBuilder();
        for (Trie trie : this.child) {
            if (trie == null) {
                continue;
            }
            dfs(ans, trie, b);
        }
        return ans;
    }

    // 回溯
    private void dfs(List<String> ans, Trie trie, StringBuilder b) {
        if (trie == null) {
            return;
        }
        b.append(trie.cur);
        if (trie.over) {
            ans.add(b.toString());
        }

        for (Trie t : trie.child) {
            dfs(ans, t, b);
        }

        b.deleteCharAt(b.length() - 1);
    }
}
