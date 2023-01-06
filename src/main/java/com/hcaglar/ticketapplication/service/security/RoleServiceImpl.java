package com.hcaglar.ticketapplication.service.security;

import com.hcaglar.ticketapplication.dto.request.RoleRequest;
import com.hcaglar.ticketapplication.dto.response.RoleResponse;
import com.hcaglar.ticketapplication.exception.EmptyOrNullException;
import com.hcaglar.ticketapplication.repository.RoleRepository;
import com.hcaglar.ticketapplication.service.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.hcaglar.ticketapplication.converter.RoleConverter.INSTANCE;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Service
public class RoleServiceImpl implements IBaseService<Integer, RoleRequest, RoleResponse> {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse findById(Integer id) {
        var role = roleRepository
                .findById(id).orElseThrow(
                        () -> new EmptyOrNullException(
                                this.getClass().getName(),
                                "findById method id is empty or not found."));

        return INSTANCE.convert(role);
    }

    @Override
    public Page<RoleResponse> findAll(Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        var pageRoles = roleRepository.findAll(pageRequest);

        return INSTANCE.convert(pageRoles);
    }

    @Override
    @Transactional
    public RoleResponse save(RoleRequest roleRequest) {
        var role = INSTANCE.convert(roleRequest);
        var registeredRole = roleRepository.save(role);

        return INSTANCE.convert(registeredRole);
    }

    @Override
    @Transactional
    public RoleResponse update(RoleRequest roleRequest, Integer id) {
        var registeredRole = roleRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));
            roleRequest.setId(registeredRole.getId());

            return this.save(roleRequest);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        var role = roleRepository.findById(id)
                .orElseThrow(() -> new EmptyOrNullException(
                        this.getClass().getName(),
                        "update method id is empty or not found."));

        roleRepository.delete(role);
    }
}
