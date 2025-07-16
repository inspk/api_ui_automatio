package com.hhstechgroup.jira;

import com.hhstechgroup.common.Reports;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
    private JiraClient Jira;
    private String project;
    private String JiraUrl;


    public JiraServiceProvider(String JiraUrl, String username, String password, String project) {
        this.JiraUrl=JiraUrl;
        // create basic authentication object
        BasicCredentials creds = new BasicCredentials(username, password);
        // initialize the Jira client with the url and the credentials
        Jira = new JiraClient(JiraUrl, creds);
        this.project = project;
    }

    public void createJiraIssue(String issueType, String summary, String description, String reporterName) {
        try {
            //Avoid Creating Duplicate Issue with same summary and not in the status Closed, Done and Cancelled
            Issue.SearchResult sr = Jira.searchIssues("summary ~ \"" + summary + "\"" + " and status not in (Closed, Done, CANCELLED)" );
            if(sr.total!=0) {
                Reports.log("********************************************");
                Reports.log("Same Issue Already Exists on Jira!");
                Reports.log("********************************************");
                return;
            }
            //Create issue if not exists
            FluentCreate fleuntCreate = Jira.createIssue(project, issueType);
            fleuntCreate.field(Field.SUMMARY, summary);
            fleuntCreate.field(Field.DESCRIPTION, description);
            Issue newIssue = fleuntCreate.execute();
            Reports.log("********************************************");
            Reports.log("New issue created in Jira with ID: " + newIssue);
            Reports.log("New issue URL is :"+JiraUrl+"/browse/"+newIssue);
            Reports.log("*******************************************");
        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}