package mdcms.dao;

import java.util.List;

import mdcms.model.PostCategory;

public interface PostCategoryDao {

    void addCategory(PostCategory postCategory);

    List<PostCategory> getCategories();

    PostCategory getCategory(int category_id);

    void deleteCategory(int category_id);
}