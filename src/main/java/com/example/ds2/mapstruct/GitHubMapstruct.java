package com.example.ds2.mapstruct;

import com.example.ds2.dto.Contributor;
import com.example.ds2.dto.FilteredContributor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GitHubMapstruct {
  GitHubMapstruct INSTANCE = Mappers.getMapper(GitHubMapstruct.class);

  FilteredContributor toFilteredContributor(Contributor contributor);
}
