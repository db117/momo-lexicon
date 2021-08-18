package org.db117.lexicon;

import java.util.List;

/**
 * @author db117
 * @date 2021/8/17
 */
public interface InputScan {
    /**
     * 扫描字典
     *
     * @return {@link List}<{@link String}>
     */
    List<String> scan();
}
