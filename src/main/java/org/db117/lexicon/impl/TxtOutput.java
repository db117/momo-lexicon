package org.db117.lexicon.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import org.db117.lexicon.Constant;
import org.db117.lexicon.Output;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * 输出到output txt
 *
 * @author db117
 * @date 2021/8/17
 */
public class TxtOutput implements Output {

    @Override
    public void write(Collection<String> words) {
        File file = new File(Constant.outPath);
        // 先删除
        FileUtil.del(file);
        PrintWriter printWriter = FileWriter.create(file, StandardCharsets.UTF_8)
                .getPrintWriter(true);
        words.stream()
                .sorted()
                .forEach(printWriter::println);

        printWriter.flush();
    }
}
