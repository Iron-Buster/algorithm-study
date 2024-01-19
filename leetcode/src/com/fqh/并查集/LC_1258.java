package com.fqh.并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 17:24
 **/
public class LC_1258 {


//    1258. 近义词句子
//    第 13 场双周赛
//            Q3
//    1847
//    相关标签
//            相关企业
//    提示
//    给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text 中每个单词用它的近义词来替换。
//
//    请你找出所有用近义词替换后的句子，按 字典序排序 后返回。
//
//
//
//    示例 1：
//
//    输入：
//    synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
//    text = "I am happy today but was sad yesterday"
//    输出：
//            ["I am cheerful today but was sad yesterday",
//            "I am cheerful today but was sorrow yesterday",
//            "I am happy today but was sad yesterday",
//            "I am happy today but was sorrow yesterday",
//            "I am joy today but was sad yesterday",
//            "I am joy today but was sorrow yesterday"]

    // TODO 并查集 + 回溯
    public List<String> generateSentences(List<List<String>> synonyms, String text) {

        var ans = new ArrayList<String>();
        for (String s : text.split(" ")) {
        }
        return ans;
    }

}
