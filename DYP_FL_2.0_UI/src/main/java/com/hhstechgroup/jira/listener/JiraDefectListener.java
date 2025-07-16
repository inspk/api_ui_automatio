package com.hhstechgroup.jira.listener;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.hhstechgroup.jira.JiraServiceProvider;
import com.hhstechgroup.jira.JiraDefectCreateIssue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class JiraDefectListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraDefectCreateIssue.class).isCreateIssue();
        if (islogIssue) {
            String filePath = "src/main/java/com/hhstechgroup/jira/properties/jiraConfigurationFile.properties";
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String hhsJiraWebSite = prop.getProperty("jiraURL");
            String userName = prop.getProperty("jirausername");
            String apiKey = prop.getProperty("jiraapitoken");
            String projectKey = prop.getProperty("jiraproject");

            //JiraServiceProvider Param: JIRA Website, User Name, API Key, Project Key
            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider(hhsJiraWebSite,userName,apiKey,projectKey);
            String issueDescription = "Failure Reason from Automation Testing\n\n" + result.getThrowable().getMessage() + "\n";
            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " Failed in Automation Testing";
            JiraServiceProvider.createJiraIssue("Defect", issueSummary, issueDescription, userName);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

}
