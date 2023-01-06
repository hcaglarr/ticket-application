package com.hcaglar.ticketapplication.service;

import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
public interface IBaseService<T, U, S> extends Serializable {
    S findById(T id);
    Page<S> findAll(Integer page, Integer size);
    S save(U obj);
    S update(U U, T id);
    void deleteById(T id);
}
