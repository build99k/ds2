package com.example.ds2.service;

import com.example.ds2.dto.FilteredContributor;
import com.example.ds2.feign.client.GitHubFeignClient;
import com.example.ds2.dto.Contributor;
import com.example.ds2.mapstruct.GitHubMapstruct;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitHubFeignService {

  private final GitHubFeignClient gitHubFeignClient;

  public List<Contributor> getContributor(String owner, String repo) {
    return gitHubFeignClient.getContributor(owner, repo);
  }

  public List<FilteredContributor> getFilteredContributor(String owner, String repo) {
    return gitHubFeignClient.getContributor(owner, repo)
                            .stream()
                            .map(GitHubMapstruct.INSTANCE::toFilteredContributor)
                            .collect(Collectors.toList());
  }
}
