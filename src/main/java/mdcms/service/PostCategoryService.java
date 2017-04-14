package mdcms.service;

import java.util.List;

import mdcms.model.PostCategory;

public interface PostCategoryService {

    void addCategory(PostCategory postCategory);

    List<PostCategory> getCategories();

    PostCategory getCategory(int categoryId);

    void deleteCategory(int categoryId);

}