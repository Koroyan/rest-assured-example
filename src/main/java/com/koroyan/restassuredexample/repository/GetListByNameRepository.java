package com.koroyan.restassuredexample.repository;

import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;

public interface GetListByNameRepository {
    GetListByNameResult getListByName(String name);
}