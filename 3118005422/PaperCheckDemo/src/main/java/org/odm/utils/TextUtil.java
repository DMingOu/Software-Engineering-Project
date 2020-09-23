package org.odm.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.odm.bean.Word;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: TextUtil
 * @Auther: DMingO
 * @Date: 2020/9/21 10:27
 * @Description: 文本处理工具类
 */
public class TextUtil {

    private TextUtil(){
        throw new IllegalStateException("TextUtil Should not be instantiated");
    }


    /**
     * 把字符串进行分词到 词组 列表
     * @param rawText 未分词处理的文本
     * @return 词组列表
     */
    private static List<Term> string2TermList(String rawText){
        return StandardTokenizer.segment(rawText);
    }

    /**
     * 利用HanLp分词
     */
    public static List<Word> string2WordList(String sentence) {

        //1、 采用HanLP中文自然语言处理中标准分词(兼顾精度和效率)，进行分词
        List<Term> termList = HanLP.segment(sentence);
        //2、重新封装到Word对象中（term.word代表分词后的词语，term.nature代表改词的词性）
        return termList.stream().map(term ->
                new Word(term.word, term.nature.toString())).collect(Collectors.toList());
    }

//    /**
//     * 获取移除标点符号后的字符串列表
//     * @param termList 词组列表
//     * @return 移除了标点符号后的字符串列表
//     */
//    public static List<String> getStringListWithoutPunctuation(List<Term> termList){
//        List<String> strings = new ArrayList<>();
//        for(Term term : termList){
//            if(!term.toString().endsWith("/w")){
//                strings.add(term.word);
//            }
//        }
//        return strings;
//    }


    public static String formatPrint(double ans){
        double ansPer = ans * 100.0;
        String exactAnsPer = String.valueOf(ansPer);
        BigDecimal decimal = new BigDecimal(exactAnsPer);
        return decimal.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString();
    }

}
