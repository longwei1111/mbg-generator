package com.lw.mbgcomment.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Classname MySQLCommentGenerator
 * @Description 自定义注释
 * @Date 2019/12/6 13:32
 * @Author lw
 */
public class MyCommentGenerator extends EmptyCommentGenerator {

    private Properties properties;

    public MyCommentGenerator() {
        properties = new Properties();
    }

    /**
     * 添加配置属性
     *
     * @param properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
    }

    /**
     * 模型类注释
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();
        // 组装注释模板
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks + "实体类");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date   " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    /**
     * 字段注释
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        // 组装注释模板
        field.addJavaDocLine("/** " + remarks + " */");
    }

}
