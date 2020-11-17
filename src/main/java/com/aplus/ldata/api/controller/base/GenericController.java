package com.aplus.ldata.api.controller.base;

import java.util.List;

public interface GenericController<E> {

    public ApiResponse<Boolean> create(E data);

    public ApiResponse<Boolean> delete(E data);

    public ApiResponse<List<E>> getAll(E data);

    public ApiResponse<E> find(String uuid);
}
