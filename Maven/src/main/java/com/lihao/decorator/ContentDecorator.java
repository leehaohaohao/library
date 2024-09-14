package com.lihao.decorator;

import com.lihao.bean.Content;
import com.lihao.bean.Page;
import com.lihao.service.ContentService;

import jakarta.servlet.http.HttpServletRequest;

public class ContentDecorator<T> implements ContentService<T> {
    boolean isCheck;
    private ContentService<T> contentService ;
    public ContentDecorator(ContentService<T> contentService,boolean isCheck){
        this.contentService=contentService;
        this.isCheck=isCheck;
    }
    @Override
    public T excute(HttpServletRequest request, Page page, Content content) {
        if(isCheck){

        }
        T result = contentService.excute(request,page,content);
        return result;
    }
}
