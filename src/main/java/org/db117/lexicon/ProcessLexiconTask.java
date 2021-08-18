package org.db117.lexicon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author db117
 * @date 2021/8/17
 */
public class ProcessLexiconTask {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 扫描所有文本
        for (InputScan inputScan : ServiceLoader.load(InputScan.class)) {
            list.addAll(inputScan.scan());
        }

        // 都转成小写的
        Set<String> ans = list.stream()
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.toSet());
        // 输出
        for (Output output : ServiceLoader.load(Output.class)) {
            output.write(ans);
        }
    }
}
