package com.chao.blog.service;

import com.chao.blog.vo.CategoryVo;
import com.chao.blog.vo.Result;

public interface CategoryService {

    //根据id查找Category
    CategoryVo findCategoryByIds(Long categoryId);

    Result findeAll();

    Result findeAllDetail();

    Result categoryDetailById(Long id);
}
