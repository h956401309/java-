package com.chao.blog.vo.params;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.chao.blog.vo.CategoryVo;
import com.chao.blog.vo.TagVo;
import lombok.Data;
import java.util.List;

@Data
public class ArticleParam {

    @JSONField(serializeUsing= ToStringSerializer.class)
    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;

}
