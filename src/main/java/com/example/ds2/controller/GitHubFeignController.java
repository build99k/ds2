package com.example.ds2.controller;

import com.example.ds2.dto.Contributor;
import com.example.ds2.dto.FilteredContributor;
import com.example.ds2.service.GitHubFeignService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GitHubFeignController {

  private final GitHubFeignService gitHubFeignService;

  @GetMapping(value = "/v1/github/{owner}/{repo}")
  public List<Contributor> getGitHubContributors(@PathVariable String owner, @PathVariable String repo) {
    return gitHubFeignService.getContributor(owner, repo);
  }

  @GetMapping(value = "/v1/filter/github/{owner}/{repo}")
  public List<FilteredContributor> getGitHubFilteredContributors(@PathVariable String owner, @PathVariable String repo) {
    return gitHubFeignService.getFilteredContributor(owner, repo);
  }

}
