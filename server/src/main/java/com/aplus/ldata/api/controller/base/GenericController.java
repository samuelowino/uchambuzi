package com.aplus.ldata.api.controller.base;

import java.util.List;

public interface GenericController<E> {

    public ApiResponse<Boolean> create(E data);

    public List<E> getAll();

    public ApiResponse<E> find(String uuid);
}
