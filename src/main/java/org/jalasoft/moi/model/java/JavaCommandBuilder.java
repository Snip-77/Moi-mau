/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.java;

import org.jalasoft.moi.model.core.ICommandBuilder;

import java.nio.file.Path;

/**
 * Builds a command for java compilation and execution.
 *
 * @version 1.0 03 March 2020
 * @author Mauricio Oroza
 *
 */
public class JavaCommandBuilder implements ICommandBuilder {

    private static final String JAVA_COMPLILE = "javac ";
    private static final String JAVA_RUN = "java ";
    private static String mainName;
    private static String folderPath;

    /**
     * @param completePath contains the location of the directory or file
     * @return String of the command builded with the path Params
     */
    @Override
    public String buildCommand(Path completePath) {
        folderPath = completePath.toString();
        mainName = completePath.getFileName().toString().replace(".java"," ");
        String allFiles = "\\*.java";
        String fileMain = " MainClass";
        return JAVA_COMPLILE + folderPath + allFiles + " && " + JAVA_RUN + "-cp " + folderPath + fileMain;
    }
}
