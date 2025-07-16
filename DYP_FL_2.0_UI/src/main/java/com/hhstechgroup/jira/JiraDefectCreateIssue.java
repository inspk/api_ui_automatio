package com.hhstechgroup.jira;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
public @interface JiraDefectCreateIssue {
    boolean isCreateIssue();
}
