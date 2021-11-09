package com.spring.crud.repository;

import com.spring.crud.models.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPage extends PagingAndSortingRepository<UserModel, Long> {

}
