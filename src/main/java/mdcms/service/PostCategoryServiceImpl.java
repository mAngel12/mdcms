package mdcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mdcms.model.PostCategory;
import mdcms.dao.PostCategoryDao;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    private PostCategoryDao postCategoryDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addCategory(PostCategory postCategory) {
        postCategoryDao.addCategory(postCategory);
    }

    @Override
    public List<PostCategory> getCategories() {
        return postCategoryDao.getCategories();
    }

    @Override
    public PostCategory getCategory(int category_id) {
        return postCategoryDao.getCategory(category_id);
    }

    @Override
    public void deleteCategory(int category_id) {
        postCategoryDao.deleteCategory(category_id);
    }

}