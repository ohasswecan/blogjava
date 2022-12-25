package com.ctfstar.myblog.web.service.impl;

import com.ctfstar.myblog.web.dao.TypeRepository;
import com.ctfstar.myblog.web.exception.NotFoundException;
import com.ctfstar.myblog.web.pojo.Type;
import com.ctfstar.myblog.web.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    public TypeRepository typeRepository;
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type t=typeRepository.findById(id).get();
        if(t==null){
            throw new NotFoundException("分类不存在");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }


    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort=Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable= PageRequest.of(0,size,sort);

        return typeRepository.findTop(pageable);
    }
}
