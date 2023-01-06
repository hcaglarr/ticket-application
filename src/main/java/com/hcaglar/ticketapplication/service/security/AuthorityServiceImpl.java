package com.hcaglar.ticketapplication.service.security;

import com.hcaglar.ticketapplication.dto.request.AuthorityRequest;
import com.hcaglar.ticketapplication.dto.response.AuthorityResponse;
import com.hcaglar.ticketapplication.exception.EmptyOrNullException;
import com.hcaglar.ticketapplication.repository.AuthorityRepository;
import com.hcaglar.ticketapplication.service.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.hcaglar.ticketapplication.converter.AuthorityConverter.INSTANCE;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Service
public class AuthorityServiceImpl implements IBaseService<Integer, AuthorityRequest, AuthorityResponse> {
    private final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public AuthorityResponse findById(Integer id) {
        var authority = authorityRepository
                .findById(id).orElseThrow(
                        () -> new EmptyOrNullException(
                                this.getClass().getName(),
                                "findById method id is empty or not found."));

        return INSTANCE.convert(authority);
    }

    @Override
    public Page<AuthorityResponse> findAll(Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        var pageAuthorities = authorityRepository.findAll(pageRequest);

        return INSTANCE.convert(pageAuthorities);
    }

    @Override
    @Transactional
    public AuthorityResponse save(AuthorityRequest authorityRequest) {
        var authority = INSTANCE.convert(authorityRequest);
        var registeredAuthority = authorityRepository.save(authority);

        return INSTANCE.convert(registeredAuthority);
    }

    @Override
    @Transactional
    public AuthorityResponse update(AuthorityRequest authorityRequest, Integer id) {
        var registeredAuthority = authorityRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));
        authorityRequest.setId(registeredAuthority.getId());

            return this.save(authorityRequest);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        var authority = authorityRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));

        authorityRepository.delete(authority);
    }
}
