package org.odm;

import org.odm.utils.ConvertUtil;
import org.odm.utils.SimilarTextCalculator;
import org.odm.utils.TextUtil;
import java.io.File;

/**
 * @Author DMingO
 * @Description 主程序
 * @Date  2020/9/21 10:20
 **/
public class MainApplication {

    /**
     * @Author DMingO
     * @Description 主程序入口
     * @Date  2020/9/21 13:12
     * @Param [args]
     * @return void
     **/
    public static void main( String[] args ) {

        process(args[0],args[1],args[2]);

        System.exit(0);

    }


    /**
     * @Author DMingO
     * @Description 执行操作
     * @Date  2020/9/21 11:19
     * @Param [orgFileName, orgAddFileName, ansFilePath]原文文件路径,抄袭版论文的文件路径,答案文件路径
     * @return void
     **/
    public static void process(String orgTextPath,String newTextPath,String ansFilePath){
        File originFile = new File(orgTextPath);
        File newFile = new File(newTextPath);
        if(! originFile.exists() || ! newFile.exists()){
            System.out.println("The file path is invalid, please check the file path parameter !\n");
            return;
        }
        String orgString = ConvertUtil.convertTextFile2String(orgTextPath);
        String newString = ConvertUtil.convertTextFile2String(newTextPath);
        //执行计算
        double ans = SimilarTextCalculator.getSimilarity(orgString , newString);
        //将结果字符串输出到 指定的文件
        String ansString = TextUtil.formatPrint(ans);
        ConvertUtil.convertString2File(ansFilePath,orgTextPath+"\n"+newTextPath +"\n"
                +"Similar Score ：" + ansString);
        //控制台输出
        System.out.println("Similar Score  : "+ ansString + "\n");
    }



}
