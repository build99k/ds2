package com.example.ds2.feign.client2;


import com.example.ds2.dto.Contributor;
import com.example.ds2.dto.Issue;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHubBuilderClient {

  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("GET /repos/{owner}/{repo}/issues")
  List<Issue> getIssues(@Param("owner") String owner, @Param("repo") String repo);

}
