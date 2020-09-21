package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.odm.MainApplication;

/**
 * Unit test for simple App.
 */
public class MainApplicationTest {

    @BeforeClass
    public static void beforeTest(){
        System.out.println("测试即将开始");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("测试结束");
    }


    /**
     * 测试 文本为空文本的情况
     */
    @Test
    public void testForEmpty(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/empty.txt","src/test/result/testEmptyResult.txt");
    }

    /**
     * 测试 输入的对比文本路径参数为错误参数的情况
     */
    @Test
    public void testForWrongOriginArgument(){
        MainApplication.process("src/test/testcase/123.txt","src/test/testcase/orig_0.8_add.txt","src/test/result/testAddResult.txt");
    }

    /**
     * 测试 输出文件路径参数为错误参数的情况
     */
    @Test
    public void testForWrongOutputArgument(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig.txt","src/test/result/testAddResult.word");
    }

    /**
     * 测试20%文本添加情况：orig_0.8_add.txt
     */
    @Test
    public void testForAdd(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_add.txt","src/test/result/testAddResult.txt");
    }

    /**
     * 测试20%文本删除情况：orig_0.8_del.txt
     */
    @Test
    public void testForDel(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_del.txt","src/test/result/testDelResult.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_1.txt
     */
    @Test
    public void testForDis1(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_dis_1.txt","src/test/result/testDis1Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_3.txt
     */
    @Test
    public void testForDis3(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_dis_3.txt","src/test/result/testDis3Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_7.txt
     */
    @Test
    public void testForDis7(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_dis_7.txt","src/test/result/testDis7Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_10.txt
     */
    @Test
    public void testForDis10(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_dis_10.txt","src/test/result/testDis10Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_15.txt
     */
    @Test
    public void testForDis15(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_dis_15.txt","src/test/result/testDis15Result.txt");
    }

    /**
     * 测试20%文本格式错乱情况：orig_0.8_mix.txt
     */
    @Test
    public void testForMix(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_mix.txt","src/test/result/testMixResult.txt");
    }

    /**
     * 测试20%文本错别字情况：orig_0.8_rep.txt
     */
    @Test
    public void testForRep(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_0.8_rep.txt","src/test/result/testRepResult.txt");
    }

    /**
     * 测试相同文本：orig.txt
     */
    @Test
    public void testForSame(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig.txt","src/test/result/testSameResult.txt");
    }

    /**
     * 测试文本的子集文本：orig_sub.txt
     */
    @Test
    public void testForSub(){
        MainApplication.process("src/test/testcase/orig.txt","src/test/testcase/orig_sub.txt","src/test/result/testSubResult.txt");
    }

}
