package com.lihao.web.person;

import com.lihao.bean.BookCategory;
import com.lihao.bean.ResponsePack;
import com.lihao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class CategoryServlet {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/select/book/category")
    public ResponsePack<List<BookCategory>> select_book_category(){
        ResponsePack<List<BookCategory>> responsePack = new ResponsePack<>();
        responsePack.setData(categoryService.select_all_category());
        responsePack.setSuccess(true);
        return responsePack;
    }
}
