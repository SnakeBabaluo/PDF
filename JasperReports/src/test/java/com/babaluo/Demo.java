package com.babaluo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建日期 : 2020/11/3 16:30
 */
public class Demo {

    @Test
    public void Demo() throws Exception{
        //定义模板路径
        String jrxml="F:\\就业班\\day52-传智健康\\day09_PDF报表\\资料\\pdf模板文件\\demo.jrxml";
        //定义编译后的路径
        String jasper="g:\\JasperReports.jasper";
        //编译模板文件
        JasperCompileManager.compileReportToFile(jrxml,jasper);
        //构建数据
        Map map=new HashMap();
        map.put("reportDate",new SimpleDateFormat("yyyy'年'MM'月'dd'日 北京时间' HH:mm:ss").format(new Date(System.currentTimeMillis())));
        map.put("company","霸霸羅");
        List<Map> list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("name","捞森");
        map1.put("address","beijing");
        map1.put("email","xiaoming@itcast.cn");
        Map map2 = new HashMap();
        map2.put("name","xiaoli");
        map2.put("address","nanjing");
        map2.put("email","xiaoli@itcast.cn");
        list.add(map1);
        list.add(map2);

        //填充数据
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, map, new JRBeanCollectionDataSource(list));
        //导出保存
        String pdfPath="g:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);

    }

    /**
     * 打印当前日期
     */
    @Test
    public void ff(){
        System.out.println(new SimpleDateFormat("yyyy'年'MM'月'dd'日' HH:mm:ss z").format(new Date(System.currentTimeMillis())));
    }
}
